package com.example.sistemaannedecor2.Dto;

public class DtoVentacortina {
    int IdCortina;
    String Ambiente;
    String AltoCortina;
    String AnchoCortina;
    boolean Motorizada;
    String NombreTela;
    String ColorTela;
    String EstadoCortina;
    String cano;
    String Cadena;

    private static byte trueByte = 1;
    private static byte falseByte = 0;

    public void setCadena(String cadena) {
        Cadena = cadena;
    }

    public void setIdCortina(int idCortina) {
        IdCortina = idCortina;
    }

    public int getIdCortina() {
        return IdCortina;
    }

    public void setCano(String cano) {
        this.cano = cano;
    }

    public String getCadena() {
        return Cadena;
    }

    public String getCano() {
        return cano;
    }

    public DtoVentacortina(){
    }
    public Byte Motorizada(){
        if(Motorizada) return trueByte;
        else return falseByte;
    }


    public String getAmbiente() {
        return Ambiente;
    }

    public String getAltoCortina() {
        return AltoCortina;
    }

    public String getAnchoCortina() {
        return AnchoCortina;
    }

    public boolean isMotorizada() {
        return Motorizada;
    }

    public String getColorTela() {
        return ColorTela;
    }

    public String getNombreTela() {
        return NombreTela;
    }

    public String getEstadoCortina() {
        return EstadoCortina;
    }

    public void setAmbiente(String ambiente) {
        Ambiente = ambiente;
    }

    public void setAltoCortina(String altoCortina) {
        AltoCortina = altoCortina;
    }

    public void setAnchoCortina(String anchoCortina) {
        AnchoCortina = anchoCortina;
    }

    public void setMotorizada(Byte motorizada) {
        if(motorizada == trueByte) Motorizada = true;
        else Motorizada = false;
    }

    public void setColorTela(String colorTela) {
        ColorTela = colorTela;
    }

    public void setNombreTela(String nombreTela) {
        NombreTela = nombreTela;
    }

    public void setEstadoCortina(String estadoCortina) {
        EstadoCortina = estadoCortina;
    }
}
