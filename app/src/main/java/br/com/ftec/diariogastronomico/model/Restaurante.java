package br.com.ftec.diariogastronomico.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurante extends Usuario {

    private final String nomeFantasia;
    private final String descricao;
    private final String categoria;
    private final String endereco;
    private final String telefone;
    private final String horarioFuncionamento;
    private final String distancia;
    private final int fotoCapa;
    private final double notaMedia;
    private final int totalAvaliacoes;
    private final boolean aberto;
    private final List<Prato> pratos = new ArrayList<>();
    private final List<Foto> fotos = new ArrayList<>();
    private final List<Avaliacao> avaliacoes = new ArrayList<>();

    public Restaurante(String id, String nomeFantasia, String email, String descricao,
                       String categoria, String endereco, String telefone,
                       String horarioFuncionamento, String distancia, int fotoCapa,
                       double notaMedia, int totalAvaliacoes, boolean aberto) {
        super(id, nomeFantasia, email, fotoCapa);
        this.nomeFantasia = nomeFantasia;
        this.descricao = descricao;
        this.categoria = categoria;
        this.endereco = endereco;
        this.telefone = telefone;
        this.horarioFuncionamento = horarioFuncionamento;
        this.distancia = distancia;
        this.fotoCapa = fotoCapa;
        this.notaMedia = notaMedia;
        this.totalAvaliacoes = totalAvaliacoes;
        this.aberto = aberto;
    }

    public String getNomeFantasia() { return nomeFantasia; }
    public String getDescricao() { return descricao; }
    public String getCategoria() { return categoria; }
    public String getEndereco() { return endereco; }
    public String getTelefone() { return telefone; }
    public String getHorarioFuncionamento() { return horarioFuncionamento; }
    public String getDistancia() { return distancia; }
    public int getFotoCapa() { return fotoCapa; }
    public double getNotaMedia() { return notaMedia; }
    public int getTotalAvaliacoes() { return totalAvaliacoes; }
    public boolean isAberto() { return aberto; }
    public List<Prato> getPratos() { return pratos; }
    public List<Foto> getFotos() { return fotos; }
    public List<Avaliacao> getAvaliacoes() { return avaliacoes; }

    public Restaurante addPrato(Prato p) { pratos.add(p); return this; }
    public Restaurante addFoto(Foto f) { fotos.add(f); return this; }
    public Restaurante addAvaliacao(Avaliacao a) { avaliacoes.add(a); return this; }
}
