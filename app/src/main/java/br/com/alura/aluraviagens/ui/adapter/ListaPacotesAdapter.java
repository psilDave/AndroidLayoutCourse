package br.com.alura.aluraviagens.ui.adapter;

import static br.com.alura.aluraviagens.utils.DiasUtil.formataDia;
import static br.com.alura.aluraviagens.utils.MoedaUtil.formataPreco;
import static br.com.alura.aluraviagens.utils.ResourceUtil.devolveDrawable;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> listaDePacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> listaDePacotes, Context context) {

        this.listaDePacotes = listaDePacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaDePacotes.size();
    }

    @Override
    public Pacote getItem(int i) {
        return listaDePacotes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote_viagens, parent, false);


        Pacote pacote = listaDePacotes.get(i);

        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_viagens_preco_do_pacote);
        String precoFormatado = formataPreco(pacote.getPreco());
        preco.setText(precoFormatado);
    }

    private void mostraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_viagens_quantidade_de_dias);
        String quantidadeDeDiasDoPacote = formataDia(pacote.getDias());
        dias.setText(quantidadeDeDiasDoPacote);
    }

    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_viagens_imagem);
        Drawable drawableImagemPacote = devolveDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_localidade);
        local.setText(pacote.getLocal());
    }

}
