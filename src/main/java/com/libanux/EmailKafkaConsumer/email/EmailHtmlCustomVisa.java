package com.libanux.EmailKafkaConsumer.email;

import com.libanux.EmailKafkaConsumer.models.TourismVisaKafka;
import org.apache.commons.lang3.text.WordUtils;

public class EmailHtmlCustomVisa {

    public static String buildEmail(TourismVisaKafka tourismVisa) {
        String fullName = WordUtils.capitalize(tourismVisa.fullName());
        String phoneNumber = tourismVisa.phoneNumber().length() != 0 ? tourismVisa.phoneNumber() : "No Phone Number";
        String email = tourismVisa.email().length() != 0 ? tourismVisa.email() : "No Email" ;
        String dateOfBirth = tourismVisa.dateOfBirth();
        String passportCountry = tourismVisa.passportCountry();
        String visaStatus = tourismVisa.visaStatus();
        String explain = tourismVisa.explain();
        String gender = tourismVisa.gender();

        String desiredCountry = tourismVisa.desiredCountry();;


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
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Visa: " + fullName + ",</p>" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Tourism Visa Sent </p>" +
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
                "            <p><strong>Visa Status:</strong> " + visaStatus + "</p>" +
                "            <p><strong>Explain Visa Status:</strong> " + explain + "</p>" +

                "            <p><strong>desiredCountry:</strong> " + desiredCountry + "</p>" +


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
