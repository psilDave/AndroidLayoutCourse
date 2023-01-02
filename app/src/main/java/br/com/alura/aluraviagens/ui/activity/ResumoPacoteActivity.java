package br.com.alura.aluraviagens.ui.activity;

import static br.com.alura.aluraviagens.ui.Interfaces.PacoteActivityConstantes.CHAVE_PACOTE;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.utils.DataUtil;
import br.com.alura.aluraviagens.utils.DiasUtil;
import br.com.alura.aluraviagens.utils.MoedaUtil;
import br.com.alura.aluraviagens.utils.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_ACTIVITY_RESUMO_PACOTE = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_ACTIVITY_RESUMO_PACOTE);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)){
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            mostraInformacoes(pacote);
            configuraBotaoPagar(pacote);
        }
    }

    private void configuraBotaoPagar(Pacote pacote) {
        Button botaoRealizaPagamento = findViewById(R.id.activity_resumo_pacote_botao_1);
        botaoRealizaPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pagarPacoteSelecionado(pacote);
            }
        });
    }

    private void mostraInformacoes(Pacote pacote) {
        mostraImagem(pacote);
        mostraLocal(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);
    }

    private void pagarPacoteSelecionado(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.activity_resumo_pacote_data_1);
        String dataFormatada = DataUtil.formataData(pacote);
        data.setText(dataFormatada);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.activity_resumo_pacote_preco_1);
        preco.setText(MoedaUtil.formataPreco(pacote.getPreco()));
    }

    private void mostraDias(Pacote pacote) {
        TextView quantidadeDeDias = findViewById(R.id.activity_resumo_pacote_quantidade_de_dias_1);
        quantidadeDeDias.setText(DiasUtil.formataDia(pacote.getDias()));
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.activity_resumo_pacote_localidade_1);
        local.setText(pacote.getLocal());
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.activity_resumo_pacote_imagem_1);
        Drawable drawablePacote = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawablePacote);
    }
}