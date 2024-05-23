package com.example.sistemaannedecor2.Clases;

import java.util.Date;

public class Factura {
    int idFactura;
    int idVenta;
    Date FechaFinaL;
    Date FechaFactura;
    String NumeroFactura;
    int Saldo;
    int MontoPagado;
    int MontoTotal;

    public Factura(int idVenta, Date fechaFinaL, String numeroFactura, int montoTotal){
        this.idVenta = idVenta;
        FechaFinaL = fechaFinaL;
        NumeroFactura = numeroFactura;
        MontoTotal = montoTotal;
    }

    public int getMontoTotal() {
        return MontoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        MontoTotal = montoTotal;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public void setFechaFinaL(Date fechaFinaL) {
        FechaFinaL = fechaFinaL;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setFechaFactura(Date fechaFactura) {
        FechaFactura = fechaFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        NumeroFactura = numeroFactura;
    }

    public void setSaldo(int saldo) {
        Saldo = saldo;
    }

    public void setMontoPagado(int montoPagado) {
        MontoPagado = montoPagado;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public Date getFechaFactura() {
        return FechaFactura;
    }

    public java.util.Date getFechaFinaL() {
        return FechaFinaL;
    }

    public String getNumeroFactura() {
        return NumeroFactura;
    }

    public int getSaldo() {
        return Saldo;
    }

    public int getMontoPagado() {
        return MontoPagado;
    }
}
