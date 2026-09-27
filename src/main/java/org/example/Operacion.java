package org.example;

public class Operacion {
    private String idAlumno;
    private String idInstituto;
    private String expresion;
    private double resultado;
    private boolean procesada;

    // Constructor vacío
    public Operacion() {}

    public Operacion(String idAlumno, String idInstituto, String expresion) {
        this.idAlumno = idAlumno;
        this.idInstituto = idInstituto;
        this.expresion = expresion;
        this.procesada = false;
    }

    // Getters y Setters
    public String getIdAlumno() { return idAlumno; }
    public void setIdAlumno(String idAlumno) { this.idAlumno = idAlumno; }

    public String getIdInstituto() { return idInstituto; }
    public void setIdInstituto(String idInstituto) { this.idInstituto = idInstituto; }

    public String getExpresion() { return expresion; }
    public void setExpresion(String expresion) { this.expresion = expresion; }

    public double getResultado() { return resultado; }
    public void setResultado(double resultado) {
        this.resultado = resultado;
        this.procesada = true;
    }

    public boolean isProcesada() { return procesada; }
    public void setProcesada(boolean procesada) { this.procesada = procesada; }
}
