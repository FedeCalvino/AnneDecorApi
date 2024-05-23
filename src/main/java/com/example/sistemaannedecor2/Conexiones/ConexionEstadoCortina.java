package com.example.sistemaannedecor2.Conexiones;



import com.example.sistemaannedecor2.Clases.EstadoCortina;
import com.example.sistemaannedecor2.Clases.EstadoVenta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ConexionEstadoCortina implements IConexion<EstadoCortina>{

    private static String SQL_BY_ID = "select * from ESTADO_CORTINA where id = ?";
    private static final String SQL_INSERT = "INSERT INTO ESTADO_CORTINA(TELA_CORTADA,CANO_CORTADO,ARMADO,PROBADO) VALUES(?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM ESTADO_CORTINA WHERE ID = ?";
    private static final String SQL_UPDATE = "UPDATE ESTADO_CORTINA SET TELA_CORTADA = ?, CANO_CORTADO = ? , ARAMADO = ? , PROBADO = ? WHERE ID = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ESTADO_CORTINA";

    private byte trueBite = 1;
    private byte falseBite = 0;

    @Override
    public EstadoCortina save(EstadoCortina ev) {
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setByte(1, ev.isTelaCortadaByte());
            ps.setByte(2,ev.isCañoCortadoByte());
            ps.setByte(3, ev.isArmadoByte());
            ps.setByte(4, ev.isProbadoByte());
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
                e.printStackTrace();
            }
        }
        return ev;
    }

    @Override
    public EstadoCortina findById(Integer id) {
        java.sql.Connection connection = null;
        EstadoCortina Ev = null;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            //int id, boolean cañoCortado, boolean telaCortada, boolean armado, boolean probado
            while(rs.next()){
                Ev = new EstadoCortina(rs.getInt(1));

                if(rs.getByte(2)==1)  Ev.setTelaCortada(true);
                else Ev.setTelaCortada(false);


                if(rs.getByte(3)==1) Ev.setCanoCortado(true);
                else Ev.setCanoCortado(false);


                if(rs.getByte(4)==1) Ev.setArmado(true);
                else Ev.setArmado(false);

                if(rs.getByte(5)==1) Ev.setProbado(true);
                else Ev.setProbado(false);

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
    public void Update(EstadoCortina ec) {
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setByte(1,ec.isTelaCortadaByte());

            ps.setByte(2,ec.isCañoCortadoByte());

            ps.setInt(3,ec.isArmadoByte());

            ps.setInt(4,ec.isArmadoByte());

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
    public List<EstadoCortina> findAll() {
        return List.of();
    }

}
