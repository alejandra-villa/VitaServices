package co.edu.sena;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import co.edu.sena.interfaces.UsuarioApi;
import co.edu.sena.models.Usuario;


public class LoginActivity1 extends AppCompatActivity {


    EditText edtxTipoDocumento, edtxNumDocumento, edtxPassword;
    Button btnLogin;
    String documento, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        edtxTipoDocumento = findViewById(R.id.edtxTipoDocumento);
        edtxNumDocumento = findViewById(R.id.edtxNumDocumento);
        edtxPassword = findViewById(R.id.edtxPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Usuario usuario = new Usuario();

                documento = edtxNumDocumento.getText().toString();
                password = edtxPassword.getText().toString();

                if(!documento.isEmpty()) {
                    iniciarSesion("http://localhost:8080/api/usuario/login");
                } else {
                    Toast.makeText(LoginActivity1.this, "No se permiten campos vacíos.", Toast.LENGTH_SHORT).show();;
                }

                iniciarSesion("http://localhost:8080/api/usuario/login");

            }
        });

    }

    private void iniciarSesion(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()) {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity1.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity1.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity1.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected String getParamsEncoding() {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("documento", edtxNumDocumento.getText().toString());
                parametros.put("password", edtxPassword.getText().toString());
                return String.valueOf(parametros);
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



}