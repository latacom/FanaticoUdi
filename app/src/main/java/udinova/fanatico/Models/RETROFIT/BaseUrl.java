package udinova.fanatico.Models.RETROFIT;

/**
 * Created by Marcelo on 14/9/2017.
 */

public class BaseUrl {

    public static String baseUrl = "http://www.ipadi.com.bo/wsActiveRestfull/wsMovilUDI.svc/";

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        BaseUrl.baseUrl = baseUrl;
    }
}
