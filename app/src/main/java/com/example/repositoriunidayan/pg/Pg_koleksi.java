package com.example.repositoriunidayan.pg;

public class Pg_koleksi {
    public static String main(String list)
    {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <title>Document</title>\n" +
                "    <link rel=\"stylesheet\" href=\"bootstrap.min.css\" />\n" +
                "<style>\n" +
                "html body{user-select:none;}"+
                "      #list {\n" +
                "        opacity: 1;\n" +
                "      }\n" +
                "      #list:active {\n" +
                "        opacity: 0.6;\n" +
                "      }\n" +
                "    </style>`"+
                "  </head>\n" +
                "  <body>\n" +
                "    <div style=\"opacity: 0.7; padding:10px\">\n" +
                "      <br />\n" +
                        list+
                "    </div>\n" +
                "  </body>\n" +
                "</html>\n";
    }
    public static String list(String id_koleksi, String koleksi, String jumlah )
    {
        return "      <div " +
                "onclick=\"return window.location='http://list.repository/"+id_koleksi+"'\"" +
                " id=\"list\" style=\"margin-bottom: 10px; background: #fff; border: 1px solid #dfdfdf; padding: 15px; border-radius: 4px\">\n" +
                "        <div style=\"font-weight: bold; opacity: 1; font-size: 12px\">"+koleksi+"</div>\n" +
                "        <span class=\"badge badge-danger float-right\" style=\"margin-top: -15px\">"+jumlah+"</span>\n" +
                "      </div>\n" ;
    }
}
