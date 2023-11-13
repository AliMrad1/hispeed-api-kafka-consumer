package com.libanux.EmailKafkaConsumer.models;

public record ApplyForAJobKafkaModel(byte[] cv, byte[] image,String jsonBody) {
}
