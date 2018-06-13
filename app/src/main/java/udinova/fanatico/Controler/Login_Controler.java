package udinova.fanatico.Controler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import udinova.fanatico.View.Login_Activity;
import udinova.fanatico.View.Menu_Activity;
import udinova.fanatico.Models.JSON.UsuarioJSON;
import udinova.fanatico.Models.POJO.LoginPOJO;
import udinova.fanatico.Models.RETROFIT.Cliente;
import udinova.fanatico.Models.RETROFIT.Fanatico_Service;
import udinova.fanatico.Models.RETROFIT.Respuesta;
import udinova.fanatico.Models.utils.Alert_Dialog_P;
import udinova.fanatico.View.Registro_Activity;

/**
 * Created by luisp on 3/6/2018.
 */

public class Login_Controler {

    Context context;
    Login_Activity login_activity;
    private Alert_Dialog_P pDialog;
    SharedPreferences prefsLogin;

    public  Login_Controler(Context context,SharedPreferences prefsLogin){
        this.context = context;
        login_activity = (Login_Activity) context;
        this.prefsLogin =prefsLogin;
    }
    public void CrearCuenta(){
        Registro_Activity registro_activity = new Registro_Activity();
        Intent in = new Intent(context, Registro_Activity.class);
        context.startActivity(in);
    }

    public void IniciarSession(String usuario,String password){
        //pDialog = new Alert_Dialog_P(context);
        //pDialog.showwait();
        Login(usuario,password);

    }
    public void Login(String usuario,String password){
        LoginPOJO loginPOJO = new LoginPOJO();
        loginPOJO.setLogin(usuario);
        loginPOJO.setPassword(password);
        //temp
       Intent i = new Intent(context, Menu_Activity.class);
        login_activity.finish();
        context.startActivity(i);
        /*
        Fanatico_Service service = Cliente.getClient();
        Call<Respuesta<UsuarioJSON>> call = service.login(loginPOJO.getLogin(),loginPOJO.getPassword(),loginPOJO.getSecurekey());
        call.enqueue(new Callback<Respuesta<UsuarioJSON>>() {
            @Override
            public void onResponse(Call<Respuesta<UsuarioJSON>> call, Response<Respuesta<UsuarioJSON>> response) {
                if (response.isSuccessful()) {
                    try {
                        Respuesta<UsuarioJSON> respuesta = response.body();
                        if (respuesta.respuestaExitosa() == true) {
                            String login,password,username,userlastname;
                            int codUsuario;
                            login = respuesta.getValues().getLogin();
                            password = respuesta.getValues().getPassword();
                            username = respuesta.getValues().getNombre();
                            userlastname = respuesta.getValues().getApellido();
                            codUsuario = respuesta.getValues().getIdUsuario();
                            SaveOnPreferences(login, password,username,userlastname,codUsuario);

                            Intent i = new Intent(context, Menu_Activity.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            login_activity.finish();
                            context.startActivity(i);
                            pDialog.dismiss();


                        } else if (respuesta.respuestaExitosa() == false) {
                            pDialog.dismiss();
                            ShowAlert(respuesta.getMessage());

                        }
                    } catch (Exception e) {

                        pDialog.dismiss();
                        ShowAlert(e.getMessage().toString());

                    }
                }
                else{
                    pDialog.dismiss();
                    //  ShowAlert(response.body().getMessage());
                }

            }
            @Override
            public void onFailure(Call<Respuesta<UsuarioJSON>> call, Throwable t) {

                pDialog.dismiss();
               // ShowAlert(t.getMessage().toString());
                ShowAlert("No hay conexion a la red reintente nuevamente....");
            }
        });*/
    }
    public void ShowAlert(String mensaje) {

        Alert_Dialog_P customDialog = new Alert_Dialog_P(context);
        customDialog.setTitulo("Ops ocurrio un problema");
        customDialog.setContenido(mensaje);
        customDialog.enableNeutralButton(true);
        customDialog.setTextNeutralButton("Aceptar");
        customDialog.show();


    }
    public void SaveOnPreferences(String login, String pass, String nombreUsuario,String apellidoUsuario, int IdUsuario) {
        SharedPreferences.Editor editor = prefsLogin.edit();
        editor.putString("login", login);
        editor.putString("password", pass);
        editor.putString("nombreUsuario", nombreUsuario);
        editor.putString("apellidoUsuario", apellidoUsuario);
        editor.putInt("idUsuario", IdUsuario);
        editor.apply();

    }
}
