
package com.example.sistemaannedecor2.Clases;


public class TipoTela {
    public int Id;
    public String Nombre;
    public String Color;
    public String Descripcion;

    public TipoTela(String nombre, String descripcion,String color) {
        this.Nombre = nombre;
        this.Color=color;
        this.Descripcion = descripcion;
    }

    /*public TipoTela(Integer id,String nombre, String descripcion,String color) {
        this.Id=id;
        this.Nombre = nombre;
        this.Color=color;
        this.Descripcion = descripcion;
    }*/

    public void setId(int id) {
        Id = id;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public void setColor(String color) {
        Color = color;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public int getId() {
        return Id;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public String getColor() {
        return Color;
    }

    @Override
    public String toString() {
        return Nombre +"   "+ Color;
    }
    
    
}
