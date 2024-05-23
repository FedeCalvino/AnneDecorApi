
 
package com.example.sistemaannedecor2.Clases;

import com.example.sistemaannedecor2.Service.ClienteService;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Venta{
    int Id;
    Cliente cliente;
    public int IdCliente;
    private ArrayList<Cortina> cortinas = new ArrayList<Cortina>();
    EstadoVenta Estado;
    public java.sql.Date Fecha;
    public int PrecioFinal;
    public String Obra;

    public int getClienteIdNoPorCliente(){
        return this.IdCliente;
    }

    public String getObra() {
        return Obra;
    }

    public void setObra(String obra) {
        Obra = obra;
    }

    public Venta() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPrecio() {
        return PrecioFinal;
    }

    public int getEstadoId(){
        return Estado.id;
    }
    public java.sql.Date getFecha(){
        return Fecha;
    }



    public Venta(int IdCliente, int PrecioFinal,String Obra){
        this.IdCliente = IdCliente;
        this.PrecioFinal = PrecioFinal;
        this.Obra = Obra;
    }



    public int compareTo(Venta r) {
        if (r.PrecioFinal > this.PrecioFinal) {
            return 1;
        } else if (r.PrecioFinal == this.PrecioFinal) {
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {

        String cortinasStr = "";
        String ret = "Cliente: " + cliente.Nombre + "\n"
                + "          Direccion: " + cliente.direccion + "\n"
                + "                  Cortinas " + cortinas.size() + "          Estado:  "  + this.Estado.GetEstado();
        return ret;

    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.IdCliente=cliente.Id;
    }

    public void setCortinas(ArrayList<Cortina> cortinas) {
        this.cortinas = cortinas;
    }

    public void setEstadoVenta(EstadoVenta estado) {
        Estado = estado;
    }

    public void setFecha(java.sql.Date fecha) {
        Fecha = fecha;
    }

    public void setPrecioFinal(int precio) {
        PrecioFinal = precio;
    }

    public ArrayList<Cortina> GetListaCortinas() {
        return this.cortinas;
    }

    public void AddCortina(Cortina c) {
        this.cortinas.add(c);
    }

    public void setListaCortinas(ArrayList<Cortina> cor) {
        this.cortinas = cor;
    }

}
