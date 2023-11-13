package com.libanux.EmailKafkaConsumer.models;

public record Feedback(  long id,
                        String firstName,
                        String lastName,
                        String email,
                        String service_type,
                        String messages) {
}
