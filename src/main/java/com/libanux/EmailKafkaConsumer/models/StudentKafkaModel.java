package com.libanux.EmailKafkaConsumer.models;

public record StudentKafkaModel(

        String fullName,
        String dateOfBirth,
        String passportCountry,
        String currentResidence,
        String visaStatus,
        String explain,
        String listOfQualification,
        String exam,
        String degree,
        String desiredCountry,
        boolean doYouhaveScholarship,
        String phoneNumber,
        String email,
        String gender
) {
}
