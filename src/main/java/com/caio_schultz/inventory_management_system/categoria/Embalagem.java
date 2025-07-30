package com.caio_schultz.inventory_management_system.categoria;

public enum Embalagem {

    LATA("Lata"),
    VIDRO("Vidro"),
    PLASTICO("Plástico");

    private String embalagem;

    Embalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }
}
