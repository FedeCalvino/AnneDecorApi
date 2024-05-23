package com.example.sistemaannedecor2.Service;

import com.example.sistemaannedecor2.Clases.Factura;
import com.example.sistemaannedecor2.Clases.Instalacion;
import com.example.sistemaannedecor2.Clases.Recibo;
import com.example.sistemaannedecor2.Conexiones.InstalacionConexion;
import com.example.sistemaannedecor2.Dto.DtoInstalacion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstalacionService {

    private final InstalacionConexion Icon;

    public InstalacionService() {
        this.Icon = new InstalacionConexion();
    }

    public DtoInstalacion Save(DtoInstalacion f){
        return Icon.save(f);
    }
    public DtoInstalacion findById(Integer i){
        return Icon.findById(i);
    }
    public void update(DtoInstalacion f){
        Icon.Update(f);
    }
    public void delete(Integer id){
        Icon.delete(id);
    }
    public List<DtoInstalacion> findAll(){
        return Icon.findAll();
    }
}
