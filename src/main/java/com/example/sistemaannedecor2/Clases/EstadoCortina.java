
package com.example.sistemaannedecor2.Clases;


public class EstadoCortina {
    int Id;
    boolean TelaCortada;
    boolean CañoCortado;
    boolean Armado;
    boolean Probado;

    public EstadoCortina() {
    this.Armado=false;
    this.CañoCortado=false;
    this.TelaCortada=false;
    Probado=false;
    }

    public EstadoCortina(int id) {
        Id = id;
    }

    private static byte trueByte = 1;
    private static byte falseByte = 0;
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Byte isTelaCortadaByte() {
        if (TelaCortada) return trueByte;
        return falseByte;
    }

    public void setTelaCortada(boolean TelaCortada) {
        this.TelaCortada = TelaCortada;
    }

    public Byte isCañoCortadoByte() {
        if (CañoCortado) return trueByte;
        return falseByte;
    }

    public void setCanoCortado(boolean CañoCortado) {
        this.CañoCortado = CañoCortado;
    }

    public Byte isArmadoByte() {
        if (Armado) return trueByte;
        return falseByte;
    }


    public boolean isTelaCortada() {
        return TelaCortada;
    }

    public boolean isCañoCortado() {
        return CañoCortado;
    }

    public boolean isArmado() {
        return Armado;
    }

    public boolean isProbado() {
        return Probado;
    }
    public byte isProbadoByte() {
        if (Probado) return trueByte;
        return falseByte;
    }

    public void setArmado(boolean Armado) {
        this.Armado = Armado;
    }

    public void setProbado(boolean probado) {
        Probado = probado;
    }

    public void setCañoCortado(boolean cañoCortado) {
        CañoCortado = cañoCortado;
    }
}
