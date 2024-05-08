package com.example.sistemaannedecor2.Controller;

import com.example.sistemaannedecor2.Clases.Cliente;
import com.example.sistemaannedecor2.Clases.Cortina;
import com.example.sistemaannedecor2.Clases.TipoCortina.Roller;
import com.example.sistemaannedecor2.Clases.Venta;
import com.example.sistemaannedecor2.Conexiones.CortinaConexion;
import com.example.sistemaannedecor2.Service.ClienteService;
import com.example.sistemaannedecor2.Service.CortinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5175")
@RestController
@RequestMapping("/Cortinas")

public class CortinaController {

    private CortinaService cortinaService;

    public CortinaController(CortinaService cortinaS) {
        this.cortinaService = cortinaS;
    }

    @GetMapping("/Venta/{id}")
    public List<Cortina> findCortinasByVenta(@PathVariable int id){
        return cortinaService.findCortinasByVenta(id);
    }
    @GetMapping
    public List<Cortina> findAllCortinas(){
        return cortinaService.findAll();
    }
    @PostMapping
    public Cortina GuardarCortina(@RequestBody Cortina c){
        return cortinaService.Save(c);
    }
    @PutMapping
    public void ActualizarCortina(@RequestBody Cortina c){
        cortinaService.update(c);
    }
    @DeleteMapping({"/{id}"})
    public void eliminarCortina(@PathVariable int id){
        cortinaService.delete(id);
    }
    @GetMapping("/{Id}")
    public Cortina buscarCortinaPorId(@PathVariable Integer Id){
        return cortinaService.findById(Id);
    }
    @PostMapping("/Roller")
    public Cortina GuardarCortina(@RequestBody Roller r){
        return cortinaService.SaveRoller(r);
    }

    }

