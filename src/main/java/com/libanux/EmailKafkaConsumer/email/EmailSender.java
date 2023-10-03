package com.libanux.EmailKafkaConsumer.email;

public interface EmailSender {

    void send(String to, String email);
}
