package com.libanux.EmailKafkaConsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.libanux.EmailKafkaConsumer.email.*;
import com.libanux.EmailKafkaConsumer.models.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaEmailListener {

    //
    public static final String MAIL = "visa@hispeed-group.com";
    public static final String MAIL1 = "HR@hispeed-group.com";
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

            if (immigrationKafkaModel.image() != null){
                emailService.send(
                        MAIL,
                        EmailHtmlCustom.buildEmail(imigrationBody),
                        immigrationKafkaModel.cv(),
                        immigrationKafkaModel.image(),
                        String.valueOf(imigrationBody.FullName())
                );
            }else{
                emailService.send(
                        MAIL,
                        EmailHtmlCustom.buildEmail(imigrationBody),
                        immigrationKafkaModel.cv(),
                        new StringBuilder(imigrationBody.FullName())
                );
            }

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
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        StudentKafkaModel studentKafkaModel = null;
        StudentBody studentBody =null;
        try {
            studentKafkaModel = objectMapper.readValue(record.value(), StudentKafkaModel.class);
            studentBody = objectMapper.readValue(studentKafkaModel.jsonBody(), StudentBody.class);

            if(studentKafkaModel.certificate() != null){
                emailService.send(MAIL,
                        EmailHtmlCustomStudent.buildEmail(studentBody),
                        studentKafkaModel.certificate(),
                        new StringBuilder(studentBody.fullName())
                );
            }
            else{
                emailService.send(MAIL,
                        EmailHtmlCustomStudent.buildEmail(studentBody),
                        studentBody.fullName()
                );
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("Listener received: " + studentBody.email());
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


    @KafkaListener(
            topics = "feedback",
            groupId = "groupId4"
    )
    void _listenerFeedback(ConsumerRecord<String, String> record){
        ObjectMapper objectMapper = new ObjectMapper();
        Feedback feedback = null;
        try {
            feedback = objectMapper.readValue(record.value(), Feedback.class);
            emailService.send(MAIL,
                    EmailFeedback.buildEmail(feedback),
                    "Contact Form"
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @KafkaListener(
            topics = "apply",
            groupId = "groupId4"
    )
    void _listenerApply(ConsumerRecord<String, String> record){
        ObjectMapper objectMapper = new ObjectMapper();
        ApplyForAJobKafkaModel applyKafkaModel = null;
        ApplyForAJobBody applyBody =null;
        try {
            applyKafkaModel = objectMapper.readValue(record.value(), ApplyForAJobKafkaModel.class);
            /*
             * get json string from ImmigrationKafkaModel
             * and map it to ImmigrationJson class by ObjectMapper again
             * */
            applyBody = objectMapper.readValue(applyKafkaModel.jsonBody(), ApplyForAJobBody.class);

            if (applyKafkaModel.image() != null){
                emailService.send(
                        MAIL1,
                        EmailApplyCustom.buildEmail(applyBody),
                        applyKafkaModel.cv(),
                        applyKafkaModel.image(),
                        String.valueOf(applyBody.fullName())
                );
            } else {
                emailService.send(
                        MAIL1,
                        EmailApplyCustom.buildEmail(applyBody),
                        applyKafkaModel.cv(),
                        new StringBuilder(applyBody.fullName())
                );
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("Listener received: " + applyKafkaModel.jsonBody());
    }
}
