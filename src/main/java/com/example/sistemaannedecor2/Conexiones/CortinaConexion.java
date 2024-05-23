/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sistemaannedecor2.Conexiones;


import com.example.sistemaannedecor2.Clases.Cortina;
import com.example.sistemaannedecor2.Clases.EstadoCortina;
import com.example.sistemaannedecor2.Clases.TipoCortina.Roller;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;  


public class CortinaConexion implements IConexion<Cortina> {

private static TipoTelaConexion tipoTelaC = new TipoTelaConexion();

private static ConexionEstadoCortina estadoCc = new ConexionEstadoCortina();

private static final String SQL_INSERT_CORTINA = "INSERT INTO CORTINAS(ALTO,ANCHO,TIPO_TELA_ID,ESTADO_CORTINA_ID,MOTORIZADA,AMBIENTE) VALUES(?,?,?,?,?,?)";
private static final String SQL_INSERT_ROLLER = "INSERT INTO ROLLER(ID_CORTINA,CADENA_METALICA,CANO,LARGO_CADENA,LADO_CADENA,POSICION) VALUES(?,?,?,?,?,?)";

private static final String SQL_DELETE = "DELETE FROM CORTINAS WHERE ID_CORTINA = ?";
private static final String SQL_UPDATE = "UPDATE CORTINAS SET ALTO = ?, ANCHO = ? , TIPO_TELA_ID = ? , MOTORIZADA = ? WHERE ID_CORTINA = ?";
private static List<Cortina> cortinas = new ArrayList<Cortina>();
private static final String SQL_SELECT_ALL = "SELECT * FROM CORTINAS";
private static final String SQL_SELECT_BY_ID = "SELECT * FROM CORTINAS WHERE ID_CORTINA = ?";

private byte trueBite = 1;
private byte falseBite = 0;



    @Override()
    public Cortina save(Cortina C) {
        java.sql.Connection conexion=null;
        try{
            C.setTela(tipoTelaC.findById(C.IdTipoTela));
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_INSERT_CORTINA, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, C.getAlto());
            ps.setNString(2, C.getAncho());
            ps.setInt(3, C.GetTipoTelaId());
            ps.setString(6,C.getAmbiente());
            EstadoCortina ec = new EstadoCortina();
            C.setEstado(ec);
            int IdEstado = estadoCc.save(ec).getId();
            ps.setInt(4,IdEstado);
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
            e.printStackTrace();
        }finally{
            try{
                conexion.close();
            }catch(Exception e){
                
            }
        }
        System.out.println(C.getId());
        return C;
    }



    public Cortina saverRoller(Roller R) {
        System.out.println(R.IdTipoTela);
        System.out.println(R.getAmbiente());
        Cortina C = new Cortina(R.getAlto(),R.getAncho(),R.getMotorizada(),R.IdTipoTela,R.getAmbiente());
        System.out.println(C.getAmbiente());
        int idC = this.save(C).getId();
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_INSERT_ROLLER, Statement.RETURN_GENERATED_KEYS);

            System.out.println("cadena"+R.getLadoCadena());
            System.out.println("posicion"+R.getPosicion());
            ps = conexion.prepareStatement(SQL_INSERT_ROLLER, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idC);
            ps.setInt(3, R.getTubo());
            ps.setNString(4, R.getLargoCadena());
            ps.setByte(2,R.isCadenaMetalicaByte());
            ps.setString(6,R.getPosicion());
            ps.setString( 5,R.getLadoCadena());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                R.setId(rs.getInt(1));
            }

        }catch(Exception e){
            e.printStackTrace();
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
                if(rs.getByte(6)==1){
                    c = new Cortina (rs.getString(2),rs.getString(3),true, rs.getInt(4),rs.getString(7));
                    c.setTela(tipoTelaC.findById(rs.getInt(4)));
                    c.setId(rs.getInt(1));
                    c.setEstado(estadoCc.findById(rs.getInt(5)));
                    cortinas.add(c);
                }else{
                    c = new Cortina (rs.getString(2),rs.getString(3),false, rs.getInt(4),rs.getString(7));
                    c.setTela(tipoTelaC.findById(rs.getInt(4)));
                    c.setId(rs.getInt(1));
                    c.setEstado(estadoCc.findById(rs.getInt(5)));
                    cortinas.add(c);
                }
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
    public void Update(Cortina C) {
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, C.getAlto());
            ps.setString(2,C.getAncho());
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
                if(rs.getByte(6)==1){
                    Cortina c = new Cortina (rs.getNString(2),rs.getNString(3),true, rs.getInt(5),rs.getString(7));
                    c.setTela(tipoTelaC.findById(rs.getInt(4)));
                    c.setId(rs.getInt(1));
                    c.setEstado(estadoCc.findById(rs.getInt(5)));
                    cortinas.add(c);
                }else{
                    Cortina c = new Cortina (rs.getNString(2),rs.getNString(3),false, rs.getInt(5),rs.getString(7));
                    c.setTela(tipoTelaC.findById(rs.getInt(4)));
                    c.setId(rs.getInt(1));
                    c.setEstado(estadoCc.findById(rs.getInt(5)));
                    cortinas.add(c);
                }
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

    public List<Cortina> findCortinasByVenta(int id) {
        return null;
    }
}
