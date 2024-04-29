
package com.example.sistemaannedecor2.Clases;


public class Cortina {
    int Id;
    double Alto;
    double Ancho;
    TipoTela tela;
    public EstadoCortina Estado;
    Boolean motorizada;
    private static int UltimoId=0;
    
    
    public Cortina(double Alto, double largo, Boolean motorizada,TipoTela tela,int precio) {
        Id=UltimoId+1;
        this.Alto = Alto;
        this.tela=tela;
        this.Ancho = largo;
        this.motorizada = motorizada;
        this.Estado = new EstadoCortina();
        UltimoId++;
    }
    public Cortina(int id,double Alto, double largo, Boolean motorizada,TipoTela tela,int precio) {
        this.Id=id;
        this.Alto = Alto;
        this.tela=tela;
        this.Ancho = largo;
        this.motorizada = motorizada;
        this.Estado = new EstadoCortina();

    }
    public Cortina(double Alto, double largo, Boolean motorizada,TipoTela tela) {
        Id=UltimoId+1;
        this.Alto = Alto;
        this.tela=tela;
        this.Ancho = largo;
        if(motorizada==null){
            this.motorizada = false;
        }else{
        this.motorizada = motorizada;
        }
        UltimoId++;
    }    
    public Cortina(int id,int alto, int ancho) {
        Id=id;
        this.Ancho=ancho;
        this.Alto=alto;
    }   
    public Cortina() {

    }
    public String GetCortinaToString(){
        return this.tela.Nombre+" " 
                + this.tela.Color +"\n"
                +"motrizada: "+this.motorizada+"\n"
                +"medidas "+this.Ancho+"x"+this.Alto+" ";
    }
    public int GetTipoTelaId(){
        return tela.getId();
    }
            
    public int GetEstadoCortinaId(){
        return Estado.getId();
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public double getAlto() {
        return Alto;
    }

    public void setAlto(double Alto) {
        this.Alto = Alto;
    }

    public double getAncho() {
        return Ancho;
    }

    public void setAncho(double ancho) {
        this.Ancho = ancho;
    }

    public Boolean getMotorizada() {
        return motorizada;
    }

    public void setMotorizada(Boolean motorizada) {
        this.motorizada = motorizada;
    }
 

    public static int getUltimoId() {
        return UltimoId;
    }
    
    
    
    public String GetNombreTela(){
        return tela.Nombre;
    }
    
    
}
