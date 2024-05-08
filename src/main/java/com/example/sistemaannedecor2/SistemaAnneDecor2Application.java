package com.example.sistemaannedecor2;

import com.example.sistemaannedecor2.Clases.Cliente;
import com.example.sistemaannedecor2.Clases.Cortina;
import com.example.sistemaannedecor2.Clases.Venta;
import com.example.sistemaannedecor2.Conexiones.Conexion;
import com.example.sistemaannedecor2.Service.ClienteService;
import com.example.sistemaannedecor2.Service.CortinaService;
import com.example.sistemaannedecor2.Service.VentaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.util.List;

@SpringBootApplication
public class SistemaAnneDecor2Application {
    static VentaService ventaService = new VentaService();
    public static void main(String[] args) throws ParseException {
        //Conexion.createTables();
        //JSONObject jsonObject = new JSONObject();
        //Cortina c = CortinaService.findById(2);
        ventaService.findAllDtoVC(4);
        //List<Venta> listita = vs.findAll();
        //vs.Save(new Venta(1,1222));
        //clienteService.Save(new Cliente(998877663,"John Doe", 12345678,"pureba 1300 esq verdi"));
        SpringApplication.run(SistemaAnneDecor2Application.class, args);

    }
}
