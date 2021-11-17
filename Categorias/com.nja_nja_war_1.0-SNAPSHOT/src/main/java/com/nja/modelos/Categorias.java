
package com.nja.modelos;


public class Categorias {
    
    private int id;
    private String camisas;
    private String blusas;
    private String pantalones;
    private String faldas;
    private String chaquetas;

    public Categorias() {
    }

    public Categorias(int id, String camisas, String blusas, String pantalones, String faldas, String chaquetas) {
        this.id = id;
        this.camisas = camisas;
        this.blusas = blusas;
        this.pantalones = pantalones;
        this.faldas = faldas;
        this.chaquetas = chaquetas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCamisas() {
        return camisas;
    }

    public void setCamisas(String camisas) {
        this.camisas = camisas;
    }

    public String getBlusas() {
        return blusas;
    }

    public void setBlusas(String blusas) {
        this.blusas = blusas;
    }

    public String getPantalones() {
        return pantalones;
    }

    public void setPantalones(String pantalones) {
        this.pantalones = pantalones;
    }

    public String getFaldas() {
        return faldas;
    }

    public void setFaldas(String faldas) {
        this.faldas = faldas;
    }

    public String getChaquetas() {
        return chaquetas;
    }

    public void setChaquetas(String chaquetas) {
        this.chaquetas = chaquetas;
    }

    public void add(Categorias C) {
        throw new UnsupportedOperationException(""); 
    }

    public void setfaldas(String string) {
        throw new UnsupportedOperationException(""); 
    }
    
    
    
}
