package udinova.fanatico.Models.RETROFIT;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import udinova.fanatico.Models.JSON.UsuarioJSON;

/**
 * Created by Marcelo on 14/9/2017.
 */

public interface Fanatico_Service {
    @GET("DB_LoginUsuario")
    Call<Respuesta<UsuarioJSON>> login(@Query("key1") String usr, @Query("key2") String pass, @Query("key3") String key);

}
