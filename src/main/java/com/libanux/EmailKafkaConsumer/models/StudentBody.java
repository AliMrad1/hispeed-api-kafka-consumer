package com.libanux.EmailKafkaConsumer.models;

public record StudentBody(
        long id,
        String fullName,
        String dateOfBirth,
        String passportCountry,
        String currentResidence,
        String visaStatus,
        String explain,
        String exam,
        String degree,
        String desiredCountry,
        boolean doYouHaveScholarship,
        String phoneNumber,
        String email,
        String gender
) {
}
