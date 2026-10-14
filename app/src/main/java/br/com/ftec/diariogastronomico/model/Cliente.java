package br.com.ftec.diariogastronomico.model;

public class Cliente extends Usuario {

    private final int totalAvaliacoes;
    private final int totalFavoritos;
    private final int totalLugares;
    private final double notaMedia;

    public Cliente(String id, String nome, String email, int fotoPerfil,
                   int totalAvaliacoes, int totalFavoritos, int totalLugares, double notaMedia) {
        super(id, nome, email, fotoPerfil);
        this.totalAvaliacoes = totalAvaliacoes;
        this.totalFavoritos = totalFavoritos;
        this.totalLugares = totalLugares;
        this.notaMedia = notaMedia;
    }

    public int getTotalAvaliacoes() { return totalAvaliacoes; }
    public int getTotalFavoritos() { return totalFavoritos; }
    public int getTotalLugares() { return totalLugares; }
    public double getNotaMedia() { return notaMedia; }
}
