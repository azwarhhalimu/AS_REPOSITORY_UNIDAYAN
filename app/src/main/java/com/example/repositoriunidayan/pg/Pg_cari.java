package com.example.repositoriunidayan.pg;

public class Pg_cari {
    public  static String main(String data)
    {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <title>Document</title>\n" +
                "<style>#list{opacity:1;} #list:active{opacity:0.6;} html body{user-select:none;}</style>"+
                "  </head>\n" +
                "  <body>\n" +

data+
                "  </body>\n" +
                "</html>\n";
    }
    public static String list(String id_repository, String judul, String fakultas, String jurusan)
    {
        return "    <div id='list' onclick=\"return window.location='http://lihat.repository/"+id_repository+"'\" style=\"padding: 10px; border: 1px solid #dfdfdf; border-radius: 4px; margin: 15px\">\n" +
                "      <div>"+judul+"</div>\n" +
                "      <div style=\"font-size: 10px; opacity: 0.6\">"+fakultas+" | "+jurusan+"</div>\n" +
                "    </div>\n" ;
    }
}
