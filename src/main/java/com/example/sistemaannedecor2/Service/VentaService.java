
package com.example.sistemaannedecor2.Service;
import com.example.sistemaannedecor2.Clases.Cliente;
import com.example.sistemaannedecor2.Clases.Venta;
import com.example.sistemaannedecor2.Conexiones.ClienteConexion;
import com.example.sistemaannedecor2.Conexiones.VentasConexion;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VentaService {

    private static final VentasConexion VentasConexion= new VentasConexion();
    public VentaService() {
    }
    public Venta Save(Venta v){
        return VentasConexion.save(v);
    }
    public Venta findById(Integer i){
        return VentasConexion.findById(i);
    }
    public void update(Venta v){
        VentasConexion.Update(v);
    }
    public void delete(Integer id){
        VentasConexion.delete(id);
    }
    public List<Venta> findAll(){
        return VentasConexion.findAll();
    }
    
}
