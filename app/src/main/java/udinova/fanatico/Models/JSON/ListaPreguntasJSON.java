package udinova.fanatico.Models.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by luisp on 13/6/2018.
 */

public class ListaPreguntasJSON {
    List<PreguntaJSON> lpreguntaJSON;

    public List<PreguntaJSON> getPreguntaJSON() {
        return lpreguntaJSON;
    }

    public void setPreguntaJSON(List<PreguntaJSON> preguntaJSON) {
        this.lpreguntaJSON = preguntaJSON;
    }
    public void add(PreguntaJSON preguntaJSON){
        lpreguntaJSON.add(preguntaJSON);
    }
    public void addall(List<PreguntaJSON> preguntaJSONS){
        if(lpreguntaJSON==null) {
            lpreguntaJSON = new ArrayList<>();
        }
        lpreguntaJSON.addAll(preguntaJSONS);
    }
    public PreguntaJSON getRandomPregunta(){
        Random rand = new Random();
        return lpreguntaJSON.get(rand.nextInt(lpreguntaJSON.size()));
    }
}
