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
import br.com.ftec.diariogastronomico.model.Restaurante;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.VH> {

    public interface OnClick { void onClick(Restaurante restaurante); }

    private final List<Restaurante> itens;
    private final OnClick listener;

    public RestauranteAdapter(List<Restaurante> itens, OnClick listener) {
        this.itens = itens;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurante, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        Restaurante r = itens.get(position);
        h.imgCover.setImageResource(r.getFotoCapa());
        h.txtRating.setText(String.format(Locale.getDefault(), "%.1f", r.getNotaMedia()));
        h.txtNome.setText(r.getNomeFantasia());
        h.txtCategoria.setText(r.getCategoria() + " · " + r.getDistancia());
        h.txtEndereco.setText(r.getEndereco() + "  ·  (" + r.getTotalAvaliacoes() + ")");
        if (r.isAberto()) {
            h.txtStatus.setText("Aberto");
            h.txtStatus.setBackgroundResource(R.drawable.bg_pill_success);
            h.txtStatus.setTextColor(h.itemView.getContext().getColor(R.color.success));
        } else {
            h.txtStatus.setText("Fechado");
            h.txtStatus.setBackgroundResource(R.drawable.bg_pill_soft);
            h.txtStatus.setTextColor(h.itemView.getContext().getColor(R.color.text_secondary));
        }
        h.root.setOnClickListener(v -> { if (listener != null) listener.onClick(r); });
    }

    @Override
    public int getItemCount() { return itens.size(); }

    static class VH extends RecyclerView.ViewHolder {
        final View root;
        final ImageView imgCover;
        final TextView txtRating, txtNome, txtCategoria, txtEndereco, txtStatus;
        VH(@NonNull View v) {
            super(v);
            root = v.findViewById(R.id.itemRoot);
            imgCover = v.findViewById(R.id.imgCover);
            txtRating = v.findViewById(R.id.txtRating);
            txtNome = v.findViewById(R.id.txtNome);
            txtCategoria = v.findViewById(R.id.txtCategoria);
            txtEndereco = v.findViewById(R.id.txtEndereco);
            txtStatus = v.findViewById(R.id.txtStatus);
        }
    }
}
