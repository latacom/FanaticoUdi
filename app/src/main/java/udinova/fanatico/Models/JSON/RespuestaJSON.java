package udinova.fanatico.Models.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by luisp on 6/6/2018.
 */

public class RespuestaJSON {
    @SerializedName("idRespuesta")
    @Expose
    private int idRespuesta;
    @SerializedName("respuesta")
    @Expose
    private String respuesta;

    @SerializedName("urlImagen")
    @Expose
    private String urlImagen;
    @SerializedName("idTipoRes")
    @Expose
    private int idTipoRes;

    public RespuestaJSON(int idRespuesta, String respuesta, String urlImagen, int idTipoRes) {
        this.idRespuesta = idRespuesta;
        this.respuesta = respuesta;

        this.urlImagen = urlImagen;
        this.idTipoRes = idTipoRes;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public int getIdTipoRes() {
        return idTipoRes;
    }

    public void setIdTipoRes(int idTipoRes) {
        this.idTipoRes = idTipoRes;
    }
}
