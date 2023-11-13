package com.libanux.EmailKafkaConsumer.models;

public record ImmigrationKafkaModel(byte[] cv, byte[] image,String jsonBody) {
}
