package com.example.sistemaannedecor2.Service;

import com.example.sistemaannedecor2.Clases.Cortina;
import com.example.sistemaannedecor2.Clases.TipoTela;
import com.example.sistemaannedecor2.Clases.Venta;
import com.example.sistemaannedecor2.Conexiones.UsuarioConexion;
import com.example.sistemaannedecor2.Conexiones.VentasConexion;
import com.example.sistemaannedecor2.Dto.DtoUsuario;
import com.example.sistemaannedecor2.Dto.DtoVenta;
import com.example.sistemaannedecor2.Dto.DtoVentacortina;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService {

    private static final UsuarioConexion UConexion = new UsuarioConexion();

    public UsuarioService() {

    }


    public DtoUsuario findUsuario(DtoUsuario us) {
        return UConexion.findUsuario(us);
    }
}
