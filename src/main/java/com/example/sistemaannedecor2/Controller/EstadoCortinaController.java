package com.example.sistemaannedecor2.Controller;

import com.example.sistemaannedecor2.Clases.EstadoCortina;
import com.example.sistemaannedecor2.Clases.EstadoVenta;
import com.example.sistemaannedecor2.Service.EstadoCortinaService;
import com.example.sistemaannedecor2.Service.EstadoVentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EstadoCortina")

public class EstadoCortinaController {

    private EstadoCortinaService estadoCortinaService;

    public EstadoCortinaController(EstadoCortinaService es) {
        this.estadoCortinaService = es;
    }

    @GetMapping
    public List<EstadoCortina> findAllEstadoCortina(){
        return estadoCortinaService.findAll();
    }
    @PostMapping
    public EstadoCortina GuardarEstadoCortina(@RequestBody EstadoCortina Ecortina){
        return estadoCortinaService.Save(Ecortina);
    }
    @PutMapping
    public void ActualizarEstadoCortina(@RequestBody EstadoCortina Ecortina){
        estadoCortinaService.update(Ecortina);
    }
    @DeleteMapping("/{id}")
    public void eliminarEstadoCortina(@PathVariable int id){
        estadoCortinaService.delete(id);
    }


    }

