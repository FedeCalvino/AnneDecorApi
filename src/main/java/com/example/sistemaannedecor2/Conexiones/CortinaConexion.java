/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sistemaannedecor2.Conexiones;


import com.example.sistemaannedecor2.Clases.Cortina;
import com.example.sistemaannedecor2.Clases.TipoTela;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;  


public class CortinaConexion implements IConexion<Cortina> {

private static TipoTelaConexion tipoTelaC = new TipoTelaConexion();
private static final String SQL_INSERT = "INSERT INTO CORTINAS(ALTO,ANCHO,TIPO_TELA,ESTADO_CORTINA,MOTORIZADA) VALUES(?,?,?,?,?)";
private static final String SQL_DELETE = "DELETE FROM CORTINAS WHERE ID = ?";
private static final String SQL_UPDATE = "UPDATE CORTINAS SET ALTO = ?, ANCHO = ? , TIPO_TELA_ID = ? , MOTORIZADA = ? WHERE ID = ?";
private static List<Cortina> cortinas = new ArrayList<Cortina>();
private static final String SQL_SELECT_ALL = "SELECT * FROM CORTINAS";
private static final String SQL_SELECT_BY_ID = "SELECT * FROM CORTINAS WHERE CORTINA_ID = ?";

private byte trueBite = 1;
private byte falseBite = 0;



    @Override
    public Cortina save(Cortina C) {
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, C.getAlto());
            ps.setDouble(2,C.getAncho());
            ps.setInt(3, C.GetTipoTelaId());
            ps.setInt(4, C.GetEstadoCortinaId());
            if(C.getMotorizada()){
                ps.setByte(5,trueBite);
            }else{
                 ps.setByte(5, falseBite);
            }
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                C.setId(rs.getInt(1));
            }
    
        }catch(Exception e){
            
        }finally{
            try{
                conexion.close();
            }catch(Exception e){
                
            }
        }
        return C;
    }

    @Override
    public Cortina findById(Integer id) {
        java.sql.Connection connection = null;
        Cortina c=null;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                 c = new Cortina (rs.getInt(1),rs.getDouble(2),rs.getDouble(3),true, (TipoTela) tipoTelaC.findById(rs.getInt(4)),rs.getInt(5));
            }

        }catch(Exception e){

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
    public void Update(Cortina C) {
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setDouble(1, C.getAlto());
            ps.setDouble(2,C.getAncho());
            ps.setInt(3,C.GetTipoTelaId());
            if(C.getMotorizada()){
                ps.setByte(4,trueBite);
            }else{
                ps.setByte(4, falseBite);
            }
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
    public List<Cortina> findAll() {
        java.sql.Connection connection = null;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){

                Cortina c = new Cortina (rs.getInt(1),rs.getDouble(2),rs.getDouble(3),true, (TipoTela) tipoTelaC.findById(rs.getInt(4)),rs.getInt(5));
                cortinas.add(c);
            }
            return cortinas;

        }catch(Exception e){

        }finally{
            try{
                connection.close();
            }catch(Exception e){

            }
        }
        return cortinas;
    }

}
