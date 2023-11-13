package com.libanux.EmailKafkaConsumer.email;

import com.libanux.EmailKafkaConsumer.models.ApplyForAJobBody;
import org.apache.commons.lang3.text.WordUtils;

public class EmailApplyCustom {

    public static String buildEmail(ApplyForAJobBody apply) {
//            long id = apply.getId();

        String fullName = WordUtils.capitalize(apply.fullName());
        String phoneNumber = !apply.phoneNumber().isEmpty() ? apply.phoneNumber() : "No Phone Number";
        String email = !apply.email().isEmpty() ? apply.email() : "No Email" ;

        String dateOfBirth = apply.dateofbirth();
        String passportCountry = apply.passportCountry();
        String currentResidence = apply.currentResidence();
        String desiredCountry = apply.desiredCountry();
        String education = apply.education();
        String profession = apply.profession();
        String yearofExp = apply.yearsOfExperience();
        String gender = apply.gender();
        String englishProficiency = apply.englishProficiency();
        boolean completeEngishTest = apply.completeEnglishTest();
        String temp;
        if(completeEngishTest){
            temp = "Yes";
        }else{
            temp = "NO";
        }

        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\"></span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">" + fullName + ",</p>" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Apply For A Job Sent </p>" +
                "            <blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\">" +
                "              <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">" +
                "              </p>" +
                "            </blockquote>\n" +
                "            <!-- Include apply properties values -->" +
                "            <p><strong>Full Name:</strong> " + fullName + "</p>" +
                "            <p><strong>Phone Number:</strong> " + phoneNumber + "</p>" +
                "            <p><strong>Email:</strong> " + email + "</p>" +
                "            <p><strong>gender:</strong> " + gender + "</p>" +

                "            <p><strong>Date of Birth:</strong> " + dateOfBirth + "</p>" +
                "            <p><strong>Passport Country:</strong> " + passportCountry + "</p>" +
                "            <p><strong>Current Residence:</strong> " + currentResidence + "</p>" +
                "            <p><strong>English Proficiency:</strong> " + englishProficiency + "</p>" +
                "            <p><strong>desiredCountry:</strong> " + desiredCountry + "</p>" +

                "            <p><strong>Profession:</strong> " + profession + "</p>" +
                "            <p><strong>education:</strong> " + education + "</p>" +
                "            <p><strong>Year Of Experience:</strong> " + yearofExp + "</p>" +
                "            <p><strong>Complete English Test:</strong> " + temp + "</p>" +

                "            <!-- Add more properties as needed -->" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }
}
