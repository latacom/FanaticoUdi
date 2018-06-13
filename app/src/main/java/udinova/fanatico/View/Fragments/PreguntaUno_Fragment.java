package udinova.fanatico.View.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import udinova.fanatico.Models.JSON.PreguntaJSON;
import udinova.fanatico.Models.JSON.RespuestaJSON;
import udinova.fanatico.R;
import udinova.fanatico.View.Preguntas_Activity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntaUno_Fragment extends Fragment implements View.OnClickListener {

    View mview;
    Random rand;
    PreguntaJSON preguntas;
    List<RespuestaJSON> listaRespuesta;
    String respuestaCorreecta ="";
    TextView txtpregunta,r1,r2,r3,r4,obs;
    RelativeLayout containernext;
    LinearLayout siguientePregunta;
    public PreguntaUno_Fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview = inflater.inflate(R.layout.fragment_preguntauno, container, false);
        if(listaRespuesta!= null || preguntas != null){
            InicializarVariables();
            CargarVista();
            ((Preguntas_Activity)getActivity()).preguntas_controler.iniciarConteo();
        }
        return mview;
    }
    public void InicializarVariables(){
        rand = new Random();
        txtpregunta = (TextView)mview.findViewById(R.id.P1_Pregunta);
        r1 = (TextView)mview.findViewById(R.id.P1_btnRespuesta1);
        r2 = (TextView)mview.findViewById(R.id.P1_btnRespuesta2);
        r3 = (TextView)mview.findViewById(R.id.P1_btnRespuesta3);
        r4 = (TextView)mview.findViewById(R.id.P1_btnRespuesta4);
        obs = (TextView)mview.findViewById(R.id.P1_obs);
        containernext = (RelativeLayout)mview.findViewById(R.id.P1_containernext);
        siguientePregunta = (LinearLayout) mview.findViewById(R.id.P1_sgtP);

        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);
        r4.setOnClickListener(this);
        siguientePregunta.setOnClickListener(this);
    }

    public void CargarVista(){
        txtpregunta.setText(preguntas.getPregunta());
        List<RespuestaJSON> lres = new ArrayList<>();
        List<RespuestaJSON> lresA = new ArrayList<>();
        lres.addAll(listaRespuesta);
        while (lres.size()!=0){
            int nrand = rand.nextInt(lres.size());
            lresA.add(lres.get(nrand));
            lres.remove(nrand);
        }
        if(lresA.size()!=0) {
            r1.setText(lresA.get(0).getRespuesta());
            r2.setText(lresA.get(1).getRespuesta());
            r3.setText(lresA.get(2).getRespuesta());
            r4.setText(lresA.get(3).getRespuesta());
        }
    }
    public void setPregunta(PreguntaJSON pregunta, List<RespuestaJSON> listaRespuesta) {
        this.listaRespuesta = listaRespuesta;
        this.preguntas = pregunta;
        this.respuestaCorreecta = listaRespuesta.get(0).getRespuesta();
    }
    private void disableclick(){
        r1.setClickable(false);
        r2.setClickable(false);
        r3.setClickable(false);
        r4.setClickable(false);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        int op = 0;
        TextView txt;
        if(id == siguientePregunta.getId()){
            op =1;
        }
        if(op==0){
            ((Preguntas_Activity)getActivity()).preguntas_controler.stopCountDownTimer();
            txt = ((TextView)v);
            if(respuestaCorreecta.toLowerCase().equals(txt.getText().toString().toLowerCase())){
                txt.setBackgroundResource(R.drawable.border_button_correcto);
                txt.setTextColor(getContext().getResources().getColor(R.color.blanco));
                obs.setText("correcto");
                ((Preguntas_Activity)getActivity()).preguntas_controler.setPuntaje(true);
            }
            else{
                txt.setBackgroundResource(R.drawable.border_button_falla);
                txt.setTextColor(getContext().getResources().getColor(R.color.blanco));
                obs.setText("incorrecto");
                ((Preguntas_Activity)getActivity()).preguntas_controler.setPuntaje(false);
            }
            containernext.setVisibility(View.VISIBLE);
            disableclick();

        }
        else if (op==1){
            ((Preguntas_Activity)getActivity()).preguntas_controler.iniciarJuego();
            ((Preguntas_Activity)getActivity()).preguntas_controler.stopCountDownTimer();
            this.onDestroy();
        }
    }
}
