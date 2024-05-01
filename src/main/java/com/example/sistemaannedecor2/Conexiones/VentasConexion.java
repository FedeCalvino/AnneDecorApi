/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sistemaannedecor2.Conexiones;


import com.example.sistemaannedecor2.Clases.Cliente;
import com.example.sistemaannedecor2.Clases.Cortina;
import com.example.sistemaannedecor2.Clases.EstadoVenta;
import com.example.sistemaannedecor2.Clases.Venta;
import com.example.sistemaannedecor2.Service.ClienteService;
import com.example.sistemaannedecor2.Service.CortinaService;
import com.example.sistemaannedecor2.Service.EstadoVentaService;
import com.sun.jdi.connect.spi.Connection;

import java.sql.Date;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author calvi
 */
public class VentasConexion implements IConexion<Venta> {

    private static final String SQL_SELECT_ALL = "SELECT * FROM VENTA";
    private static final String SQL_BY_ID = "SELECT * FROM VENTA WHERE ID = ?";
    private static final String SQL_INSERT = "INSERT INTO VENTA(CLIENTE_ID,ESTADO_VENTA_ID,FECHA,PRECIO) VALUES(?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM VENTA WHERE ID = ?";
    private static final String SQL_UPDATE = "UPDATE VENTA SET FECHA = ?, PRECIO = ? , CLIENTE_ID = ? WHERE ID = ?";
    private static final String SQL_ADD_CORTINA_VENTA = "INSERT INTO VENTA_CORTINA(VENTA_ID,CORTINA_ID) VALUES(?,?)";

    public static Connection conexion;
    private List<Venta> ventas=new ArrayList<>();
    private ClienteService clienteService = new ClienteService();
    private EstadoVentaService ServicioEstadoVenta=new EstadoVentaService();
    private CortinaService CortinaService =new CortinaService();

    @Override
    public Venta saveCortina(Venta v){
       java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            Cliente c = clienteService.findById(v.getClienteIdNoPorCliente());
            if(c!=null) {
                ps.setInt(1, c.getId());
                EstadoVenta estado = new EstadoVenta();
                int estadoId = ServicioEstadoVenta.Save(estado).id;
                ps.setInt(2, estadoId);
                Date fecha = Date.valueOf(LocalDate.now());
                ps.setDate(3, fecha);
                ps.setInt(4, v.getPrecio());
                ps.execute();
                v.setCliente(clienteService.findById(v.getClienteIdNoPorCliente()));
                v.setEstadoVenta(estado);
                v.setFecha(fecha);

                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    v.setId(rs.getInt(1));
                }
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                conexion.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return v;
    }

    @Override
    public Venta findById(Integer id) {
        java.sql.Connection connection = null;
        Venta v = null;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                v = new Venta(rs.getInt(2),rs.getInt(5));
                v.setId(rs.getInt(1));
                v.setFecha(rs.getDate(4));
                v.setEstadoVenta(ServicioEstadoVenta.findById(rs.getInt(3)));
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
        return v;
    }

    @Override
    public void Update(Venta v) {
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setDate(1, v.getFecha());
            ps.setInt(2,v.getPrecio());
            ps.setInt(3,v.getClienteIdNoPorCliente());
            ps.setInt(4, v.getId());
            ps.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                conexion.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Integer id) {
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            ps.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                conexion.close();
            }catch(Exception e){
            }
        }
    }
    @Override
    public List<Venta> findAll() {
         java.sql.Connection connection = null;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Venta v = new Venta(rs.getInt(2),rs.getInt(5));
                v.setId(rs.getInt(1));
                v.setFecha(rs.getDate(4));
                v.setEstadoVenta(ServicioEstadoVenta.findByIdVenta(rs.getInt(3)));
                ventas.add(v);
            }
        }catch(Exception e){
            
        }finally{
            try{
                connection.close();
            }catch(Exception e){
                
            }
        }
        return ventas;
    }

    public Cortina SaveCortinaVenta(int Idcortina , int idVenta) {
        Cortina c=null;
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_ADD_CORTINA_VENTA);
            Venta v = this.findById(idVenta);
            c = CortinaService.findById(Idcortina);
            if(v!=null) {
                ps.setInt(1, idVenta);
                ps.setInt(2, c.getId());
                ps.execute();
                v.AddCortina(c);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                conexion.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return c;
    }

    public List<Cortina> SaveCortinasVenta(int idVenta , List<Cortina> cortinas) {
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_ADD_CORTINA_VENTA);
            Iterator<Cortina> it = cortinas.iterator();
            Venta v = this.findById(idVenta);
            while (it.hasNext()) {
                Cortina c = it.next();
                if (c != null && v!=null){
                    ps.setInt(1, idVenta);
                    ps.setInt(2, c.getId());
                    v.AddCortina(c);
                }
            }
        }catch(Exception e){

        }finally{
            try{
                conexion.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return cortinas;
    }
}
