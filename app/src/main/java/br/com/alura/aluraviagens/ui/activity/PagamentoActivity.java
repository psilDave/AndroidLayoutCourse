package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.utils.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_ACTIVITY_PAGAMENTO = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_ACTIVITY_PAGAMENTO);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra("pacote")){
            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");
            mostraPreco(pacote);
            configuraBotaoFinalizarCompra(pacote);
        }
    }

    private void configuraBotaoFinalizarCompra(Pacote pacote) {
        Button botaoFinalizaCompra = findViewById(R.id.activity_pagamento_botao_finalizar_1);
        botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalizaCompra(pacote);
            }
        });
    }

    private void finalizaCompra(Pacote pacote) {
        Intent intent =  new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra("pacote", pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.activity_pagamento_preco_pacote_1);
        String moedaBrasileira = MoedaUtil.formataPreco(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}