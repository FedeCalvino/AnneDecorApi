package com.example.sistemaannedecor2.Service;

import com.example.sistemaannedecor2.Clases.EstadoVenta;
import com.example.sistemaannedecor2.Conexiones.ConexionEstadoVenta;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstadoVentaService {

    private final com.example.sistemaannedecor2.Conexiones.ConexionEstadoVenta EVConexion;

    public EstadoVentaService() {
        this.EVConexion = new ConexionEstadoVenta();
    }

    public EstadoVenta Save(EstadoVenta ev){
        return EVConexion.save(ev);
    }
    public EstadoVenta findById(Integer i){
        return EVConexion.findById(i);
    }
    public EstadoVenta findByIdVenta(Integer i){
        return EVConexion.findByIdVenta(i);
    }
    public void update(EstadoVenta ev){
        EVConexion.Update(ev);
    }
    public void delete(Integer id){
        EVConexion.delete(id);
    }
    public List<EstadoVenta> findAll(){
        return EVConexion.findAll();
    }
}
