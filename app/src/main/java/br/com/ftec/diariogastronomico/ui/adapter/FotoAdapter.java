package br.com.ftec.diariogastronomico.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.ftec.diariogastronomico.R;
import br.com.ftec.diariogastronomico.model.Foto;

public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.VH> {

    private final List<Foto> itens;

    public FotoAdapter(List<Foto> itens) { this.itens = itens; }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foto, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        h.imgFoto.setImageResource(itens.get(position).getImagem());
    }

    @Override
    public int getItemCount() { return itens.size(); }

    static class VH extends RecyclerView.ViewHolder {
        final ImageView imgFoto;
        VH(@NonNull View v) { super(v); imgFoto = v.findViewById(R.id.imgFoto); }
    }
}
