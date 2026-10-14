package br.com.ftec.diariogastronomico.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.io.Serializable;

public class Prato implements Serializable {

    private final String id;
    private final String nome;
    private final String descricao;
    private final double preco;
    private final String categoria;
    private boolean disponivel;
    private final double notaMedia;
    private final int totalAvaliacoes;
    private final int foto;
    private final List<Foto> fotos = new ArrayList<>();

    public Prato(String id, String nome, String descricao, double preco, String categoria,
                 boolean disponivel, double notaMedia, int totalAvaliacoes, int foto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.disponivel = disponivel;
        this.notaMedia = notaMedia;
        this.totalAvaliacoes = totalAvaliacoes;
        this.foto = foto;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public double getPreco() { return preco; }
    public String getPrecoFormatado() { return String.format(Locale.getDefault(), "R$ %.2f", preco); }
    public String getCategoria() { return categoria; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    public double getNotaMedia() { return notaMedia; }
    public int getTotalAvaliacoes() { return totalAvaliacoes; }
    public int getFoto() { return foto; }
    public List<Foto> getFotos() { return fotos; }
    public Prato addFoto(Foto f) { fotos.add(f); return this; }
}
