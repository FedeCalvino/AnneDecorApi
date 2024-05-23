
package com.example.sistemaannedecor2.Service;
import com.example.sistemaannedecor2.Clases.TipoTela;
import com.example.sistemaannedecor2.Conexiones.TipoTelaConexion;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TipoTelaService {

    private static final TipoTelaConexion tpCon= new TipoTelaConexion();

    public TipoTelaService() {
    }

    public TipoTela Save(TipoTela c){
        return tpCon.save(c);
    }


    public TipoTela findById(Integer i){
        return tpCon.findById(i);
    }
    public void update(TipoTela c){
        tpCon.Update(c);
    }
    public void delete(Integer id){
        tpCon.delete(id);
    }
    public List<TipoTela> findAll(){
        return tpCon.findAll();
    }
    
}
