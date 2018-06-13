package udinova.fanatico.View;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import udinova.fanatico.Controler.Login_Controler;
import udinova.fanatico.R;

public class Login_Activity extends AppCompatActivity {

    private Login_Controler loginControler;
    private TextView txtnombre,txtpassword;
    SharedPreferences prefsLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefsLogin = getSharedPreferences("PrefsLogin", Context.MODE_PRIVATE);
        loginControler = new Login_Controler(this,prefsLogin);
        txtnombre = (TextView)findViewById(R.id.ETnomusuario);
        txtpassword = (TextView)findViewById(R.id.ETpassusuario);
    }

    public void CrearCuenta(View view) {
        loginControler.CrearCuenta();
    }

    public void IniciarSession(View view) {
        String login = txtnombre.getText().toString();
        String pass = txtpassword.getText().toString();
        loginControler.IniciarSession(login,pass);
    }
}
