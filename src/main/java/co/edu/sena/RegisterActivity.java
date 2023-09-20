package co.edu.sena;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.sena.interfaces.AfiliadoApi;
import co.edu.sena.models.Afiliado;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    EditText edtxDocumento, edtxNombres, edtxApellidos, edtxEdad, edtxTelefono, edtxCorreo, edtxDireccion, edtxBeneficiarios;

    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtxDocumento = findViewById(R.id.edtxDocumento);
        edtxNombres = findViewById(R.id.edtxNombres);
        edtxApellidos = findViewById(R.id.edtxApellidos);
        edtxEdad = findViewById(R.id.edtxEdad);
        edtxTelefono = findViewById(R.id.edtxTelefono);
        edtxCorreo = findViewById(R.id.edtxCorreo);
        edtxDireccion = findViewById(R.id.edtxDireccion);
        edtxBeneficiarios = findViewById(R.id.edtxBeneficiarios);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                registrar();
            }
        });
    }

    public void registrar() {

        int documento = Integer.parseInt(edtxDocumento.getText().toString());
        String nombres = edtxNombres.getText().toString();
        String apellidos = edtxApellidos.getText().toString();
        int edad = Integer.parseInt(edtxEdad.getText().toString());
        String telefono = edtxTelefono.getText().toString();
        String correo = edtxCorreo.getText().toString();
        String direccion = edtxDireccion.getText().toString();
        int beneficiarios = Integer.parseInt(edtxBeneficiarios.getText().toString());

        Afiliado afiliado = new Afiliado(documento, nombres, apellidos, edad, telefono, correo, direccion, beneficiarios);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/").addConverterFactory(GsonConverterFactory.create()).build();

        AfiliadoApi afiliadoApi = retrofit.create(AfiliadoApi.class);
        Call<Afiliado> call = afiliadoApi.registrarDatos(afiliado);

        call.enqueue(new Callback<Afiliado>() {
            @Override
            public void onResponse(Call<Afiliado> call, Response<Afiliado> response) {
                Toast.makeText(RegisterActivity.this, "Afiliado registrado.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Afiliado> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Error al registrar.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

