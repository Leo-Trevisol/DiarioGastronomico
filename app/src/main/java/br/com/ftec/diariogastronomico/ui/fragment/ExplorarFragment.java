package br.com.ftec.diariogastronomico.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.com.ftec.diariogastronomico.R;
import br.com.ftec.diariogastronomico.RestauranteDetalheActivity;
import br.com.ftec.diariogastronomico.data.DadosExemplo;
import br.com.ftec.diariogastronomico.ui.adapter.RestauranteAdapter;

public class ExplorarFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_explorar, container, false);

        String nome = DadosExemplo.getClienteLogado().getNome().split(" ")[0];
        ((TextView) v.findViewById(R.id.txtSaudacao)).setText("Olá, " + nome + " 👋");

        RecyclerView rv = v.findViewById(R.id.recyclerRestaurantes);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new RestauranteAdapter(DadosExemplo.getRestaurantes(), restaurante -> {
            Intent i = new Intent(requireContext(), RestauranteDetalheActivity.class);
            i.putExtra("restauranteId", restaurante.getId());
            startActivity(i);
        }));
        return v;
    }
}
