package br.com.ftec.diariogastronomico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Avaliacao implements Serializable {

    private final String id;
    private final TipoAvaliacao tipo;
    private final int nota;
    private final String comentario;
    private final String data;
    private final String autorNome;
    private final int autorFoto;
    private final String alvoNome;
    private final int alvoImagem;
    private final List<Foto> fotos = new ArrayList<>();

    public Avaliacao(String id, TipoAvaliacao tipo, int nota, String comentario, String data,
                     String autorNome, int autorFoto, String alvoNome, int alvoImagem) {
        this.id = id;
        this.tipo = tipo;
        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
        this.autorNome = autorNome;
        this.autorFoto = autorFoto;
        this.alvoNome = alvoNome;
        this.alvoImagem = alvoImagem;
    }

    public String getId() { return id; }
    public TipoAvaliacao getTipo() { return tipo; }
    public int getNota() { return nota; }
    public String getComentario() { return comentario; }
    public String getData() { return data; }
    public String getAutorNome() { return autorNome; }
    public int getAutorFoto() { return autorFoto; }
    public String getAlvoNome() { return alvoNome; }
    public int getAlvoImagem() { return alvoImagem; }
    public List<Foto> getFotos() { return fotos; }
    public Avaliacao addFoto(Foto f) { fotos.add(f); return this; }
}
