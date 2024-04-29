package com.example.sistemaannedecor2.Controller;

import com.example.sistemaannedecor2.Clases.Cliente;
import com.example.sistemaannedecor2.Service.ClienteService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cliente")

public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService cs) {
        this.clienteService = cs;
    }

    @GetMapping("/{str}/{Nombre}")
    public Cliente findClienteByName(@PathVariable String str,@PathVariable String Nombre){
        return ClienteService.findByName(Nombre);
    }
    @GetMapping
    public List<Cliente> findAllCliente(){
        return clienteService.findAll();
    }
    @PostMapping
    public Cliente GuardarCliente(@RequestBody Cliente cliente){
        return clienteService.Save(cliente);
    }
    @PutMapping
    public void ActualizarCliente(@RequestBody Cliente cliente){
        clienteService.update(cliente);
    }
    @DeleteMapping({"/{id}"})
    public void eliminarCliente(@PathVariable int id){
        clienteService.delete(id);
    }
    @GetMapping("/{Id}")
    public Cliente buscarClientePorId(Integer Id){
            return clienteService.findById(Id);
    }

    }

