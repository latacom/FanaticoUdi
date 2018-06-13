package udinova.fanatico.View;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import udinova.fanatico.Controler.Menu_Controler;
import udinova.fanatico.R;

public class Menu_Activity extends AppCompatActivity {

    private Menu_Controler menu_controler;
    private TextView txtnombre,txtpassword;
    SharedPreferences prefsLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        prefsLogin = getSharedPreferences("PrefsLogin", Context.MODE_PRIVATE);
        menu_controler = new Menu_Controler(this,prefsLogin);
    }

    public void IniciarGame(View view) {
        menu_controler.IniciarJuego();
    }
}
