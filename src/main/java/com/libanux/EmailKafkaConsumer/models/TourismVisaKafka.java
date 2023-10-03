package com.libanux.EmailKafkaConsumer.models;

public record TourismVisaKafka(
        String fullName,
        String dateOfBirth,
        String passportCountry,
        String visaStatus,
        String explain,
        String desiredCountry,
        String phoneNumber,
        String email,
        String gender,
        String currentResidence

) {
}
