package udinova.fanatico.Models.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by luisp on 6/6/2018.
 */

public class PreguntaJSON {
    @SerializedName("idPregunta")
    @Expose
    private int idPregunta;
    @SerializedName("pregunta")
    @Expose
    private String pregunta;
    @SerializedName("idResCorrecta")
    @Expose
    private int idResCorrecta;
    @SerializedName("idTipoRes")
    @Expose
    private int idTipo;

    public PreguntaJSON(int idPregunta, String pregunta, int idResCorrecta, int idTipo) {
        this.idPregunta = idPregunta;
        this.pregunta = pregunta;
        this.idResCorrecta = idResCorrecta;
        this.idTipo = idTipo;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getIdResCorrecta() {
        return idResCorrecta;
    }

    public void setIdResCorrecta(int idResCorrecta) {
        this.idResCorrecta = idResCorrecta;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
}
