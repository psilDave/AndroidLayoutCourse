package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.utils.DataUtil;
import br.com.alura.aluraviagens.utils.MoedaUtil;
import br.com.alura.aluraviagens.utils.ResourceUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra("pacote")){
            Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");
            mostraInformacoesPacote(pacote);
        }
    }

    private void mostraInformacoesPacote(Pacote pacote) {
        mostraLocalPacote(pacote);
        mostraDataPacote(pacote);
        mostraPrecoPacote(pacote);
        mostraImagemPacote(pacote);
    }

    private void mostraImagemPacote(Pacote pacote) {
        ImageView imagem = findViewById(R.id.activity_resumo_compra_imagem_pacote_1);
        Drawable drawable = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }

    private void mostraPrecoPacote(Pacote pacote) {
        TextView preco = findViewById(R.id.activity_resumo_compra_preco_1);
        preco.setText(MoedaUtil.formataPreco(pacote.getPreco()));
    }

    private void mostraDataPacote(Pacote pacote) {
        TextView data = findViewById(R.id.activity_resumo_compra_data_1);
        data.setText(DataUtil.formataData(pacote));
    }

    private void mostraLocalPacote(Pacote pacote) {
        TextView local = findViewById(R.id.activity_resumo_compra_local_1);
        local.setText(pacote.getLocal());
    }
}