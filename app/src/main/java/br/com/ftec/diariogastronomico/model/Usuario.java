package br.com.ftec.diariogastronomico.model;

import java.io.Serializable;

public abstract class Usuario implements Serializable {

    protected String id;
    protected String nome;
    protected String email;
    protected int fotoPerfil;

    public Usuario(String id, String nome, String email, int fotoPerfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.fotoPerfil = fotoPerfil;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public int getFotoPerfil() { return fotoPerfil; }
}
