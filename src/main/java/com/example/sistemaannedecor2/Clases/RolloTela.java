
package com.example.sistemaannedecor2.Clases;


public class RolloTela {
    int codigo;
    double largo;
    TipoTela tipo;
    double Ancho;
    
    public RolloTela(int codigo, double largo, TipoTela tipo, double Ancho){
        this.codigo = codigo;
        this.largo = largo;
        this.tipo = tipo;
        this.Ancho = Ancho;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public TipoTela getTipo() {
        return tipo;
    }

    public void setTipo(TipoTela tipo) {
        this.tipo = tipo;
    }

    public double getAncho() {
        return Ancho;
    }

    public void setAncho(double Ancho) {
        this.Ancho = Ancho;
    }
    
    
}
