package com.example.sistemaannedecor2.Service;

import com.example.sistemaannedecor2.Clases.EstadoCortina;
import com.example.sistemaannedecor2.Conexiones.ConexionEstadoCortina;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstadoCortinaService {

    private final ConexionEstadoCortina EcConexion;

    public EstadoCortinaService() {
        this.EcConexion = new ConexionEstadoCortina();
    }

    public EstadoCortina Save(EstadoCortina ev){
        return EcConexion.save(ev);
    }
    public EstadoCortina findById(Integer i){
        return EcConexion.findById(i);
    }
    public void update(EstadoCortina ev){
        EcConexion.Update(ev);
    }
    public void delete(Integer id){
        EcConexion.delete(id);
    }
    public List<EstadoCortina> findAll(){
        return EcConexion.findAll();
    }
}
