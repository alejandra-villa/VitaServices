package co.edu.sena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {

    Button btnRegistrarUsu, btnSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnRegistrarUsu = findViewById(R.id.btnRegistrarUsu);
        btnSesion = findViewById(R.id.btnSesion);

        btnRegistrarUsu.setOnClickListener(view -> {
            Intent intent = new Intent(PrincipalActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        btnSesion.setOnClickListener(view -> {
            Intent intent2 = new Intent(PrincipalActivity.this, LoginActivity1.class);
            startActivity(intent2);
        });
    }
}