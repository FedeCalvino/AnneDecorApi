package com.example.sistemaannedecor2.Controller;


import com.example.sistemaannedecor2.Clases.Factura;
import com.example.sistemaannedecor2.Clases.Recibo;
import com.example.sistemaannedecor2.Clases.TipoTela;
import com.example.sistemaannedecor2.Service.EstadoVentaService;
import com.example.sistemaannedecor2.Service.FacturaService;
import com.example.sistemaannedecor2.Service.TipoTelaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://anne-decor-react.vercel.app")
@RestController
@RequestMapping("/Factura")
public class FacturaController {

    private FacturaService FService;

    public FacturaController(FacturaService evs) {
        this.FService = evs;
    }
    @DeleteMapping("Recibos/{id}")
    public void eliminarRecibo(@PathVariable int id) {
        FService.deleteRecibo(id);
    }

    @GetMapping("/{id}")
    public Factura buscarFacturaPorIdVenta(@PathVariable Integer id){
        return FService.findByVentaId(id);
    }
    @GetMapping("/Recibos/{id}")
    public List<Recibo> buscarRecibosPorIdVenta(@PathVariable Integer id){
        return FService.findRecibosByVentaId(id);
    }
    @PostMapping
    public Factura GuardarFactura(@RequestBody Factura f){
        return FService.GuardarFactura(f);
    }
    @PostMapping("/Recibos/{IdVenta}")
    public Recibo GuardarFactura(@RequestBody Recibo r,@PathVariable Integer IdVenta){
        return FService.GuardarRecibo(r,IdVenta);
    }

}
