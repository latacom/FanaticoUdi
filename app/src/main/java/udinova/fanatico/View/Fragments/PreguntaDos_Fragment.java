package udinova.fanatico.View.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
public class PreguntaDos_Fragment extends Fragment implements View.OnClickListener{
    View mview;
    Random rand;
    PreguntaJSON preguntas;
    List<RespuestaJSON> listaRespuesta;
    String respuestaCorreecta ="";
    TextView txtpregunta, txtr1, txtr2, txtr3, txtr4,obs;
    ImageView imgr1,imgr2,imgr3,imgr4;
    LinearLayout res1,res2,res3,res4;
    RelativeLayout containernext;
    LinearLayout siguientePregunta;
    public PreguntaDos_Fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview = inflater.inflate(R.layout.fragment_preguntados, container, false);
        if(listaRespuesta!= null || preguntas != null){
            InicializarVariables();
            CargarVista();
            ((Preguntas_Activity)getActivity()).preguntas_controler.iniciarConteo();
        }
        return mview;
    }
    public void InicializarVariables(){
        rand = new Random();
        txtpregunta = (TextView)mview.findViewById(R.id.P2_Pregunta);
        txtr1 = (TextView)mview.findViewById(R.id.P2_btntxtRespuesta1);
        txtr2 = (TextView)mview.findViewById(R.id.P2_btntxtRespuesta2);
        txtr3 = (TextView)mview.findViewById(R.id.P2_btntxtRespuesta3);
        txtr4 = (TextView)mview.findViewById(R.id.P2_btntxtRespuesta4);
        obs = (TextView)mview.findViewById(R.id.P2_obs);
        containernext = (RelativeLayout)mview.findViewById(R.id.P2_containernext);
        siguientePregunta = (LinearLayout) mview.findViewById(R.id.P2_sgtP);

        imgr1 = (ImageView)mview.findViewById(R.id.P2_btnimgRespuesta1);
        imgr2 = (ImageView)mview.findViewById(R.id.P2_btnimgRespuesta2);
        imgr3 = (ImageView)mview.findViewById(R.id.P2_btnimgRespuesta3);
        imgr4 = (ImageView)mview.findViewById(R.id.P2_btnimgRespuesta4);

        res1 = (LinearLayout)mview.findViewById(R.id.P2_btnRespuesta1);
        res2 = (LinearLayout)mview.findViewById(R.id.P2_btnRespuesta2);
        res3 = (LinearLayout)mview.findViewById(R.id.P2_btnRespuesta3);
        res4 = (LinearLayout)mview.findViewById(R.id.P2_btnRespuesta4);

        res1.setOnClickListener(this);
        res2.setOnClickListener(this);
        res3.setOnClickListener(this);
        res4.setOnClickListener(this);
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
            txtr1.setText(lresA.get(0).getRespuesta());
            Glide.with(getContext())
                    .load(lresA.get(0).getUrlImagen())
                    .into(imgr1);
            txtr2.setText(lresA.get(1).getRespuesta());
            Glide.with(getContext())
                    .load(lresA.get(1).getUrlImagen())
                    .into(imgr2);
            txtr3.setText(lresA.get(2).getRespuesta());
            Glide.with(getContext())
                    .load(lresA.get(2).getUrlImagen())
                    .into(imgr3);
            txtr4.setText(lresA.get(3).getRespuesta());
            Glide.with(getContext())
                    .load(lresA.get(3).getUrlImagen())
                    .into(imgr4);
        }
    }
    public void setPregunta(PreguntaJSON pregunta, List<RespuestaJSON> listaRespuesta) {
        this.listaRespuesta = listaRespuesta;
        this.preguntas = pregunta;
        this.respuestaCorreecta = listaRespuesta.get(0).getRespuesta();
    }
    private void disableclick(){
        res1.setClickable(false);
        res2.setClickable(false);
        res3.setClickable(false);
        res4.setClickable(false);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        int op = 0;
        TextView txt = null;
        if(id == siguientePregunta.getId()){
            op =1;
        }else if (id == res1.getId()){
            txt = txtr1;
        }else if (id == res2.getId()){
            txt = txtr2;
        }else if (id == res3.getId()){
            txt = txtr3;
        }else if (id == res4.getId()){
            txt = txtr4;
        }
        if(op==0){
            ((Preguntas_Activity)getActivity()).preguntas_controler.stopCountDownTimer();
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
