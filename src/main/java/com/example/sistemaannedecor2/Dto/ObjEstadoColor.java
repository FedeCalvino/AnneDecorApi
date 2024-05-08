package com.example.sistemaannedecor2.Dto;

public class ObjEstadoColor {
    public String EstadoAct;
    public String Color;

    public void setEstadoAct(String estadoAct) {
        EstadoAct = estadoAct;
    }

    public ObjEstadoColor(String estadoAct, String color) {
        EstadoAct = estadoAct;
        Color = color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getEstadoAct() {
        return EstadoAct;
    }

    public String getColor() {
        return Color;
    }
}
