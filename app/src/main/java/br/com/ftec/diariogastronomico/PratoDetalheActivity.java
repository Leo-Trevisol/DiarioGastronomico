package br.com.ftec.diariogastronomico;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Locale;

import br.com.ftec.diariogastronomico.data.DadosExemplo;
import br.com.ftec.diariogastronomico.model.Prato;
import br.com.ftec.diariogastronomico.model.TipoAvaliacao;
import br.com.ftec.diariogastronomico.ui.adapter.AvaliacaoAdapter;
import br.com.ftec.diariogastronomico.ui.adapter.FotoAdapter;

public class PratoDetalheActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_prato_detalhe);

        String id = getIntent().getStringExtra("pratoId");
        Prato p = DadosExemplo.getPrato(id != null ? id : "r1p1");

        ((ImageView) findViewById(R.id.imgPrato)).setImageResource(p.getFoto());
        ((TextView) findViewById(R.id.txtNome)).setText(p.getNome());
        ((TextView) findViewById(R.id.txtPreco)).setText(p.getPrecoFormatado());
        ((TextView) findViewById(R.id.txtCategoria)).setText(p.getCategoria());
        ((TextView) findViewById(R.id.txtNota)).setText(String.format(Locale.getDefault(), "%.1f", p.getNotaMedia()));
        ((TextView) findViewById(R.id.txtTotalAval)).setText("(" + p.getTotalAvaliacoes() + " avaliações)");
        ((TextView) findViewById(R.id.txtDescricao)).setText(p.getDescricao());

        RecyclerView fotos = findViewById(R.id.recyclerFotos);
        fotos.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        fotos.setAdapter(new FotoAdapter(p.getFotos()));

        RecyclerView avaliacoes = findViewById(R.id.recyclerAvaliacoes);
        avaliacoes.setLayoutManager(new LinearLayoutManager(this));
        avaliacoes.setAdapter(new AvaliacaoAdapter(DadosExemplo.getRestaurante("r1").getAvaliacoes(), false));

        onClick(R.id.btnVoltar, this::finish);
        onClick(R.id.btnAvaliarPrato, () -> {
            Intent i = new Intent(this, AvaliarActivity.class);
            i.putExtra("tipo", TipoAvaliacao.PRATO.name());
            i.putExtra("alvoNome", p.getNome());
            i.putExtra("alvoDesc", p.getCategoria() + " · " + p.getPrecoFormatado());
            i.putExtra("alvoImagem", p.getFoto());
            startActivity(i);
        });
    }

    @Override
    protected boolean applyTopInset() {
        return false;
    }
}
