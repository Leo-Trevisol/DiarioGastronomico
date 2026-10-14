package br.com.ftec.diariogastronomico.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Locale;

import br.com.ftec.diariogastronomico.R;
import br.com.ftec.diariogastronomico.data.DadosExemplo;
import br.com.ftec.diariogastronomico.model.Restaurante;
import br.com.ftec.diariogastronomico.ui.adapter.AvaliacaoAdapter;
import br.com.ftec.diariogastronomico.util.Ui;

public class AvaliacoesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_avaliacoes, container, false);

        Restaurante r = DadosExemplo.getRestauranteLogado();
        ((TextView) v.findViewById(R.id.txtNotaResumo)).setText(String.format(Locale.getDefault(), "%.1f", r.getNotaMedia()));
        ((TextView) v.findViewById(R.id.txtTotalResumo)).setText(r.getTotalAvaliacoes() + " avaliações");
        Ui.renderStars(v.findViewById(R.id.layoutStarsResumo), (int) Math.round(r.getNotaMedia()), 14);

        RecyclerView rv = v.findViewById(R.id.recyclerRecebidas);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new AvaliacaoAdapter(DadosExemplo.getAvaliacoesRecebidas(), true));
        return v;
    }
}
