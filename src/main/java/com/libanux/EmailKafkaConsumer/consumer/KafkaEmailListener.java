package com.libanux.EmailKafkaConsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.libanux.EmailKafkaConsumer.email.EmailHtmlCustom;
import com.libanux.EmailKafkaConsumer.email.EmailHtmlCustomStudent;
import com.libanux.EmailKafkaConsumer.email.EmailHtmlCustomVisa;
import com.libanux.EmailKafkaConsumer.email.EmailService;
import com.libanux.EmailKafkaConsumer.models.ImigrationBody;
import com.libanux.EmailKafkaConsumer.models.ImmigrationKafkaModel;
import com.libanux.EmailKafkaConsumer.models.StudentKafkaModel;
import com.libanux.EmailKafkaConsumer.models.TourismVisaKafka;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaEmailListener {

    public static final String MAIL = "am8396280@gmail.com";
    private final EmailService emailService;

    public KafkaEmailListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(
            topics = "immigrations",
            groupId = "groupId1"
    )
    void _listenerImmigration(ConsumerRecord<String, String> record){
      // record ( byte[], string json)
        ObjectMapper objectMapper = new ObjectMapper();
        ImmigrationKafkaModel immigrationKafkaModel = null;
        ImigrationBody imigrationBody =null;
        try {
            immigrationKafkaModel = objectMapper.readValue(record.value(), ImmigrationKafkaModel.class);
            /*
            * get json string from ImmigrationKafkaModel
            * and map it to ImmigrationJson class by ObjectMapper again
            * */
            imigrationBody = objectMapper.readValue(immigrationKafkaModel.jsonBody(), ImigrationBody.class);
            emailService.send(
                MAIL,
                EmailHtmlCustom.buildEmail(imigrationBody),
                immigrationKafkaModel.cv(),
                new StringBuilder(imigrationBody.FullName())
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("Listener received: " + immigrationKafkaModel.jsonBody());
    }

    @KafkaListener(
            topics = "students",
            groupId = "groupId2"
    )
    void _listenerStudents(ConsumerRecord<String, String> record){
        ObjectMapper objectMapper = new ObjectMapper();
        StudentKafkaModel studentKafkaModel = null;
        try {
            studentKafkaModel = objectMapper.readValue(record.value(), StudentKafkaModel.class);
            emailService.send(MAIL,
                    EmailHtmlCustomStudent.buildEmail(studentKafkaModel),
                    studentKafkaModel.fullName()
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("Listener received: " + studentKafkaModel.email());
    }

    @KafkaListener(
            topics = "tourisms",
            groupId = "groupId3"
    )
    void _listenerTourism(ConsumerRecord<String, String> record){
        ObjectMapper objectMapper = new ObjectMapper();
        TourismVisaKafka tourismVisaKafka = null;
        try {
            tourismVisaKafka = objectMapper.readValue(record.value(), TourismVisaKafka.class);
            emailService.send(MAIL,
                    EmailHtmlCustomVisa.buildEmail(tourismVisaKafka),
                    tourismVisaKafka.fullName()
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("Listener received: " + tourismVisaKafka.email());
    }
}
