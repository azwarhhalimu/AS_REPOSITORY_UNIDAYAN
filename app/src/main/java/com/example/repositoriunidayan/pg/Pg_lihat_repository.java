package com.example.repositoriunidayan.pg;

public class Pg_lihat_repository {
    public static String main(
            String id_repository,
            String judul, String koleksi,
            String fakultas, String jurusan,
            String subjek, String sub_subjek,
            String abstrak,
            String author,
            String pembimbing,
            String size

    )
    {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <title>Document</title>\n" +
                "    <link rel=\"stylesheet\" href=\"bootstrap.min.css\" />"+
                "    <style>\n" +
                " html body{user-select:none}"+
                "      html body {\n" +
                "        padding: 0px;\n" +
                "        margin: 0px;\n" +
                "        font-size:12px;"+
                "      }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "<div>\n" +
                "      <table class=\"table\">\n" +
                "        <tr style=\"font-weight: bold\">\n" +
                "          <td>Nama File</td>\n" +
                "          <td>Ukuran</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>"+id_repository+".pdf"+"</td>\n" +
                "          <td>"+size+"</td>\n" +
                "        </tr>\n" +
                "      </table>\n" +
                "    </div>"+
                "    <div style=\"padding: 10px\">\n" +
                "      <div style=\"font-weight: bold\">Judul</div>\n" +
                "      <div>"+judul+"</div>\n" +
                "    </div>\n" +
                "    <div style=\"height: 10px; background: #dfdfdf\"></div>\n" +

                "    <div style=\"padding: 10px\">\n" +
                "      <div style=\"font-weight: bold\">Koleksi</div>\n" +
                "      <div>"+koleksi+"</div>\n" +
                "    </div>\n" +
                "    <div style=\"height: 10px; background: #dfdfdf\"></div>\n" +


                "    <div style=\"padding: 10px\">\n" +
                "      <div style=\"font-weight: bold\">Author</div>\n" +
                "      <div>"+author+"</div>\n" +
                "    </div>\n" +
                "    <div style=\"height: 10px; background: #dfdfdf\"></div>\n" +
                "    <div style=\"padding: 10px\">\n" +
                "      <div style=\"font-weight: bold\">Pembimimbing</div>\n" +
                "      <div>"+pembimbing+"</div>\n" +
                "    </div>\n" +
                "    <div style=\"height: 10px; background: #dfdfdf\"></div>\n" +
                "    <div style=\"padding: 10px\">\n" +
                "      <div style=\"font-weight: bold\">Subjek / Sub Subjek</div>\n" +
                "      <div>"+subjek+" &roqoe; "+sub_subjek+"</div>\n" +
                "    </div>\n" +
                "    <div style=\"height: 10px; background: #dfdfdf\"></div>\n" +
                "    <div style=\"padding: 10px\">\n" +
                "      <div style=\"font-weight: bold\">Tahun Release</div>\n" +
                "      <div>Isi tahun release</div>\n" +
                "    </div>\n" +

                "    <div style=\"height: 10px; background: #dfdfdf\"></div>\n" +
                "    <div style=\"padding: 10px\">\n" +
                "      <div style=\"font-weight: bold\">Tahun Pembuatan</div>\n" +
                "      <div>Isi tahun Pembuatan</div>\n" +
                "    </div>\n" +
                "\n" +
                "    <div style=\"height: 10px; background: #dfdfdf\"></div>\n" +
                "    <div style=\"padding: 10px\">\n" +
                "      <div style=\"font-weight: bold\">Fakultas</div>\n" +
                "      <div>"+fakultas+" | "+jurusan+"</div>\n" +
                "    </div>\n" +
                "\n" +

                "    <div style=\"padding: 10px\">\n" +
                "      <div style=\"font-weight: bold\">Abstrak</div>\n" +
                "      <div style='text-align:justify;'>"+abstrak+"</div>\n" +
                "    </div>\n" +
                "    <div style=\"height: 10px; background: #dfdfdf\"></div>\n" +


                "  </body>\n" +
                "</html>\n";
    }

}
