package com.example.sistemaannedecor2.Clases;

import java.util.Date;

public class Recibo {
    int IdRecibo;
    int Facturaid;
    String numeroRecibo;
    int Monto;
    Date Fecha;
    boolean pagado;

    public Recibo(int monto, Date fecha,String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
        Monto = monto;
        Fecha = fecha;
    }

    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public void setIdRecibo(int idRecibo) {
        IdRecibo = idRecibo;
    }

    public void setFacturaid(int facturaid) {
        Facturaid = facturaid;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public void setMonto(int monto) {
        Monto = monto;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public int getIdRecibo() {
        return IdRecibo;
    }

    public int getFacturaid() {
        return Facturaid;
    }

    public int getMonto() {
        return Monto;
    }

    public boolean isPagado() {
        return pagado;
    }

    public Date getFecha() {
        return Fecha;
    }
}
