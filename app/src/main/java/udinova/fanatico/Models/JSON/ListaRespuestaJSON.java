package udinova.fanatico.Models.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import udinova.fanatico.Models.RETROFIT.Respuesta;

/**
 * Created by luisp on 13/6/2018.
 */

public class ListaRespuestaJSON {
    List<RespuestaJSON> lrespuestaJSON;

    public List<RespuestaJSON> getPreguntaJSON() {
        return lrespuestaJSON;
    }

    public void setPreguntaJSON(List<RespuestaJSON> preguntaJSON) {
        this.lrespuestaJSON = preguntaJSON;
    }
    public void add(RespuestaJSON preguntaJSON){
        lrespuestaJSON.add(preguntaJSON);
    }
    public void addall(List<RespuestaJSON> preguntaJSONS){
        if(lrespuestaJSON ==null) {
            lrespuestaJSON = new ArrayList<>();
        }
        lrespuestaJSON.addAll(preguntaJSONS);
    }
    public RespuestaJSON getRandomPregunta(){
        Random rand = new Random();
        return lrespuestaJSON.get(rand.nextInt(lrespuestaJSON.size()));
    }
    public List<RespuestaJSON> getRespuestoTipo(int tipores){
        List<RespuestaJSON> lres = new ArrayList<>();
        for (int i = 0; i < lrespuestaJSON.size(); i++) {
            if (lrespuestaJSON.get(i).getIdTipoRes()==tipores){
                lres.add(lrespuestaJSON.get(i));
            }
        }
        return lres;
    }
}
