package com.example.repositoriunidayan.pg;

public class Pg_sub_subjek {
    public static String main(String list)
    {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <title>Document</title>\n" +
                "       <style>html body{user-select:none;}</style>"+
                "  </head>\n" +
                "  <body>\n" +
                        list+
                "  </body>\n" +
                "</html>\n";
    }
    public static String list(String id_sub_subjek, String sub_subjek, String jumlah)
    {
        return "    <div " +
                "       onclick=\"return window.location='http://list.repository/"+id_sub_subjek+"'\"" +
                "style=\"margin-bottom:10px;padding: 10px; border: 1px solid #dfdfdf; border-radius: 5px\">\n" +
                "      <table width=\"100%\">\n" +
                "        <tr>\n" +
                "          <td>\n" +
                "            <div style=\"font-weight: bold; opacity: 0.6\">"+sub_subjek+"</div>\n" +
                "            <div style=\"font-size: 10px; margin-top: 5px\">"+jumlah+" Karya Tulis</div>\n" +
                "          </td>\n" +
                "          <td style=\"text-align: right\" width=\"20px\">\n" +
                "            <img src=\"right.png\" style=\"width: 15px\" alt=\"\" />\n" +
                "          </td>\n" +
                "        </tr>\n" +
                "      </table>\n" +
                "    </div>\n" ;
    }
}
