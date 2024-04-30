package com.example.sistemaannedecor2.Clases;


public class EstadoVenta {

    public int id;
    public boolean Armada;
    public boolean Instalada;
    public boolean Pagada;
    public boolean Facturado;


    private final Byte TrueByte = 1;
    private final Byte FalseByte = 0;


    public EstadoVenta() {
        this.Armada = false;
        this.Instalada = false;
        this.Pagada = false;
        this.Facturado = false;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public EstadoVenta(boolean armada, boolean instalada, boolean pagada, boolean facturado, int id) {
        Armada = armada;
        Instalada = instalada;
        Pagada = pagada;
        Facturado = facturado;
        this.id = id;
    }

    public EstadoVenta(int Id) {
        this.id = Id;
    }

    public boolean isArmada() {
        return Armada;
    }

    public boolean isInstalada() {
        return Instalada;
    }

    public boolean isPagada() {
        return Pagada;
    }

    public Byte isArmadaByte() {
        if(Armada) return TrueByte;
        return FalseByte;
    }
    public Byte isFacturadoByte() {
        if(Facturado) return TrueByte;
        return FalseByte;
    }

    public Byte isInstaladaByte() {
        if(Instalada) return TrueByte;
        return FalseByte;
    }

    public Byte isPagadaByte() {
        if(Pagada) return TrueByte;
        return FalseByte;
    }

    public void setArmada(boolean Armada) {
        this.Armada = Armada;
    }

    public void setInstalada(boolean Instalada) {
        this.Instalada = Instalada;
    }

    public void setPagada(boolean Pagada) {
        this.Pagada = Pagada;
    }
    public void setFacturado(boolean Pagada) {
        this.Pagada = Pagada;
    }
    
    public String GetEstado(){
        if(Armada){
            if(Instalada){
                if(Pagada){
                    return "PAGADO"; 
                }else{
                    return "INSTALADO"; 
                }
            }else{
               return "ARMADO"; 
            }
        }else{
           return "SIN COMPLETAR";
        }
    }
    
    
}
