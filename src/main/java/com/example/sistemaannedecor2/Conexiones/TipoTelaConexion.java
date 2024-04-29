/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sistemaannedecor2.Conexiones;

import com.example.sistemaannedecor2.Clases.TipoTela;

import java.sql.Statement;
import java.util.List;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author calvi
 */
public class TipoTelaConexion implements IConexion<TipoTela> {

    
private static final String SQL_SELECT_ALL = "SELECT * FROM TIPO_TELA";
private static final String SQL_BY_ID = "SELECT * FROM TIPO_TELA WHERE ID = ?";
private static final String SQL_INSERT = "INSERT INTO TIPO_TELA(NOMBRE,COLOR,DESCRIPCION) VALUES(?,?,?)";
private static final String SQL_DELETE = "DELETE FROM TIPO_TELA WHERE ID = ?";
private static final String SQL_UPDATE = "UPDATE TIPO_TELA SET NOMBRE = ?, COLOR = ? , DESCRIPCION = ? WHERE ID = ?";


    @Override
    public TipoTela save(TipoTela tp) {
        java.sql.Connection conexion=null;

        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tp.getNombre());
            ps.setString(2,tp.getColor());
            ps.setString(3,tp.getDescripcion());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                tp.setId(rs.getInt(1));
            }
        }catch(Exception e){

        }finally{
            try{
                conexion.close();
            }catch(Exception e){
            }
        }
        return tp;
    }

    @Override
    public TipoTela findById(Integer id) {
        java.sql.Connection connection = null;
        TipoTela tt=null;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                tt = new TipoTela (rs.getString(2),rs.getString(3),rs.getString(4));
                tt.setId(rs.getInt(1));
            }

        }catch(Exception e){

        }finally{
            try{
                connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return tt;
    }

    @Override
    public void Update(TipoTela tp) {
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, tp.getNombre());
            ps.setString(2,tp.getColor());
            ps.setString(3,tp.getDescripcion());
            ps.setInt(4, tp.getId());
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
            }
        }
    }

    @Override
    public List<TipoTela> findAll() {
        List<TipoTela> TiposTela = new ArrayList<>();
        java.sql.Connection connection = null;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                TipoTela  tt = new TipoTela (rs.getString(2),rs.getString(3),rs.getString(4));
                tt.setId(rs.getInt(1));
                TiposTela.add(tt);
            }
    
        }catch(Exception e){
            
        }finally{
            try{
                connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return TiposTela;
    }
    
    
}
