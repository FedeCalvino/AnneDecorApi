package com.example.sistemaannedecor2.Dto;

import com.example.sistemaannedecor2.Clases.Cortina;

import java.util.ArrayList;
import java.util.List;

public class DtoInstalacion {
    private int IDInstalacion;
    private int IdVenta;
    String Start;
    String End;
    String Aclaraciones;
    String title;
    String Direccion;
    String Telefono;
    String Obra;
    List<DtoVentacortina> cortinas;


    public DtoInstalacion(int idVenta, String start, String end, String aclaraciones, String titulo) {
        IdVenta = idVenta;
        Start = start;
        End = end;
        Aclaraciones = aclaraciones;
        title = titulo;
        cortinas=new ArrayList<>();

    }
    public void AddCortina(DtoVentacortina c){
        cortinas.add(c);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }


    public void setObra(String obra) {
        Obra = obra;
    }

    public void setCortinas(List<DtoVentacortina> cortinas) {
        this.cortinas = cortinas;
    }

    public void setAclaraciones(String aclaraciones) {
        Aclaraciones = aclaraciones;
    }

    public String getTitle() {
        return title;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }



    public String getObra() {
        return Obra;
    }

    public List<DtoVentacortina> getCortinas() {
        return cortinas;
    }

    public String getAclaraciones() {
        return Aclaraciones;
    }

    public int getIDInstalacion() {
        return IDInstalacion;
    }

    public void setIDInstalacion(int IDInstalacion) {
        this.IDInstalacion = IDInstalacion;
    }

    public DtoInstalacion() {
    }

    public String getTitulo() {
        return title;
    }

    public void setTitulo(String titulo) {
        title = titulo;
    }

    public void setIdVenta(int idVenta) {
        IdVenta = idVenta;
    }

    public void setStart(String start) {
        Start = start;
    }

    public void setEnd(String end) {
        End = end;
    }


    public int getIdVenta() {
        return IdVenta;
    }

    public String getStart() {
        return Start;
    }

    public String getEnd() {
        return End;
    }


}
