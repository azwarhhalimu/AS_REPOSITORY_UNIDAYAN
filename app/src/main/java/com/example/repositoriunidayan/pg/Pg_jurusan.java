package com.example.repositoriunidayan.pg;

public class Pg_jurusan
{
    public static String main(String list, String fakultas)
    {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                " html body{user-select:none}"+
                "      html body {\n" +
                "        padding: 0px;\n" +
                "        margin: px;\n" +
                "      }\n" +
                "      #link {\n" +
                "        background: none;\n" +
                "      }\n" +
                "      #link:active {\n" +
                "        background: #dfdfdf;\n" +
                "      }\n" +
                "    </style>\n" +
                "    <link rel=\"stylesheet\" href=\"bootstrap.min.css\" />\n" +
                "  </head>\n" +
                "  <body>\n" +
                " <h5 style=\"margin-left:10px; margin-bottom:20px;\">Fakultas "+fakultas+"</h5>"+
                  list+
                "  </body>\n" +
                "</html>\n";
    }
    public static String list(int index, String id_jurusan, String jurusan, String jumlah)
    {
        return "    <div id=\"link\" onclick=\"return window.location='http://lihat.list_repository/"+id_jurusan+"'\" style=\"border: 1px solid #dfdfdf; padding: 10px\">\n" +
                "      <table width=\"100%\">\n" +
                "        <tr>\n" +
                "          <td style=\"font-size: 12px; font-weight: bold\">"+jurusan+"</td>\n" +
                "          <td width=\"10%\">\n" +
                "            <span class=\"badge badge-success\">"+jumlah+"</span>\n" +
                "          </td>\n" +
                "        </tr>\n" +
                "      </table>\n" +
                "    </div>\n";
    }
}
