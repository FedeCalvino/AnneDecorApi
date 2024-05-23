package com.example.sistemaannedecor2.Controller;

import com.example.sistemaannedecor2.Clases.EstadoVenta;
import com.example.sistemaannedecor2.Clases.Venta;
import com.example.sistemaannedecor2.Service.EstadoVentaService;
import com.example.sistemaannedecor2.Service.VentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://anne-decor-react.vercel.app")
@RestController
@RequestMapping("/EstadoVenta")

public class EstadoVentaController {

    private EstadoVentaService estadoVentaService;

    public EstadoVentaController(EstadoVentaService evs) {
        this.estadoVentaService = evs;
    }
    /*   @GetMapping("/{idEstadoVenta}")
    public EstadoVenta buscarEstadoVentaPorId(@PathVariable int idEstadoVenta){
        return estadoVentaService.findById(idEstadoVenta);
    }*/
    @GetMapping("/{idVenta}")
    public EstadoVenta buscarEstadoVentaPorIdVenta(@PathVariable int idVenta){
        return estadoVentaService.findByIdVenta(idVenta);
    }
    @GetMapping
    public List<EstadoVenta> findAllVenta(){
        return estadoVentaService.findAll();
    }
    @PostMapping
    public EstadoVenta GuardarVenta(@RequestBody EstadoVenta Eventa){
        return estadoVentaService.Save(Eventa);
    }
    @PutMapping
    public void ActualizarVenta(@RequestBody EstadoVenta Eventa){
        estadoVentaService.update(Eventa);
    }
    @DeleteMapping("/{id}")
    public void eliminarVenta(@PathVariable int id){
        estadoVentaService.delete(id);
    }


    }

