package br.com.ftec.diariogastronomico.ui.fragment;

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

import java.util.Locale;

import br.com.ftec.diariogastronomico.R;
import br.com.ftec.diariogastronomico.data.DadosExemplo;
import br.com.ftec.diariogastronomico.model.Cliente;
import br.com.ftec.diariogastronomico.ui.adapter.DiarioAdapter;

public class DiarioFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_diario, container, false);

        Cliente c = DadosExemplo.getClienteLogado();
        ((TextView) v.findViewById(R.id.txtStatAval)).setText(String.valueOf(c.getTotalAvaliacoes()));
        ((TextView) v.findViewById(R.id.txtStatLugares)).setText(String.valueOf(c.getTotalLugares()));
        ((TextView) v.findViewById(R.id.txtStatNota)).setText(String.format(Locale.getDefault(), "%.1f", c.getNotaMedia()));

        RecyclerView rv = v.findViewById(R.id.recyclerDiario);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new DiarioAdapter(DadosExemplo.getDiario(), new DiarioAdapter.OnAction() {
            @Override public void onEditar(br.com.ftec.diariogastronomico.model.Avaliacao a) {
                Toast.makeText(requireContext(), "Editar avaliação", Toast.LENGTH_SHORT).show();
            }
            @Override public void onExcluir(br.com.ftec.diariogastronomico.model.Avaliacao a) {
                Toast.makeText(requireContext(), "Excluir avaliação", Toast.LENGTH_SHORT).show();
            }
        }));
        return v;
    }
}
