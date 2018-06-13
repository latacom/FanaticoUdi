package udinova.fanatico;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import udinova.fanatico.Models.JSON.ListaPreguntasJSON;
import udinova.fanatico.Models.JSON.ListaRespuestaJSON;
import udinova.fanatico.Models.JSON.PreguntaJSON;
import udinova.fanatico.Models.JSON.RespuestaJSON;
import udinova.fanatico.Models.JSON.UsuarioJSON;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void AdicciondeUsuario() throws Exception {
        UsuarioJSON usuarioJSON = new UsuarioJSON();
        usuarioJSON.setApellido("Pedro");
        usuarioJSON.setNombre("Juan");
        Assert.assertEquals("Pedro",usuarioJSON.getApellido());
        Assert.assertEquals("Juan",usuarioJSON.getNombre());
    }
    @Test
    public void TestPreguntasRandom(){
        ListaPreguntasJSON lpjson = new ListaPreguntasJSON();
        Assert.assertNull(lpjson.getPreguntaJSON());

        lpjson.addall(preguntas());
        Assert.assertNotNull(preguntas());

        PreguntaJSON pjson = lpjson.getRandomPregunta();
        Assert.assertNotNull(pjson);
    }
    @Test
    public void TestRespuestas(){
        ListaRespuestaJSON lrjson = new ListaRespuestaJSON();
        Assert.assertNull(lrjson.getPreguntaJSON());

        lrjson.addall(tempRes());
        Assert.assertNotNull(preguntas());

        List<RespuestaJSON> pjson = lrjson.getRespuestoTipo(1);
        Assert.assertNotNull(pjson);
        Assert.assertEquals(2,pjson.size());
    }
    public List<PreguntaJSON> preguntas(){
        List<PreguntaJSON> list = new ArrayList<>();
        list.add(new PreguntaJSON(1,"Que equipo gano el mundial del 1998?",1,2));
        list.add(new PreguntaJSON(2,"Que equipo gano el mundial del 2010?",2,2));
        list.add(new PreguntaJSON(3,"Que equipo gano el mundial del 2014?",3,2));
        list.add(new PreguntaJSON(4,"Que equipo gano el mundial del 2006?",4,2));
        list.add(new PreguntaJSON(5,"Que equipo gano el mundial del 2002?",5,2));
        list.add(new PreguntaJSON(6,"Donde fue la sede del Mundial 2010?",6,2));
        list.add(new PreguntaJSON(7,"Donde fue la sede del Mundial 2018?",7,2));
        list.add(new PreguntaJSON(8,"Donde fue la sede del Mundial 2014?",5,2));
        list.add(new PreguntaJSON(9,"Donde fue la sede del Mundial 2006?",3,2));
        list.add(new PreguntaJSON(10,"Donde fue la sede del Mundial 1998?",1,2));
        list.add(new PreguntaJSON(11,"Que equipo quedo en segundo lugar en el mudial 2014",8,2));
        return list;
    }
    public ArrayList<RespuestaJSON> tempRes(){
        ArrayList<RespuestaJSON> listaRes = new ArrayList<>();
        listaRes.add(new RespuestaJSON(1,"Francia","http://flags.fmcdn.net/data/flags/w580/fr.png",2));
        listaRes.add(new RespuestaJSON(2,"España","http://flags.fmcdn.net/data/flags/w580/es.png",2));
        listaRes.add(new RespuestaJSON(3,"Alemania","http://flags.fmcdn.net/data/flags/w580/de.png",2));
        listaRes.add(new RespuestaJSON(4,"Italia","http://flags.fmcdn.net/data/flags/w580/it.png",2));
        listaRes.add(new RespuestaJSON(5,"Brasil","http://flags.fmcdn.net/data/flags/w580/br.png",2));
        listaRes.add(new RespuestaJSON(6,"Sudafrica","http://flags.fmcdn.net/data/flags/w580/za.png",2));
        listaRes.add(new RespuestaJSON(7,"Rusia","http://flags.fmcdn.net/data/flags/w580/ru.png",1));
        listaRes.add(new RespuestaJSON(7,"Argentina","http://flags.fmcdn.net/data/flags/w580/ar.png",1));

        return listaRes;
    }
}