package udinova.fanatico.Controler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import udinova.fanatico.Models.JSON.PreguntaJSON;
import udinova.fanatico.Models.JSON.RespuestaJSON;
import udinova.fanatico.Models.utils.Alert_Dialog_P;
import udinova.fanatico.View.Fragments.PreguntaDos_Fragment;
import udinova.fanatico.View.Fragments.PreguntaUno_Fragment;
import udinova.fanatico.View.Preguntas_Activity;
import udinova.fanatico.View.Puntos_Activity;

/**
 * Created by luisp on 3/6/2018.
 */

public class Preguntas_Controler{
    Context context;
    Random rand = new Random();
    Preguntas_Activity login_activity;
    PreguntaJSON pregunta;
    List<RespuestaJSON> listaRespuesta;

    private CountDownTimer countDownTimer;
    private Alert_Dialog_P pDialog;
    private ProgressBar linepb;
    private TextView textViewTime;
    PreguntaUno_Fragment p1;
    PreguntaDos_Fragment p2;
    int NroMaxJuego,NroJuego,puntos,PuntosTotal;
    private static final int milisegundos = 30000;
    SharedPreferences prefsLogin;
    public  Preguntas_Controler(Context context,SharedPreferences prefsLogin){
        this.NroMaxJuego = 4;
        this.PuntosTotal = 0;
        this.NroJuego = 0;
        this.context = context;
        login_activity = (Preguntas_Activity) context;
        this.prefsLogin =prefsLogin;
    }

    public void CargarContador( ProgressBar line , TextView timertext){
        this.textViewTime = timertext;
        this.linepb = line;
    }


    public void iniciarJuego(){
        p1 = new PreguntaUno_Fragment();
        p2 = new PreguntaDos_Fragment();
        puntos = 100;
        if(NroJuego<NroMaxJuego) {
            NroJuego++;
            CargarPregunta();
        }
        else{
            ((Preguntas_Activity)context).finish();
            Intent intent = new Intent(((Preguntas_Activity)context), Puntos_Activity.class);
            intent.putExtra("puntos", PuntosTotal);
            ((Preguntas_Activity)context).startActivity(intent);
        }
    }

    public ArrayList<RespuestaJSON> tempRes(){
        ArrayList<RespuestaJSON> listaRes = new ArrayList<>();
        listaRes.add(new RespuestaJSON(1,"Francia","http://flags.fmcdn.net/data/flags/w580/fr.png",2));
        listaRes.add(new RespuestaJSON(2,"España","http://flags.fmcdn.net/data/flags/w580/es.png",2));
        listaRes.add(new RespuestaJSON(3,"Alemania","http://flags.fmcdn.net/data/flags/w580/de.png",2));
        listaRes.add(new RespuestaJSON(4,"Italia","http://flags.fmcdn.net/data/flags/w580/it.png",2));
        listaRes.add(new RespuestaJSON(5,"Brasil","http://flags.fmcdn.net/data/flags/w580/br.png",2));
        listaRes.add(new RespuestaJSON(6,"Sudafrica","http://flags.fmcdn.net/data/flags/w580/za.png",2));
        listaRes.add(new RespuestaJSON(7,"Rusia","http://flags.fmcdn.net/data/flags/w580/ru.png",2));
        listaRes.add(new RespuestaJSON(7,"Argentina","http://flags.fmcdn.net/data/flags/w580/ar.png",2));

        return listaRes;
    }
    public ArrayList<PreguntaJSON> tempPreg(){
        ArrayList<PreguntaJSON> listaPregunta = new ArrayList<>();
        listaPregunta.add(new PreguntaJSON(1,"Que equipo gano el mundial del 1998?",1,2));
        listaPregunta.add(new PreguntaJSON(2,"Que equipo gano el mundial del 2010?",2,2));
        listaPregunta.add(new PreguntaJSON(3,"Que equipo gano el mundial del 2014?",3,2));
        listaPregunta.add(new PreguntaJSON(4,"Que equipo gano el mundial del 2006?",4,2));
        listaPregunta.add(new PreguntaJSON(5,"Que equipo gano el mundial del 2002?",5,2));
        listaPregunta.add(new PreguntaJSON(6,"Donde fue la sede del Mundial 2010?",6,2));
        listaPregunta.add(new PreguntaJSON(7,"Donde fue la sede del Mundial 2018?",7,2));
        listaPregunta.add(new PreguntaJSON(8,"Donde fue la sede del Mundial 2014?",5,2));
        listaPregunta.add(new PreguntaJSON(9,"Donde fue la sede del Mundial 2006?",3,2));
        listaPregunta.add(new PreguntaJSON(10,"Donde fue la sede del Mundial 1998?",1,2));
        listaPregunta.add(new PreguntaJSON(11,"Que equipo quedo en segundo lugar en el mudial 2014",8,2));
        return  listaPregunta;
    }
    public void CargarPregunta(){
        //RETROFIT
        ArrayList<PreguntaJSON> listaPregunta = tempPreg();
        pregunta = listaPregunta.get(rand.nextInt(listaPregunta.size()-1));
        CargarRespuesta();
    }
    public void CargarRespuesta(){
        //RETROFIT
        listaRespuesta = new ArrayList<>();
        ArrayList<RespuestaJSON> listaRes = tempRes();
        for (int i = 0; i < listaRes.size(); i++) {
            if(pregunta.getIdResCorrecta()==listaRes.get(i).getIdRespuesta()){
                listaRespuesta.add(listaRes.get(i));
                listaRes.remove(i);
            }
        }
        int aux= 0;
        while(aux<3){
            int nrand = rand.nextInt(listaRes.size()-1);
            if(listaRes.get(nrand).getIdRespuesta()!=pregunta.getIdResCorrecta()){
                listaRespuesta.add(listaRes.get(nrand));
                listaRes.remove(nrand);
                aux++;
            }
        }
        iniciarVistaPregunta();
    }
    public void iniciarVistaPregunta(){
        Random rand = new Random();
        int tipoJuego = rand.nextInt(2);
        switch (tipoJuego){
            case 0:
                p1.setPregunta(pregunta,listaRespuesta);
                ((Preguntas_Activity) context).addFragment(p1,"pregunta1");
                break;
            case 1:
                p2.setPregunta(pregunta,listaRespuesta);
                ((Preguntas_Activity) context).addFragment(p2,"pregunta2");
                break;
        }
    }
    public void iniciarConteo(){
        setProgressBarValues();
        startCountDownTimer();
    }
    private void startCountDownTimer() {

        countDownTimer = new CountDownTimer(milisegundos, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                puntos = puntos- (100/(milisegundos/1000));
                linepb.setProgress((int) (millisUntilFinished / 1000)+1);
                textViewTime.setText(String.valueOf((int) (millisUntilFinished / 1000)));
            }

            @Override
            public void onFinish() {
                linepb.setProgress(0);
                textViewTime.setText("0");
            }
        }.start();
        countDownTimer.start();
    }
    private void setProgressBarValues() {
        int value = milisegundos / 1000;
        textViewTime.setText(String.valueOf(value));
        linepb.setMax(value);
        linepb.setProgress(value);
    }
    private void resetTime() {
        stopCountDownTimer();
        startCountDownTimer();
    }
    public void stopCountDownTimer() {
        countDownTimer.cancel();
    }
    public void setPuntaje(boolean iscorrect){
     if(iscorrect){
         PuntosTotal = PuntosTotal+puntos;
     }
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
