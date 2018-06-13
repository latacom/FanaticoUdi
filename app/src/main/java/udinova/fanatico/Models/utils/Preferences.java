package udinova.fanatico.Models.utils;

import android.content.SharedPreferences;

/**
 * Created by Marcelo on 15/9/2017.
 */

public class Preferences {


    public static String getLoginPreferences(SharedPreferences preferences) {
        return preferences.getString("login", "");
    }

    public static String getPassPreferences(SharedPreferences preferences) {
        return preferences.getString("password", "");
    }

    public static String getNombreUsuario(SharedPreferences preferences) {
        return preferences.getString("nombreUsuario", "");
    }

    public static String getApellidoUsuario(SharedPreferences preferences) {
        return preferences.getString("apellidoUsuario", "");
    }

    public static Integer getIdUsuario(SharedPreferences preferences) {
        return preferences.getInt("idUsuario", 0);
    }
}
