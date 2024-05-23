package com.example.sistemaannedecor2.Dto;

import com.example.sistemaannedecor2.Clases.Cortina;

import java.util.List;

public class DtoModalInstalacion {
    int IdVenta;
    String NombreCliente;
    String Direccion;
    String Telefono;
    String Email;
    String Obra;
    List<DtoVentacortina> cortinas;
    String Aclaraciones;
}
