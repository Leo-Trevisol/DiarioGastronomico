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
import br.com.ftec.diariogastronomico.model.Foto;
import br.com.ftec.diariogastronomico.util.Ui;

public class AvaliacaoAdapter extends RecyclerView.Adapter<AvaliacaoAdapter.VH> {

    private final List<Avaliacao> itens;
    private final boolean mostrarTipo;

    public AvaliacaoAdapter(List<Avaliacao> itens, boolean mostrarTipo) {
        this.itens = itens;
        this.mostrarTipo = mostrarTipo;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_avaliacao, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        Avaliacao a = itens.get(position);
        h.imgAvatar.setImageResource(a.getAutorFoto());
        h.txtNome.setText(a.getAutorNome());
        h.txtData.setText(a.getData());
        h.txtComentario.setText(a.getComentario());
        if (mostrarTipo) {
            h.txtTipo.setVisibility(View.VISIBLE);
            h.txtTipo.setText(a.getTipo().getRotulo());
        } else {
            h.txtTipo.setVisibility(View.GONE);
        }
        Ui.renderStars(h.layoutStars, a.getNota(), 14);

        h.layoutFotos.removeAllViews();
        if (a.getFotos().isEmpty()) {
            h.layoutFotos.setVisibility(View.GONE);
        } else {
            h.layoutFotos.setVisibility(View.VISIBLE);
            float d = h.itemView.getResources().getDisplayMetrics().density;
            int size = Math.round(72 * d);
            int gap = Math.round(8 * d);
            for (Foto f : a.getFotos()) {
                ImageView iv = new ImageView(h.itemView.getContext());
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(size, size);
                lp.setMarginEnd(gap);
                iv.setLayoutParams(lp);
                iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                iv.setImageResource(f.getImagem());
                h.layoutFotos.addView(iv);
            }
        }
    }

    @Override
    public int getItemCount() { return itens.size(); }

    static class VH extends RecyclerView.ViewHolder {
        final ImageView imgAvatar;
        final TextView txtNome, txtTipo, txtData, txtComentario;
        final LinearLayout layoutStars, layoutFotos;
        VH(@NonNull View v) {
            super(v);
            imgAvatar = v.findViewById(R.id.imgAvatar);
            txtNome = v.findViewById(R.id.txtNome);
            txtTipo = v.findViewById(R.id.txtTipo);
            txtData = v.findViewById(R.id.txtData);
            txtComentario = v.findViewById(R.id.txtComentario);
            layoutStars = v.findViewById(R.id.layoutStars);
            layoutFotos = v.findViewById(R.id.layoutFotos);
        }
    }
}
