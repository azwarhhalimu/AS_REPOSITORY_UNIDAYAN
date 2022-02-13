package com.example.repositoriunidayan.pg;

public class Pg_subjek {
    public  static String main(String list)
    {
        return
                 "<!DOCTYPE html>\n" +
                         "<html lang=\"en\">\n" +
                         "  <head>\n" +
                         "    <meta charset=\"UTF-8\" />\n" +
                         "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                         "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                         "    <title>Document</title>\n" +
                         "      <style>html body{user-select:none;}</style>"+
                         "  \n" +
                         "  </head>\n" +
                         "  <body>\n" +
                                list+
                         "  </body>\n" +
                         "</html>\n";
    }
    public static String list(int index,String  id_subjek, String subjek, String jumlah)
    {
        return "    <div style=\"margin-bottom: 10px\">\n" +
                "      <table cellspacing=\"0px\" width=\"100%\" border=\"0px \">\n" +
                "        <tr>\n" +
                "          <td width=\"10%\" style=\"text-align: center; font-weight: bold\">"+(index+1)+"</td>\n" +
                "          <td>\n" +
                "            <div style=\"opacity: 0.8; color: #fff; background: #ff6d6d; padding: 10px; border-radius: 3px\">\n" +
                "              "+subjek+"\n" +
                "              <div style=\"font-size: 10px; margin-top: 5px\">"+jumlah+" Karya Tulis</div>\n" +
                "            </div>\n" +
                "          </td>\n" +
                "          <td width=\"40px\" style=\"text-align: right\">\n" +
                "            <table width=\"37px\">\n" +
                "              <tr>\n" +
                "                <td" +
                "            onclick=\"return window.location='http://sub.subjek/"+id_subjek+"'\"" +
                " style=\"border: 1px solid #dfdfdf; height: 30px; height: 30px; border-radius: 100%\" valign=\"middle\" align=\"center\">\n" +
                "                  <img src=\"right.png\" style=\"width: 10px; opacity: 0.7\" />\n" +
                "                </td>\n" +
                "              </tr>\n" +
                "            </table>\n" +
                "          </td>\n" +
                "        </tr>\n" +
                "      </table>\n" +
                "    </div>\n";
    }
}
