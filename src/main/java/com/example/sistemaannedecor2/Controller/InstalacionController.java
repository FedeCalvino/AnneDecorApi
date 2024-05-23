package com.example.sistemaannedecor2.Controller;


import com.example.sistemaannedecor2.Clases.Recibo;
import com.example.sistemaannedecor2.Dto.DtoInstalacion;
import com.example.sistemaannedecor2.Service.InstalacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://anne-decor-react.vercel.app")
@RestController
@RequestMapping("/Instalacion")
public class InstalacionController {
    InstalacionService Iservice;

    public InstalacionController(InstalacionService Iservice) {
        this.Iservice = Iservice;
    }

    @PostMapping
    public DtoInstalacion GuardarInstalacion(@RequestBody DtoInstalacion DTOr){
        return Iservice.Save(DTOr);
    }
    @GetMapping
    public List<DtoInstalacion> GetInstalacion(){
        return Iservice.findAll();
    }
    @DeleteMapping("/{idInstalacion}")
    public void eliminarInstalacion(@PathVariable Integer idInstalacion){
        Iservice.delete(idInstalacion);
    }

}
