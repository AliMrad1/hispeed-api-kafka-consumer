package com.libanux.EmailKafkaConsumer.models;

public record StudentKafkaModel(
        byte[] certificate, String jsonBody
) {
}
