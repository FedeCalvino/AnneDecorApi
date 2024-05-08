
package com.example.sistemaannedecor2.Clases;


public class Cortina {
    int Id;
    String Alto;
    public int IdTipoTela;
    public String Ambiente;
    String Ancho;
    TipoTela tela;
    public EstadoCortina Estado;
    Boolean motorizada;

    public void setEstado(EstadoCortina estado) {
        Estado = estado;
    }

    public void setTela(TipoTela tela) {
        this.tela = tela;
    }

    public String getAmbiente() {
        return Ambiente;
    }

    public Cortina(String Alto, String Ancho, Boolean motorizada, int Idtela, String Ambiente) {
        this.IdTipoTela=Idtela;
        this.Alto = Alto;
        this.Ancho = Ancho;
        this.Ambiente = Ambiente;
        this.motorizada = motorizada;
    }


    public String GetCortinaToString(){
        return this.tela.Nombre+" " 
                + this.tela.Color +"\n"
                +"motrizada: "+this.motorizada+"\n"
                +"medidas "+this.Ancho+"x"+this.Alto+" ";
    }
    public int GetTipoTelaId(){
        return IdTipoTela;
    }
            
    public int GetEstadoCortinaId(){
        return IdTipoTela;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAlto() {
        return Alto;
    }

    public void setAlto(String Alto) {
        this.Alto = Alto;
    }

    public String getAncho() {
        return Ancho;
    }

    public void setAncho(String ancho) {
        this.Ancho = ancho;
    }

    public Boolean getMotorizada() {
        return motorizada;
    }

    public void setMotorizada(Boolean motorizada) {
        this.motorizada = motorizada;
    }
 

    
    
    
    public String GetNombreTela(){
        return tela.Nombre;
    }
    
    
}
