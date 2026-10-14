package br.com.ftec.diariogastronomico.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Locale;

import br.com.ftec.diariogastronomico.CadastroEstabelecimentoActivity;
import br.com.ftec.diariogastronomico.CadastroPratoActivity;
import br.com.ftec.diariogastronomico.R;
import br.com.ftec.diariogastronomico.data.DadosExemplo;
import br.com.ftec.diariogastronomico.model.Restaurante;
import br.com.ftec.diariogastronomico.ui.adapter.AvaliacaoAdapter;

public class PainelFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_painel, container, false);

        Restaurante r = DadosExemplo.getRestauranteLogado();
        ((TextView) v.findViewById(R.id.txtNomeEstab)).setText(r.getNomeFantasia());
        ((ImageView) v.findViewById(R.id.imgCapa)).setImageResource(r.getFotoCapa());
        ((TextView) v.findViewById(R.id.txtNota)).setText(String.format(Locale.getDefault(), "%.1f", r.getNotaMedia()));
        ((TextView) v.findViewById(R.id.txtTotalAval)).setText(String.valueOf(r.getTotalAvaliacoes()));
        ((TextView) v.findViewById(R.id.txtTotalPratos)).setText(String.valueOf(r.getPratos().size()));

        v.findViewById(R.id.actNovoPrato).setOnClickListener(x ->
                startActivity(new Intent(requireContext(), CadastroPratoActivity.class)));
        v.findViewById(R.id.actEditarEstab).setOnClickListener(x ->
                startActivity(new Intent(requireContext(), CadastroEstabelecimentoActivity.class)));

        RecyclerView rv = v.findViewById(R.id.recyclerAvaliacoes);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new AvaliacaoAdapter(DadosExemplo.getAvaliacoesRecebidas(), true));
        return v;
    }
}
