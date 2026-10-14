package br.com.ftec.diariogastronomico;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Locale;

import br.com.ftec.diariogastronomico.data.DadosExemplo;
import br.com.ftec.diariogastronomico.model.Restaurante;
import br.com.ftec.diariogastronomico.model.TipoAvaliacao;
import br.com.ftec.diariogastronomico.ui.adapter.AvaliacaoAdapter;
import br.com.ftec.diariogastronomico.ui.adapter.FotoAdapter;
import br.com.ftec.diariogastronomico.ui.adapter.PratoAdapter;
import br.com.ftec.diariogastronomico.util.Ui;

public class RestauranteDetalheActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_restaurante_detalhe);

        String id = getIntent().getStringExtra("restauranteId");
        Restaurante r = DadosExemplo.getRestaurante(id != null ? id : "r1");

        ((ImageView) findViewById(R.id.imgCapa)).setImageResource(r.getFotoCapa());
        ((TextView) findViewById(R.id.txtNome)).setText(r.getNomeFantasia());
        ((TextView) findViewById(R.id.txtCategoria)).setText(r.getCategoria() + " · " + r.getDistancia());
        ((TextView) findViewById(R.id.txtNota)).setText(String.format(Locale.getDefault(), "%.1f", r.getNotaMedia()));
        Ui.renderStars(findViewById(R.id.layoutStars), (int) Math.round(r.getNotaMedia()), 13);
        ((TextView) findViewById(R.id.txtTotalAval)).setText(r.getTotalAvaliacoes() + " avaliações");
        ((TextView) findViewById(R.id.txtEndereco)).setText(r.getEndereco());
        ((TextView) findViewById(R.id.txtTelefone)).setText(r.getTelefone());
        ((TextView) findViewById(R.id.txtHorario)).setText(r.getHorarioFuncionamento());
        ((TextView) findViewById(R.id.txtSobre)).setText(r.getDescricao());

        TextView status = findViewById(R.id.txtStatus);
        if (r.isAberto()) {
            status.setText("Aberto");
            status.setBackgroundResource(R.drawable.bg_pill_success);
            status.setTextColor(getColor(R.color.success));
        } else {
            status.setText("Fechado");
            status.setBackgroundResource(R.drawable.bg_pill_soft);
            status.setTextColor(getColor(R.color.text_secondary));
        }

        RecyclerView fotos = findViewById(R.id.recyclerFotos);
        fotos.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        fotos.setAdapter(new FotoAdapter(r.getFotos()));

        RecyclerView cardapio = findViewById(R.id.recyclerCardapio);
        cardapio.setLayoutManager(new LinearLayoutManager(this));
        cardapio.setAdapter(new PratoAdapter(r.getPratos(), prato -> {
            Intent i = new Intent(this, PratoDetalheActivity.class);
            i.putExtra("pratoId", prato.getId());
            startActivity(i);
        }));

        RecyclerView avaliacoes = findViewById(R.id.recyclerAvaliacoes);
        avaliacoes.setLayoutManager(new LinearLayoutManager(this));
        avaliacoes.setAdapter(new AvaliacaoAdapter(r.getAvaliacoes(), true));

        onClick(R.id.btnVoltar, this::finish);
        onClick(R.id.btnAvaliar, () -> {
            Intent i = new Intent(this, AvaliarActivity.class);
            i.putExtra("tipo", TipoAvaliacao.RESTAURANTE.name());
            i.putExtra("alvoNome", r.getNomeFantasia());
            i.putExtra("alvoDesc", r.getCategoria() + " · " + r.getDistancia());
            i.putExtra("alvoImagem", r.getFotoCapa());
            startActivity(i);
        });
    }

    @Override
    protected boolean applyTopInset() {
        return false;
    }
}
