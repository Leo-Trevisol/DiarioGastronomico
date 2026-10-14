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

import br.com.ftec.diariogastronomico.MainActivity;
import br.com.ftec.diariogastronomico.R;
import br.com.ftec.diariogastronomico.data.DadosExemplo;
import br.com.ftec.diariogastronomico.model.Cliente;

public class PerfilFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        Cliente c = DadosExemplo.getClienteLogado();
        ((TextView) v.findViewById(R.id.txtNome)).setText(c.getNome());
        ((TextView) v.findViewById(R.id.txtEmail)).setText(c.getEmail());
        ((TextView) v.findViewById(R.id.txtStatAval)).setText(String.valueOf(c.getTotalAvaliacoes()));
        ((TextView) v.findViewById(R.id.txtStatFav)).setText(String.valueOf(c.getTotalFavoritos()));
        ((TextView) v.findViewById(R.id.txtStatLugares)).setText(String.valueOf(c.getTotalLugares()));

        v.findViewById(R.id.btnEditarPerfil).setOnClickListener(x ->
                Toast.makeText(requireContext(), "Editar perfil", Toast.LENGTH_SHORT).show());
        v.findViewById(R.id.rowSair).setOnClickListener(x -> {
            Intent i = new Intent(requireContext(), MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        });
        return v;
    }
}
