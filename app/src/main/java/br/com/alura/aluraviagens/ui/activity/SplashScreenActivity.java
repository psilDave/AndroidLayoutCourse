package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import br.com.alura.aluraviagens.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mostraSplashScreen();
    }

    private void mostraSplashScreen() {
        Handler handle = new Handler();
        handle.postDelayed(this::mostrarTelaInicial, 2000);
    }

    private void mostrarTelaInicial() {
        Intent intent = new Intent(this, ListaPacotesActivity.class);
        startActivity(intent);
    }
}