package br.com.ftec.diariogastronomico.model;

public enum TipoAvaliacao {
    RESTAURANTE("Restaurante"),
    PRATO("Prato");

    private final String rotulo;

    TipoAvaliacao(String rotulo) {
        this.rotulo = rotulo;
    }

    public String getRotulo() {
        return rotulo;
    }
}
