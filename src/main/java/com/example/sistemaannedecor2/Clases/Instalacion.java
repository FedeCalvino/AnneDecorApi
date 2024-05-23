
package com.example.sistemaannedecor2.Clases;

import java.util.Date;


public class Instalacion {
    int Id;
    Venta venta;
    int IdVenta;
    Date fecha;
    String Aclaraciones;

    public Instalacion(int Id, Venta venta, Date fecha) {
        this.Id = Id;
        this.venta = venta;
        this.fecha = fecha;
    }
    
    public void AgregarDiscripciones(String desc){
        this.Aclaraciones=desc;
    }
}
