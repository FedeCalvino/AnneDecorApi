package com.example.sistemaannedecor2.Conexiones;



import com.example.sistemaannedecor2.Clases.Cliente;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ClienteConexion implements IConexion<Cliente>{

    static final String SQL_BY_ID = "SELECT * FROM CLIENTES WHERE ID = ?";
    static final String SQL_BY_NAME = "SELECT ID,RUT,NOMBRE,TELEFONO,DIRECCION FROM CLIENTES WHERE NOMBRE = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM CLIENTES";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM cliente WHERE ID = ?";
    private static final String SQL_INSERT = "INSERT INTO CLIENTES (RUT,NOMBRE,TELEFONO,DIRECCION) VALUES (?,?,?,?)";
    private List<Cliente> Clientes = new ArrayList<Cliente>();
    @Override
    public Cliente save(Cliente cliente) {
        java.sql.Connection connection = null;
        Cliente c=null;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
        PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, cliente.getRut());
        ps.setString(2,cliente.getNombre());
        ps.setInt(3, cliente.getNumeroTelefono());
        ps.setString(4, cliente.getDireccion());
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        while(rs.next()){
            cliente.setId(rs.getInt(1));
        }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                connection.close();
            }catch(Exception e){

            }
        }
        return null;
    }

    @Override
    public Cliente findById(Integer id) {
        java.sql.Connection connection = null;
        Cliente c=null;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                c = new Cliente (rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5));
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
        return c;
    }

    @Override
    public void Update(Cliente cliente) {

    }
    public static Cliente findByName(String Name){
        java.sql.Connection connection = null;

        Cliente c=null;

        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_BY_NAME);
            statement.setString(1,Name);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                c = new Cliente (rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5));
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
        return c;
    }

    @Override
    public void delete(Integer id) {

    }
    @Override
    public List<Cliente> findAll() {
        Cliente c =null;
        java.sql.Connection connection = null;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                //int id, int rut, String nombre, int numeroTelefono, String direccion
                c = new Cliente (rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5));
                Clientes.add(c);
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
        return Clientes;
    }
}
