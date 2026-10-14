package br.com.ftec.diariogastronomico.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.com.ftec.diariogastronomico.CadastroPratoActivity;
import br.com.ftec.diariogastronomico.R;
import br.com.ftec.diariogastronomico.data.DadosExemplo;
import br.com.ftec.diariogastronomico.model.Prato;
import br.com.ftec.diariogastronomico.ui.adapter.PratoGerenciarAdapter;

public class CardapioFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cardapio, container, false);

        java.util.List<Prato> pratos = DadosExemplo.getRestauranteLogado().getPratos();
        ((TextView) v.findViewById(R.id.txtSubtitulo)).setText(pratos.size() + " pratos cadastrados");

        RecyclerView rv = v.findViewById(R.id.recyclerCardapio);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new PratoGerenciarAdapter(pratos, new PratoGerenciarAdapter.OnAction() {
            @Override public void onEditar(Prato p) {
                startActivity(new Intent(requireContext(), CadastroPratoActivity.class));
            }
            @Override public void onRemover(Prato p) {
                Toast.makeText(requireContext(), "Remover " + p.getNome(), Toast.LENGTH_SHORT).show();
            }
        }));

        v.findViewById(R.id.fabAddPrato).setOnClickListener(x ->
                startActivity(new Intent(requireContext(), CadastroPratoActivity.class)));
        return v;
    }
}
