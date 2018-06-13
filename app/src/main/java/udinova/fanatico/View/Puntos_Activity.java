package udinova.fanatico.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import udinova.fanatico.R;

public class Puntos_Activity extends AppCompatActivity {

    TextView txtPuntaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntos);
        InicializarVista();
        txtPuntaje.setText(getIntent().getExtras().getInt("puntos")+" ptos.");
    }
    public void InicializarVista(){
        txtPuntaje = (TextView)findViewById(R.id.Punto_Puntos);
    }

    public void NuevoJuego(View view) {
        Intent in = new Intent(this, Preguntas_Activity.class);
        this.finish();
        this.startActivity(in);
    }

    public void Menu(View view) {
        this.finish();
    }
}
