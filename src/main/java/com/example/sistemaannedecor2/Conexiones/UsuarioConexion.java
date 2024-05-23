package com.example.sistemaannedecor2.Conexiones;

import com.example.sistemaannedecor2.Clases.TipoTela;
import com.example.sistemaannedecor2.Dto.DtoUsuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;

public class UsuarioConexion {
    private static final String SQL_GET_USUARIO ="select * from usuario u WHERE u.MAIL=? and u.CONTRASENA=?";

    public DtoUsuario findUsuario(DtoUsuario us) {
        java.sql.Connection connection = null;
        DtoUsuario u =us;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_GET_USUARIO);
            statement.setString(1,us.getMail().toLowerCase(Locale.ROOT));
            statement.setString(2,us.getPassword());
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                u = new DtoUsuario(rs.getString(2),rs.getString(3));
                u.setId(rs.getInt(1));
            }
        }catch(Exception e){
        e.printStackTrace();
        }finally{
            try{
                connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return u;
    }
}
