package udinova.fanatico.Controler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import udinova.fanatico.Models.utils.Alert_Dialog_P;
import udinova.fanatico.View.Menu_Activity;
import udinova.fanatico.View.Preguntas_Activity;

/**
 * Created by luisp on 3/6/2018.
 */

public class Menu_Controler {
    Context context;
    Menu_Activity login_activity;
    private Alert_Dialog_P pDialog;
    SharedPreferences prefsLogin;

    public  Menu_Controler(Context context,SharedPreferences prefsLogin){
        this.context = context;
        login_activity = (Menu_Activity) context;
        this.prefsLogin =prefsLogin;
    }
    public void IniciarJuego(){
        Intent in = new Intent(context, Preguntas_Activity.class);
        context.startActivity(in);
    }

    public void ShowAlert(String mensaje) {
        Alert_Dialog_P customDialog = new Alert_Dialog_P(context);
        customDialog.setTitulo("Ops ocurrio un problema");
        customDialog.setContenido(mensaje);
        customDialog.enableNeutralButton(true);
        customDialog.setTextNeutralButton("Aceptar");
        customDialog.show();
    }
}
