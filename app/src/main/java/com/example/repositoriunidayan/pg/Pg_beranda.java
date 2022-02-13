package com.example.repositoriunidayan.pg;

public class Pg_beranda {
    public static String main(String populer,
                              String pilihan,
                              String lainnya
                              )
    {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\" />\n" +
                "    <title>Swiper demo</title>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1\" />\n" +
                "    <link rel=\"stylesheet\" href=\"bootstrap.min.css\" />\n" +
                "    <!-- Link Swiper's CSS -->\n" +
                "    <link rel=\"stylesheet\" href=\"swiper/dist/css/swiper.min.css\" />\n" +
                "\n" +
                "    <!-- Demo styles -->\n" +
                "    <style>\n" +
                "      html body {\n" +
                "        user-select: none;\n" +
                "      }\n" +
                "\n" +
                "      body {\n" +
                "        background: rgb(255, 255, 255);\n" +
                "        font-family: Helvetica Neue, Helvetica, Arial, sans-serif;\n" +
                "        font-size: 13px;\n" +
                "        color: rgb(123, 123, 123);\n" +
                "        margin: 0;\n" +
                "        padding: 0;\n" +
                "      }\n" +
                "\n" +
                "      .swiper-container {\n" +
                "        margin-bottom: 10px;\n" +
                "        width: 100%;\n" +
                "      }\n" +
                "\n" +
                "      .swiper-slide {\n" +
                "        border: 1px solid #dfdfdf;\n" +
                "        border-radius: 10px;\n" +
                "        text-align: center;\n" +
                "        font-size: 18px;\n" +
                "        background: #fff;\n" +
                "        width: 70%;\n" +
                "        height: 120px;\n" +
                "      }\n" +
                "\n" +
                "      .swiper-slide.c {\n" +
                "        height: 130px;\n" +
                "      }\n" +
                "\n" +
                "      .c:first-child {\n" +
                "        margin-left: 15px;\n" +
                "      }\n" +
                "      #list {\n" +
                "        margin-bottom: 20px;\n" +
                "        border-radius: 5px;\n" +
                "      }\n" +
                "  .list_data{ opacity:1} .list_data:active{opacity:0.6}"+
                "    </style>\n" +
                "  </head>\n" +
                "\n" +
                "  <body>\n" +
                "    <div style=\"background: #3366ff; color: #fff; padding: 15px\">\n" +
                "      <div>Sabtu,  22 Januari 2022</div>\n" +
                "      <div style=\"font-size: 16px; font-weight: bold\">Temukan ribuan karya tulis ilmiah Universitas Dayanu Ikshanuddin</div>\n" +
                "      <div style=\"height: 70px\"></div>\n" +
                "    </div>\n" +
                "\n" +
                "    <div style=\"width: 90%; border: 1px solid #dfdfdf; padding: 10px; margin: auto; background: #fff; margin-top: -50px; border-radius: 10px\">\n" +
                "      <div style=\"font-weight: bold; font-size: 14\">Masukkan pencarian</div>\n" +
                "      <input onclick='return window.location=\"http://go.cari\"' type=\"text\" class=\"btn btn-block btn-outline-light\" style=\"border: 1px solid #dfdfdf; color: #dfdfdf\" placeholder=\"Cari karya tulis...\" />\n" +
                "      <button class=\"btn btn-primary btn-block\" style=\"border-radius: 40px\">Cari</button>\n" +
                "    </div>\n" +
                "\n" +
                "    <div style=\"font-weight: bold\">\n" +
                "      <br />\n" +
                "      <marquee>Selamat Datang Di E-Repository Universitas Dayanu Ikshanuddin Kota Baubau</marquee>\n" +
                "    </div>\n" +

                "\n" +
                "    <div style=\"font-weight: bold; margin-left: 15px; margin-bottom: 10px; margin-top: 10px\">Karya Tulis Populer</div>\n" +
                "    <!-- Swiper -->\n" +
                "    <div class=\"swiper-container swiper1\">\n" +
                "      <div class=\"swiper-wrapper\">\n" +

                         populer+

                "      </div>\n" +
                "      <!-- Add Pagination -->\n" +
                "      <div class=\"swiper-pagination\"></div>\n" +
                "    </div>\n" +
                "\n" +
                "    <br />\n" +
                "    <div style=\"font-weight: bold; margin-left: 15px; margin-bottom: 10px; margin-top: 10px\">Karya Tulis Populer</div>\n" +
                "    <div class=\"swiper-container swiper2\">\n" +
                "      <div class=\"swiper-wrapper\">\n" +
                        pilihan+

                "      </div>\n" +
                "      <!-- Add Pagination -->\n" +
                "      <div class=\"swiper-pagination\"></div>\n" +
                "    </div>\n" +
                "\n" +
                "    <br />\n" +
                "    <div style=\"font-weight: bold; margin-left: 15px; margin-bottom: 10px; margin-top: 10px\">Karya Tulis Terbaru</div>\n" +
                "    <div style=\"padding: 15px\">\n" +
                    lainnya+
                "\n" +

                "\n" +
                "    <!-- Swiper JS -->\n" +
                "    <script src=\"swiper/dist/js/swiper.min.js\"></script>\n" +
                "\n" +
                "    <!-- Initialize Swiper -->\n" +
                "    <script>\n" +
                "      var swiper = new Swiper(\".swiper1\", {\n" +
                "        pagination: \".swiper-pagination\",\n" +
                "        slidesPerView: \"auto\",\n" +
                "        centeredSlides: true,\n" +
                "        paginationClickable: true,\n" +
                "        spaceBetween: 15,\n" +
                "        loop: true,\n" +
                "      });\n" +
                "      var swiper2 = new Swiper(\".swiper2\", {\n" +
                "        slidesPerView: \"auto\",\n" +
                "        centeredSlides: false,\n" +
                "        spaceBetween: 15,\n" +
                "        loop: false,\n" +
                "      });\n" +
                "    </script>\n" +
                "  </body>\n" +
                "</html>\n";
    }
    public static String populer(
            int index
            ,String id_repository, String judul,
            String subjek, String sub_subjek, String tanggal, String author,
            String reader
            )

    {
        String[] color={
                "#FF87CA",
                "#F7D59C",
                "#BFA2DB"
        };
        return "        <div onclick='return window.location=\"http://lihat.repository/"+id_repository+"\"' class=\"swiper-slide list_data\" style=\"color:#FFF;font-size: 12px; background-size: cover; background: "+color[index]+"; text-align: left; padding: 10px\">\n" +
                "          <div style=\"font-weight: bold; font-size: 10px; height: 50px\">"+judul+"</div>\n" +
                "          <div style=\"font-size: 10px; margin-top:10px;\">"+tanggal+"</div>\n" +
                "          <div style=\"font-size: 10px; text-align: right\">"+author+"</div>\n" +
                "          <div style=\"font-size: 10px; text-align: left; margin-top:-10px;font-weight:bold;\">"+reader+" Pembaca</div>\n" +
                "        </div>\n";
    }

    public static String pilihan( int index
            ,String id_repository, String judul,
                                  String subjek, String sub_subjek, String tanggal, String author,
                                  String reader, String koleksi, String fakultas, String juruusan)
    {
        return "        <div onclick='return window.location=\"http://lihat.repository/"+id_repository+"\"' class=\"swiper-slide c list_data\" style=\"width: 67%; border: none\">\n" +
                "          <div style=\"background: #4d5e93; height: 20px; width: 50%; margin-bottom: -8px; border-radius: 5px 5px 0 0; font-size: 7px; color: #fff\">"+koleksi+"</div>\n" +
                "          <div style=\"height: 87%; width: 100%; background: #3366ff; border-radius: 10px\">\n" +
                "            <div style=\"color: white; padding: 5px; font-size: 10px; text-align: justify\">\n" +
                "             "+judul+"\n" +
                "            </div>\n" +
                "            <div style=\"font-weight: bold; color: white; padding-left: 5px; font-size: 8px; text-align: left\">"+fakultas+" | "+ juruusan+"</div>\n" +
                "          </div>\n" +
                "        </div>\n";
    }
    public static String lainnya(
            int index
            ,String id_repository, String judul,
            String subjek, String sub_subjek, String tanggal, String author,
            String reader, String koleksi, String fakultas, String juruusan
    )
    {
        return  "      <div onclick='return window.location=\"http://lihat.repository/"+id_repository+"\"' class=\"list_data\" style=\" margin-bottom:10px;border: 1px solid #dfdfdf; padding: 0px\">\n" +
                "        <table width=\"100%\" style=\"margin: 0px\">\n" +
                "          <tr>\n" +
                "            <td width=\"3px\" style=\"background: #dfdfdf\"></td>\n" +
                "            <td style=\"padding: 10px\">\n" +
                "              <div style=\"font-weight: bold\">"+judul+"</div>\n" +
                "              <div>"+tanggal+"</div>\n" +
                "              <div style=\"font-size: 10px\">Fakultas "+fakultas+" . Jurusan "+juruusan+"</div>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </table>\n" +
                "      </div>\n" ;
    }

}
