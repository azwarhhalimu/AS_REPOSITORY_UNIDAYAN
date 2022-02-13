package com.example.repositoriunidayan.pg;

public class Pg_list_repository_subjek {
    public static String main(String list, String subjek, String sub_subjek)
    {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <link rel=\"stylesheet\" href=\"bootstrap.min.css\" />\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                " html body{user-select:none}"+
                "      .kard {\n" +
                "        opacity: 0.9;\n" +
                "        box-shadow: 0px 0px 21px 0px rgba(158, 156, 156, 0.75);\n" +
                "        -webkit-box-shadow: 0px 0px 21px 0px rgba(158, 156, 156, 0.75);\n" +
                "        -moz-box-shadow: 0px 0px 21px 0px rgba(158, 156, 156, 0.75);\n" +
                "        border: 1px solid #fafafa;\n" +
                "        width: 100%;\n" +
                "        padding: 10px;\n" +
                "        border-radius: 5px;\n" +
                "        padding: 10px;\n" +
                "        margin-bottom: 15px;\n" +
                "      }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div style=\"padding: 10px\">\n" +
                        "<div style='font-weight:Bold;'>"+subjek+"</div>"+
                        "<div style='font-size:10px; opacity:0.7;;'>"+sub_subjek+"</div>"+
                        list+

                "    </div>\n" +
                "  </body>\n" +
                "</html>\n";
    }
    public static String list(String id_repository, String judul, String fakultas,
                              String jurusan,
                              String tanggal,
                              String tahun,
                              String subjek, String sub_subjek
                              )
    {
        return "      <div onclick=\"return window.location='htpp://lihat.repository/"+id_repository+"'\" class=\"kard\">\n" +
                "        <div style=\"font-weight: bold\">"+judul+"</div>\n" +
                "        <div style=\"font-size: 9px; opacity: 0.6; margin-top: 4px\">Fakultas "+fakultas+" &raquo; "+jurusan+"</div>\n" +
                "        <div style=\"margin-bottom: 23px\">\n" +
                "<div class=\"float-left\" style=\"font-size:11px;\">"+tanggal+"</div>"+
                "          <span class=\"badge badge-success float-right\" style=\"font-size: 10px\">"+tahun+"</span>\n" +
                "        </div>\n" +
                "       <div style=\"height: 1px; background: #dfdfdf; margin-top: 10px\"></div>\n" +
                "        <div style=\"font-size: 10px;margin-top:10px\">\n" +
                "          <table width=\"100%\" border=\"0px\">\n" +
                "            <tr>\n" +
                "              <td>"+subjek+" &raquo; "+sub_subjek+"</td>\n" +
                "              <td width=\"20%\"></td>\n" +
                "            </tr>\n" +
                "          </table>\n" +
                "        </div>"+
                "      </div>\n";
    }
}
