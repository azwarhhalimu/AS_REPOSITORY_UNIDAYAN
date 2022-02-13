package com.example.repositoriunidayan.pg;

public class Pg_fakultas {
    public static String main( String list)
    {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <title>Document</title>\n" +
                " <style>\n" +
                " html body{user-select:none}"+
                "      #clink{\n" +
                "        opacity: 1;\n" +
                "      }\n" +
                "      #clink:hover{\n" +
                "        opacity: 0.3;\n" +
                "      }\n" +
                "    </style>"+
                "  </head>\n" +
                "  <body>\n" +

                         list+

                "  </body>\n" +
                "</html>\n";
    }
    public static String list(int index,String id_fakultas, String fakultas, String jurusan, String karya_tulis)
    {

        String color="#2bc8d9";
        String _color="#d9f5f8";
        if(index%2==0)
        {
             color="#948bff";
             _color="#eeebff";
        }
        return "    <div" +
                " id=\"clink\" "+
                " onclick=\"return window.location='http://lihat.jurusan/"+id_fakultas+"'\"  "+
                " style=\"margin-bottom: 10px\">\n" +
                "      <table cellspacing=\"0px\" border=\"0px\" style=\"border-radius: 3px\" width=\"100%\">\n" +
                "        <tr>\n" +
                "          <td width=\"3px\" style=\"background: "+color+"\"></td>\n" +
                "          <td style=\"padding: 10px; background: "+_color+"\">\n" +
                "            <span style=\"opacity: 0.6; font-weight:bold\">"+fakultas+"</span>\n" +
                "            <div style=\"opacity: 0.4; margin-top: 10px\">\n" +
                "              <table width=\"100%\">\n" +
                "                <tr>\n" +
                "                  <td width=\"50%\">"+jurusan+" Jurusan</td>\n" +
                "                  <td width=\"50%\" style=\"text-align: right\">"+karya_tulis+" Karya Tulis</td>\n" +
                "                </tr>\n" +
                "              </table>\n" +
                "            </div>\n" +
                "          </td>\n" +
                "        </tr>\n" +
                "      </table>\n" +
                "    </div>\n";
    }
}
