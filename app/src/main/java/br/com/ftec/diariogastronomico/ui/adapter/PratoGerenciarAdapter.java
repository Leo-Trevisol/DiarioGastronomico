package br.com.ftec.diariogastronomico.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.google.android.material.switchmaterial.SwitchMaterial;

import br.com.ftec.diariogastronomico.R;
import br.com.ftec.diariogastronomico.model.Prato;

public class PratoGerenciarAdapter extends RecyclerView.Adapter<PratoGerenciarAdapter.VH> {

    public interface OnAction {
        void onEditar(Prato p);
        void onRemover(Prato p);
    }

    private final List<Prato> itens;
    private final OnAction listener;

    public PratoGerenciarAdapter(List<Prato> itens, OnAction listener) {
        this.itens = itens;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prato_gerenciar, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        Prato p = itens.get(position);
        h.imgPrato.setImageResource(p.getFoto());
        h.txtNome.setText(p.getNome());
        h.txtCategoria.setText(p.getCategoria());
        h.txtPreco.setText(p.getPrecoFormatado());
        h.switchDisponivel.setOnCheckedChangeListener(null);
        h.switchDisponivel.setChecked(p.isDisponivel());
        h.switchDisponivel.setOnCheckedChangeListener((b, checked) -> p.setDisponivel(checked));
        h.btnEditar.setOnClickListener(v -> { if (listener != null) listener.onEditar(p); });
        h.btnRemover.setOnClickListener(v -> { if (listener != null) listener.onRemover(p); });
    }

    @Override
    public int getItemCount() { return itens.size(); }

    static class VH extends RecyclerView.ViewHolder {
        final ImageView imgPrato;
        final TextView txtNome, txtCategoria, txtPreco;
        final SwitchMaterial switchDisponivel;
        final View btnEditar, btnRemover;
        VH(@NonNull View v) {
            super(v);
            imgPrato = v.findViewById(R.id.imgPrato);
            txtNome = v.findViewById(R.id.txtNome);
            txtCategoria = v.findViewById(R.id.txtCategoria);
            txtPreco = v.findViewById(R.id.txtPreco);
            switchDisponivel = v.findViewById(R.id.switchDisponivel);
            btnEditar = v.findViewById(R.id.btnEditar);
            btnRemover = v.findViewById(R.id.btnRemover);
        }
    }
}
