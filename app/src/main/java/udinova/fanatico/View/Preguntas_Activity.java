package udinova.fanatico.View;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import udinova.fanatico.Controler.Preguntas_Controler;
import udinova.fanatico.R;

public class Preguntas_Activity extends AppCompatActivity {
    public Preguntas_Controler preguntas_controler;

    private TextView textviewTime;
    private ProgressBar progressBarCircle,progressbarline;
    SharedPreferences prefsLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        prefsLogin = getSharedPreferences("PrefsLogin", Context.MODE_PRIVATE);
        preguntas_controler = new Preguntas_Controler(this,prefsLogin);
        IniciarVistas();
        IniciarJuego();

    }
    private void IniciarVistas(){
        progressbarline = (ProgressBar)findViewById(R.id.pregunta_progressBar);
        textviewTime = (TextView)findViewById(R.id.pregunta_textViewTime);
        preguntas_controler.CargarContador(progressbarline,textviewTime);
    }
    private void IniciarJuego(){
        preguntas_controler.iniciarJuego();
    }


    public void addFragment(Fragment currentFragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.containerFragmentsPregunta,currentFragment,tag)
                .commit();
    }
    public void addFragment(Fragment currentFragment, String tag,Bundle arg) {
        currentFragment.setArguments(arg);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.containerFragmentsPregunta,currentFragment,tag)
                .commit();
    }
    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        /*if (!preguntas_controler.recursivePopBackStack(getSupportFragmentManager())) {

        }*/
        super.onBackPressed();
    }
}
