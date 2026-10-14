package br.com.ftec.diariogastronomico.model;

import java.io.Serializable;

public class Foto implements Serializable {

    private final String id;
    private final int imagem;
    private final String legenda;

    public Foto(String id, int imagem, String legenda) {
        this.id = id;
        this.imagem = imagem;
        this.legenda = legenda;
    }

    public Foto(int imagem) {
        this("", imagem, "");
    }

    public String getId() { return id; }
    public int getImagem() { return imagem; }
    public String getLegenda() { return legenda; }
}
