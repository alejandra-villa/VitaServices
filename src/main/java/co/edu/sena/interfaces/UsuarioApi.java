package co.edu.sena.interfaces;


import co.edu.sena.models.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioApi {

    @POST("api/usuario/login")
    Call<Usuario> login(@Body Usuario usuario);

}
