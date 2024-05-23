
package com.example.sistemaannedecor2.Service;
import com.example.sistemaannedecor2.Clases.Cortina;
import com.example.sistemaannedecor2.Clases.TipoCortina.Roller;
import com.example.sistemaannedecor2.Conexiones.CortinaConexion;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CortinaService {

    private static final CortinaConexion CortinaConexion= new CortinaConexion();

    public CortinaService() {
    }

    public Cortina Save(Cortina c){
        return CortinaConexion.save(c);
    }

    public Cortina SaveRoller(Roller c){
        return CortinaConexion.saverRoller(c);
    }

    public Cortina findById(Integer i){
        return CortinaConexion.findById(i);
    }

    public void update(Cortina c){
        CortinaConexion.Update(c);
    }

    public void delete(Integer id){
        CortinaConexion.delete(id);
    }

    public List<Cortina> findAll(){
        return CortinaConexion.findAll();
    }

    public List<Cortina> findCortinasByVenta(int id) {
        return CortinaConexion.findCortinasByVenta(id);
    }
}
