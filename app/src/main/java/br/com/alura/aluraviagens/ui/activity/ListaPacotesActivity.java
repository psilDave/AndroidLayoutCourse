package br.com.alura.aluraviagens.ui.activity;

import static br.com.alura.aluraviagens.ui.Interfaces.PacoteActivityConstantes.CHAVE_PACOTE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.dao.PacoteDAO;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Pacotes";
    private final List<Pacote> pacotes;

    public ListaPacotesActivity() {
        this.pacotes = new PacoteDAO().lista();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APP_BAR);
        configuraLista();

    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.activity_lista_de_pacotes_lista_de_pacotes);
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
        listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selecionaPacote(i, pacotes);
            }
        });
    }

    private void selecionaPacote(int i, List<Pacote> pacotes) {
        Pacote pacoteSelecionado = pacotes.get(i);
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteSelecionado);
        startActivity(intent);
    }
}