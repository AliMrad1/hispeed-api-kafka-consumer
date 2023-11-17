package com.libanux.EmailKafkaConsumer.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MimeTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Objects;


@Service
public class EmailService  {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.mailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String from;

    public void send(String to, String email, String fullName) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject(fullName);
            helper.setFrom(from);
            mailSender.send(mimeMessage);
        }catch (MessagingException e){
            LOGGER.error("failed to send email",e);
            throw new IllegalStateException("failed to send email");
        }
    }

    public void send(String to, String email, byte[] cv, StringBuilder fullname) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true,"utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject(fullname.append("_cv").toString());
            helper.setFrom(from);

            mailSender.send(mimeMessage);

        }catch (MessagingException e){
            LOGGER.error("failed to send email",e);
            throw new IllegalStateException("failed to send email");
        }
    }

    private final Detector detector = new DefaultDetector(MimeTypes.getDefaultMimeTypes());

    public void send(String to, String email, byte[] cv, byte[] image, String fullName) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);

            String cvExtension = null;
            try {
                cvExtension = detectExtension(cv);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String imageExtension = null;
            try {
                imageExtension = detectExtension(image);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            helper.setSubject(fullName + "_cv." + cvExtension);

            ByteArrayResource cvResource = new ByteArrayResource(cv);
            helper.addAttachment(fullName + "_cv." + cvExtension, cvResource);

            ByteArrayResource imageResource = new ByteArrayResource(image);
            helper.addAttachment(fullName + "_image." + imageExtension, imageResource);

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("Failed to send email", e);
            throw new IllegalStateException("Failed to send email");
        }
    }

    private String detectExtension(byte[] data) throws IOException {
        TikaInputStream tikaInputStream = TikaInputStream.get(data);
        MediaType mediaType = detector.detect(tikaInputStream, null);
        return mediaType.getSubtype();
    }
}
