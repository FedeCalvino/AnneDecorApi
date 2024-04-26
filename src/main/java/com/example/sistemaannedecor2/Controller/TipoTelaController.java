package com.example.sistemaannedecor2.Controller;

import com.example.sistemaannedecor2.Clases.Cliente;
import com.example.sistemaannedecor2.Clases.TipoTela;
import com.example.sistemaannedecor2.Service.ClienteService;
import com.example.sistemaannedecor2.Service.TipoTelaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TipoTela")

public class TipoTelaController {

    private TipoTelaService TpService;

    public TipoTelaController(TipoTelaService cs) {
        this.TpService = cs;
    }

    @GetMapping
    public List<TipoTela> findAllTipoTela(){
        return TpService.findAll();
    }
    @PostMapping
    public TipoTela GuardarTipoTela(@RequestBody TipoTela tp){
        return TpService.Save(tp);
    }
    @PutMapping
    public void ActualizarTipoTela(@RequestBody TipoTela tp){
        TpService.update(tp);
    }
    @DeleteMapping({"/id"})
    public void eliminarTipoTela(@PathVariable int id){
        TpService.delete(id);
    }
    @GetMapping("/id")
    public TipoTela buscarTipoTelaPorId(@PathVariable Integer id){
        return TpService.findById(id);
    }

    }

