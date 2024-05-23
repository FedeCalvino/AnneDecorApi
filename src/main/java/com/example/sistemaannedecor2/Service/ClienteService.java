
package com.example.sistemaannedecor2.Service;
import com.example.sistemaannedecor2.Clases.Cliente;
import com.example.sistemaannedecor2.Conexiones.ClienteConexion;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteService{

    private static final ClienteConexion ClienteConexion= new ClienteConexion();

    public ClienteService() {
    }

    public static Cliente findByName(String name) {
        return ClienteConexion.findByName(name);
    }

    public static List<Cliente> findLikeName(String name) {
        return ClienteConexion.findLikeName(name);
    }

    public Cliente Save(Cliente c){
        return ClienteConexion.saveCliente(c);
    }


    public Cliente findById(Integer i){
        return ClienteConexion.findById(i);
    }
    public void update(Cliente c){
        ClienteConexion.Update(c);
    }
    public void delete(Integer id){
        ClienteConexion.delete(id);
    }
    public List<Cliente> findAll(){
        return ClienteConexion.findAll();
    }
    
}
