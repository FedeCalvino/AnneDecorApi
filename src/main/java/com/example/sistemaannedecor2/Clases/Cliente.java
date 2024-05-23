
package com.example.sistemaannedecor2.Clases;


public class Cliente {
    int Id;
    int Rut;
    String Nombre;
    int NumeroTelefono;
    String direccion;



    public Cliente( int rut,String Nombre, int NumeroTelefono, String direccion) {
        this.Nombre = Nombre;
        this.direccion = direccion;
        Rut=rut;
        this.NumeroTelefono = NumeroTelefono;
    }


    @Override
    public String toString() {
        return Nombre;
    }
    
    public int compareTo(Cliente c) {
        int asciiValue1 = c.Nombre.charAt(0);
        int asciiValue2 = this.Nombre.charAt(0);
        if(asciiValue1>asciiValue2){
            return 1;
        }else if(asciiValue1==asciiValue2){
            return 0;
        }
        return -1;
    }

    public int getId() {
        return Id;
    }

    public int getRut() {
        return Rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getNumeroTelefono() {
        return NumeroTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setRut(int rut) {
        Rut = rut;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        NumeroTelefono = numeroTelefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
