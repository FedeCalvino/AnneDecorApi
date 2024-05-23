package com.example.sistemaannedecor2.Dto;

import java.util.Date;

public class DtoVenta {
    public String NombreCliente;
    public int IdCliente;
    public int IdVenata;
    public Date FechaVenta;
    public String Obra;
    public int Monto;
    public String EstadoActual;
    public String ColorEstado;

    public DtoVenta() {
    }

    public void setObra(String obra) {
        Obra = obra;
    }

    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }

    public void setIdCliente(int idCliente) {
        IdCliente = idCliente;
    }

    public void setIdVenata(int idVenata) {
        IdVenata = idVenata;
    }

    public void setMonto(int monto) {
        Monto = monto;
    }

    public void setFechaVenta(Date fechaVenta) {
        FechaVenta = fechaVenta;
    }

    public void setColorEstado(String colorEstado) {
        ColorEstado = colorEstado;
    }

    public void setEstadoActual(String estadoActual) {
        EstadoActual = estadoActual;
    }
}
