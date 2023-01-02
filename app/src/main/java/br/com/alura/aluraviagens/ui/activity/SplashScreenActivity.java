package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import br.com.alura.aluraviagens.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        verificaSeOAppFoiAberto();
    }

    private void verificaSeOAppFoiAberto() {
        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
        if (preferences.contains("app_foi_aberto")){
            mostrarTelaInicial();
        }else{
            mostraSplashScreen();
            addPreferenciaAppFoiAberto(preferences);
        }
    }

    private void addPreferenciaAppFoiAberto(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("app_foi_aberto", true);
        editor.apply();
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