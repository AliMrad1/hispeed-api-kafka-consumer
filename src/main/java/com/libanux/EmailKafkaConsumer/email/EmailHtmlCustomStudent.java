package com.libanux.EmailKafkaConsumer.email;

import com.libanux.EmailKafkaConsumer.models.StudentKafkaModel;
import org.apache.commons.lang3.text.WordUtils;

public class EmailHtmlCustomStudent {
    public static String buildEmail(StudentKafkaModel programRequest) {
//            long id = immigration.getId();
        String fullName = WordUtils.capitalize(programRequest.fullName());
        String phoneNumber = !programRequest.phoneNumber().isEmpty() ? programRequest.phoneNumber() : "No Phone Number";
        String email = !programRequest.email().isEmpty() ? programRequest.email() : "No Email" ;
        String dateOfBirth = programRequest.dateOfBirth();
        String passportCountry = programRequest.passportCountry();
        String currentResidence = programRequest.currentResidence();
        String visaStatus = programRequest.visaStatus();
        String desiredCountry = programRequest.desiredCountry();
        var list = programRequest.listOfQualification();
        var degree = programRequest.degree();
        var exam = programRequest.exam();
        var explain = programRequest.explain();
        String gender = programRequest.gender();

        boolean doYouhaveScholarship = programRequest.doYouhaveScholarship();
        String temp;
        if(doYouhaveScholarship){
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
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Student " + fullName + ",</p>" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Student Program Sent </p>" +
                "            <blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\">" +
                "              <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">" +
                "              </p>" +
                "            </blockquote>\n" +
                "            <!-- Include immigration properties values -->" +
                "            <p><strong>Full Name:</strong> " + fullName + "</p>" +
                "            <p><strong>Phone Number:</strong> " + phoneNumber + "</p>" +
                "            <p><strong>Email:</strong> " + email + "</p>" +
                "            <p><strong>gender:</strong> " + gender + "</p>" +
                "            <p><strong>Date of Birth:</strong> " + dateOfBirth + "</p>" +
                "            <p><strong>Passport Country:</strong> " + passportCountry + "</p>" +
                "            <p><strong>Current Residence:</strong> " + currentResidence + "</p>" +
                "            <p><strong>Visa Status:</strong> " + visaStatus + "</p>" +
                "            <p><strong>Explain Visa Status:</strong> " + explain + "</p>" +

                "            <p><strong>desiredCountry:</strong> " + desiredCountry + "</p>" +

                "            <p><strong>degree:</strong> " + degree + "</p>" +
                "            <p><strong>exam:</strong> " + exam + "</p>" +
                "            <p><strong>doYouhaveScholarship:</strong> " + doYouhaveScholarship + "</p>" +


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
