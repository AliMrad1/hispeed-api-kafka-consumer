package com.libanux.EmailKafkaConsumer.models;

public record ImigrationBody(
        int id,
        String FullName,
        String dateofbirth,
        String passportCountry,
        String CurrentResidence,
        String visaStatus,
        String explainVisaStatus,

        boolean holdQualification,

        String listTypeOfQualification,
        String englishProficiency,
        boolean isCompleteEngishTest,
        boolean doYouHaveOffer,
        String profession,
        String yearsOfExperience,
        String education,
        String desiredCountry,
        String gender,

        String filename,
        String phoneNumber,
        String email,
        String professionOther,
        String imageFile
) {
}
