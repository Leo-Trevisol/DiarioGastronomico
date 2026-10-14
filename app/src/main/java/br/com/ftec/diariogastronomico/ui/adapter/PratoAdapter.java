package br.com.ftec.diariogastronomico.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

import br.com.ftec.diariogastronomico.R;
import br.com.ftec.diariogastronomico.model.Prato;

public class PratoAdapter extends RecyclerView.Adapter<PratoAdapter.VH> {

    public interface OnClick { void onClick(Prato prato); }

    private final List<Prato> itens;
    private final OnClick listener;

    public PratoAdapter(List<Prato> itens, OnClick listener) {
        this.itens = itens;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prato, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        Prato p = itens.get(position);
        h.imgPrato.setImageResource(p.getFoto());
        h.txtNome.setText(p.getNome());
        h.txtDescricao.setText(p.getDescricao());
        h.txtPreco.setText(p.getPrecoFormatado());
        h.txtNota.setText(String.format(Locale.getDefault(), "%.1f", p.getNotaMedia()));
        h.root.setOnClickListener(v -> { if (listener != null) listener.onClick(p); });
    }

    @Override
    public int getItemCount() { return itens.size(); }

    static class VH extends RecyclerView.ViewHolder {
        final View root;
        final ImageView imgPrato;
        final TextView txtNome, txtDescricao, txtPreco, txtNota;
        VH(@NonNull View v) {
            super(v);
            root = v.findViewById(R.id.itemRoot);
            imgPrato = v.findViewById(R.id.imgPrato);
            txtNome = v.findViewById(R.id.txtNome);
            txtDescricao = v.findViewById(R.id.txtDescricao);
            txtPreco = v.findViewById(R.id.txtPreco);
            txtNota = v.findViewById(R.id.txtNota);
        }
    }
}
