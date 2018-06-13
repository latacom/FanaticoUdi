package udinova.fanatico.Controler;

import android.content.Context;
import android.content.SharedPreferences;

import udinova.fanatico.Models.utils.Alert_Dialog_P;
import udinova.fanatico.View.Login_Activity;

/**
 * Created by luisp on 3/6/2018.
 */

public class Registro_Controler {
    Context context;
    Login_Activity login_activity;
    private Alert_Dialog_P pDialog;
    SharedPreferences prefsLogin;

    public void ShowAlert(String mensaje) {
        Alert_Dialog_P customDialog = new Alert_Dialog_P(context);
        customDialog.setTitulo("Ops ocurrio un problema");
        customDialog.setContenido(mensaje);
        customDialog.enableNeutralButton(true);
        customDialog.setTextNeutralButton("Aceptar");
        customDialog.show();
    }
}
