package com.example.sistemaannedecor2.Conexiones;

import com.example.sistemaannedecor2.Clases.Cortina;
import com.example.sistemaannedecor2.Clases.EstadoCortina;
import com.example.sistemaannedecor2.Clases.Factura;
import com.example.sistemaannedecor2.Clases.Recibo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FacturaConexion implements IConexion<Factura>{
    private static final String SQL_FIND_BY_VENTA = "select v.ID_VENTA,fv.ID_FACTURA,fv.MONTO_TOTAL,fv.MONTO_PAGADO,fv.SALDO_RESTANTE,fv.Nro_FACTURA,fv.FECHA_FINAL,fv.FECHA_FACTURA from VENTA v join FACTURA_VENTA fv on fv.ID_VENTA=v.ID_VENTA where v.ID_VENTA=?";
    private static final String SQL_FIND_RECIBOS_BY_VENTA = "select r.ID_RECIBO,r.MONTO,r.FECHA_PAGO,r.NUMERO_RECIBO from RECIBO r join VENTA v on r.ID_VENTA=v.ID_VENTA where v.ID_VENTA=?";
    private static final String SQL_INSERT_FACTURA = "insert into FACTURA_VENTA(ID_VENTA,FECHA_FINAL,FECHA_FACTURA,Nro_FACTURA,MONTO_TOTAL,MONTO_PAGADO) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE_MONTO_PAGADO = "UPDATE FACTURA_VENTA SET MONTO_PAGADO =(SELECT SUM(r.MONTO) FROM RECIBO r WHERE r.ID_VENTA = FACTURA_VENTA.ID_VENTA);";
    private static final String SQL_UPDATE_SALDO_RESTANTE="UPDATE FACTURA_VENTA SET SALDO_RESTANTE =(MONTO_TOTAL-MONTO_PAGADO)";
    private static final String SQL_INSERT_RECIBO="insert into RECIBO(ID_VENTA,MONTO,FECHA_PAGO,NUMERO_RECIBO) values(?,?,?,?)";
    private static final String SQL_DELETE_RECIBO ="DELETE FROM RECIBO WHERE ID_RECIBO = ?";

    @Override
    public Factura save(Factura factura) {
        return null;
    }

    @Override
    public Factura findById(Integer id) {
        return null;
    }

    @Override
    public void Update(Factura factura) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Factura> findAll() {
        return List.of();
    }

    public Factura findByIdVenta(Integer id) {
        java.sql.Connection connection = null;
        Factura f=null;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_VENTA);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                    f = new Factura(rs.getInt(1),rs.getDate(7),rs.getString(6),rs.getInt(3));
                    f.setIdFactura(rs.getInt(2));
                    f.setMontoPagado(rs.getInt(4));
                    f.setSaldo(rs.getInt(5));
                    f.setFechaFactura(rs.getDate(8));
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
        return f;
    }
    public List<Recibo> findRecibosByIdVenta(int idVenta){
        java.sql.Connection connection = null;
        List<Recibo> recibos=new ArrayList<Recibo>();
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_RECIBOS_BY_VENTA);
            statement.setInt(1,idVenta);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                    Recibo r = new Recibo(rs.getInt(2),rs.getDate(3),rs.getString(4));
                    r.setIdRecibo(rs.getInt(1));
                    recibos.add(r);
            }
        }catch(Exception e){

        }finally{
            try{
                connection.close();
            }catch(Exception e){

            }
        }
        return recibos;
    }

    public Factura GuardarFactura(Factura f) {
        java.sql.Connection conexion=null;
        try{
            java.sql.Date sqlDate = new java.sql.Date(f.getFechaFinaL().getTime());
            //le agrego 1 dia
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTime(sqlDate);
            calendar.add(java.util.Calendar.DAY_OF_MONTH, 1);
            java.sql.Date sqlDateMas1Dia = new java.sql.Date(calendar.getTimeInMillis());

            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_INSERT_FACTURA, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, f.getIdVenta());
            ps.setDate(2, sqlDateMas1Dia);
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setString(4, f.getNumeroFactura());
            ps.setInt(5,f.getMontoTotal());
            ps.setInt(6,0);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                f.setIdFactura(rs.getInt(1));
            }
            ps = conexion.prepareStatement(SQL_UPDATE_SALDO_RESTANTE);
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                conexion.close();
            }catch(Exception e){

            }
        }
        return f;
    }

    public Recibo GuardarRecibo(Recibo r, Integer IdVenta) {
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            java.sql.Date sqlDate = new java.sql.Date(r.getFecha().getTime());

            //le sumo 1 dia nose porque me lo resta
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTime(sqlDate);
            calendar.add(java.util.Calendar.DAY_OF_MONTH, 1);
            java.sql.Date sqlDateMas1Dia = new java.sql.Date(calendar.getTimeInMillis());



            PreparedStatement ps = conexion.prepareStatement(SQL_INSERT_RECIBO, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, IdVenta);
            ps.setInt(2, r.getMonto());
            ps.setDate(3,sqlDateMas1Dia);
            ps.setString(4,r.getNumeroRecibo());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                r.setIdRecibo(rs.getInt(1));
            }
            ps = conexion.prepareStatement(SQL_UPDATE_MONTO_PAGADO);
            ps.execute();
            ps = conexion.prepareStatement(SQL_UPDATE_SALDO_RESTANTE);
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                conexion.close();
            }catch(Exception e){

            }
        }
        return r;
    }

    public void deleteRecibo(Integer id) {
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_DELETE_RECIBO);
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
}
