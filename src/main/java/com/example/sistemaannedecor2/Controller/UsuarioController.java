package com.example.sistemaannedecor2.Controller;


import com.example.sistemaannedecor2.Clases.TipoTela;
import com.example.sistemaannedecor2.Dto.DtoUsuario;
import com.example.sistemaannedecor2.Service.TipoTelaService;
import com.example.sistemaannedecor2.Service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:5174")
@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
    private UsuarioService UService;

    public UsuarioController(UsuarioService cs) {
        this.UService = cs;
    }

    @GetMapping("/{Mail}/{Pass}")
    public DtoUsuario BuscarUsuario(@PathVariable String Mail,@PathVariable String Pass){
        DtoUsuario dt = new DtoUsuario(Mail,Pass);
        return UService.findUsuario(dt);
    }

}
