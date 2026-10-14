package br.com.ftec.diariogastronomico.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.ftec.diariogastronomico.R;
import br.com.ftec.diariogastronomico.model.Avaliacao;
import br.com.ftec.diariogastronomico.model.TipoAvaliacao;
import br.com.ftec.diariogastronomico.util.Ui;

public class DiarioAdapter extends RecyclerView.Adapter<DiarioAdapter.VH> {

    public interface OnAction {
        void onEditar(Avaliacao a);
        void onExcluir(Avaliacao a);
    }

    private final List<Avaliacao> itens;
    private final OnAction listener;

    public DiarioAdapter(List<Avaliacao> itens, OnAction listener) {
        this.itens = itens;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diario, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        Avaliacao a = itens.get(position);
        h.imgAlvo.setImageResource(a.getAlvoImagem());
        h.txtNome.setText(a.getAlvoNome());
        h.txtData.setText(a.getData());
        h.txtComentario.setText(a.getComentario());
        h.txtTipo.setText(a.getTipo().getRotulo());
        if (a.getTipo() == TipoAvaliacao.PRATO) {
            h.txtTipo.setBackgroundResource(R.drawable.bg_pill_brand);
            h.txtTipo.setTextColor(h.itemView.getContext().getColor(R.color.brand_primary));
        } else {
            h.txtTipo.setBackgroundResource(R.drawable.bg_pill_success);
            h.txtTipo.setTextColor(h.itemView.getContext().getColor(R.color.success));
        }
        Ui.renderStars(h.layoutStars, a.getNota(), 14);
        h.btnEditar.setOnClickListener(v -> { if (listener != null) listener.onEditar(a); });
        h.btnExcluir.setOnClickListener(v -> { if (listener != null) listener.onExcluir(a); });
    }

    @Override
    public int getItemCount() { return itens.size(); }

    static class VH extends RecyclerView.ViewHolder {
        final ImageView imgAlvo;
        final TextView txtNome, txtTipo, txtData, txtComentario;
        final LinearLayout layoutStars;
        final View btnEditar, btnExcluir;
        VH(@NonNull View v) {
            super(v);
            imgAlvo = v.findViewById(R.id.imgAlvo);
            txtNome = v.findViewById(R.id.txtNome);
            txtTipo = v.findViewById(R.id.txtTipo);
            txtData = v.findViewById(R.id.txtData);
            txtComentario = v.findViewById(R.id.txtComentario);
            layoutStars = v.findViewById(R.id.layoutStars);
            btnEditar = v.findViewById(R.id.btnEditar);
            btnExcluir = v.findViewById(R.id.btnExcluir);
        }
    }
}
