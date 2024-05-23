package com.example.sistemaannedecor2.Service;


import com.example.sistemaannedecor2.Clases.Factura;
import com.example.sistemaannedecor2.Clases.Recibo;
import com.example.sistemaannedecor2.Conexiones.FacturaConexion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

    private final FacturaConexion FCon;

    public FacturaService(){
        this.FCon= new FacturaConexion();
    }

    public Factura Save(Factura f){
        return FCon.save(f);
    }
    public Factura findById(Integer i){
        return FCon.findById(i);
    }
    public void update(Factura f){
        FCon.Update(f);
    }
    public void delete(Integer id){
        FCon.delete(id);
    }
    public List<Factura> findAll(){
        return FCon.findAll();
    }

    public Factura findByVentaId(Integer i){
        return FCon.findByIdVenta(i);
    }

    public List<Recibo> findRecibosByVentaId(Integer id) {
        return FCon.findRecibosByIdVenta(id);
    }

    public Factura GuardarFactura(Factura f) {
        return FCon.GuardarFactura(f);
    }

    public Recibo GuardarRecibo(Recibo r, Integer IdVenta) {
        return FCon.GuardarRecibo(r,IdVenta);
    }

    public void deleteRecibo(int id) {
        FCon.deleteRecibo(id);
    }
}
