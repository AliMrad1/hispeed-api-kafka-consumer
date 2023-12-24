package com.libanux.EmailKafkaConsumer.models;

public record ApplyForAJobBody(
        long id,
        String fullName,
        String dateofbirth,
        String passportCountry,
        String currentResidence,
        String englishProficiency,
        boolean completeEnglishTest,
        String profession,
        String yearsOfExperience,
        String education,
        String gender,
        String linkCv,
        String status,
        String phoneNumber,
        String email,
        String imageFile
) {
}
