package com.example.repositoriunidayan.widget;

public class Global_variabel {
    //public static String domain="http://10.0.2.2/repository/";
    public static String domain="https://repository.unidayan.ac.id/api/";
    public static String baseUrl=domain+"index.php/";
    public static void load_asset(PageView pageView, String file_name)
    {
        pageView.loadUrl("file:///android_asset/"+file_name+".html");
    }
    public  static  void load_url(PageView pageView,String file_name)
    {
        pageView.loadUrl(domain+file_name+".html");
    }

    public static void load_data(PageView pageView, String data)
    {
        pageView.loadDataWithBaseURL("file:///android_asset/",
                    data, "text/html","UTF-8",null
                );
    }
}
