package com.example.sistemaannedecor2.Conexiones;



import com.example.sistemaannedecor2.Clases.Cortina;
import com.example.sistemaannedecor2.Clases.EstadoVenta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConexionEstadoVenta implements IConexion<EstadoVenta>{

    private static String SQL_BY_ID = "select * from ESTADO_VENTA where id = ?";
    private static String SQL_BY_ID_VENTA = "select * from ESTADO_VENTA where ID = ?";
    private static final String SQL_INSERT = "INSERT INTO ESTADO_VENTA(ARMADO,INSTALADO,PAGADO,FACTURADO) VALUES(?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM ESTADO_VENTA WHERE ID = ?";
    private static final String SQL_UPDATE = "UPDATE ESTADO_VENTA SET ARMADO = ?, INSTALADO = ? , PAGADO = ? , FACTURADO = ? WHERE ID = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ESTADO_VENTA";

    private byte trueBite = 1;
    private byte falseBite = 0;

    @Override
    public EstadoVenta save(EstadoVenta ev) {
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setByte(1,ev.isArmadaByte());
            ps.setByte(2, ev.isInstaladaByte());
            ps.setByte(3, ev.isPagadaByte());
            ps.setByte(4, ev.isFacturadoByte());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                ev.setId(rs.getInt(1));
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                conexion.close();
            }catch(Exception e){

            }
        }
        return ev;
    }

    @Override
    public EstadoVenta findById(Integer id) {
        java.sql.Connection connection = null;
        EstadoVenta Ev = null;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Ev = new EstadoVenta ();
                if(rs.getByte(2)==1) {
                    Ev.setArmada(true);
                }else{
                    Ev.setArmada(false);
                }

                if(rs.getByte(3)==1) {
                    Ev.setInstalada(true);
                }else{
                    Ev.setInstalada(false);
                }

                if(rs.getByte(4)==1) {
                    Ev.setPagada(true);
                }else{
                    Ev.setPagada(false);
                }
                if(rs.getByte(5)==1) {
                    Ev.Facturado=true;
                }else{
                    Ev.Facturado=false;
                }
                Ev.setId(rs.getInt(1));
            }
        }catch(Exception e){

        }finally{
            try{
                connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return Ev;
    }

    @Override
    public void Update(EstadoVenta ev) {
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
            if(ev.Armada) {
                ps.setByte(1,trueBite);
            }else{
                ps.setInt(1,falseBite);
            }
            if(ev.Instalada) {
                ps.setByte(2,trueBite);
            }else{
                ps.setInt(2,falseBite);
            }
            if(ev.Pagada) {
                ps.setByte(3,trueBite);
            }else{
                ps.setInt(3,falseBite);
            }
            if(ev.Facturado) {
                ps.setByte(4,trueBite);
            }else{
                ps.setInt(4,falseBite);
            }
            ps.setInt(5,ev.getId());
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
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<EstadoVenta> findAll() {
        List<EstadoVenta> ret = new ArrayList<>();
        java.sql.Connection connection = null;
        EstadoVenta Ev = null;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Ev = new EstadoVenta();
                if(rs.getByte(2)==1) Ev.setArmada(true);
                if(rs.getByte(3)==1) Ev.setInstalada(true);
                if(rs.getByte(4)==1) Ev.setPagada(true);
                if(rs.getByte(5)==1) Ev.setFacturado(true);;

                Ev.setId(rs.getInt(1));
                ret.add(Ev);
            }
        }catch(Exception e){

        }finally{
            try{
                connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return ret;
    }

    public EstadoVenta findByIdVenta(Integer i) {
        java.sql.Connection connection = null;
        EstadoVenta Ev = null;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_BY_ID_VENTA);
            statement.setInt(1,i);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Ev = new EstadoVenta();
                if(rs.getByte(2)==1) Ev.setArmada(true);
                if(rs.getByte(3)==1) Ev.setInstalada(true);
                if(rs.getByte(4)==1) Ev.setPagada(true);
                if(rs.getByte(5)==1) Ev.setFacturado(true);;

                Ev.setId(rs.getInt(1));
            }
        }catch(Exception e){

        }finally{
            try{
                connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return Ev;
    }
}
