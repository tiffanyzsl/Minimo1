package org.example;

public class Instituto {
    private String nom;
    private int numO;

    // Constructor vacío
    public Instituto() {}

    public Instituto(String nom) {
        this.nom = nom;
        this.numO= 0;
    }

    // Getters y Setters
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumO() {
        return numO;
    }
    public void setNumO(int numO) {
        this.numO= numO;
    }

    public void sumarOperacion() {
        this.numO++;
    }
}
