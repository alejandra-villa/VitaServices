package co.edu.sena.interfaces;

import co.edu.sena.models.Afiliado;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AfiliadoApi {

    @POST("api/afiliado")
    Call<Afiliado>registrarDatos(@Body Afiliado afiliado);

}
