/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sistemaannedecor2.Conexiones;


import com.example.sistemaannedecor2.Clases.Cliente;
import com.example.sistemaannedecor2.Clases.Cortina;
import com.example.sistemaannedecor2.Clases.EstadoVenta;
import com.example.sistemaannedecor2.Clases.Venta;
import com.example.sistemaannedecor2.Dto.DtoVenta;
import com.example.sistemaannedecor2.Dto.DtoVentacortina;
import com.example.sistemaannedecor2.Dto.ObjEstadoColor;
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

    private static final String SQL_SELECT_ALL_Dto = "select C.NOMBRE,C.ID,v.ID_VENTA,v.FECHA,v.PRECIO,ev.ARMADO,ev.FACTURADO,ev.INSTALADO,ev.PAGADO from VENTA v join CLIENTES c on c.ID=v.CLIENTE_ID join ESTADO_VENTA ev on ev.ID=V.ESTADO_VENTA_ID";
    private static final String SQL_BY_ID = "SELECT * FROM VENTA WHERE ID_VENTA = ?";
    private static final String SQL_SELECT_ALL="SELECT * FROM VENTA";
    private static final String SQL_INSERT = "INSERT INTO VENTA(CLIENTE_ID,ESTADO_VENTA_ID,FECHA,PRECIO) VALUES(?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM VENTA WHERE ID_VENTA = ?";
    private static final String SQL_UPDATE = "UPDATE VENTA SET FECHA = ?, PRECIO = ? , CLIENTE_ID = ? WHERE ID_VENTA = ?";
    private static final String SQL_ADD_CORTINA_VENTA = "INSERT INTO VENTA_CORTINA(VENTA_ID,CORTINA_ID) VALUES(?,?)";
    private static final String SQL_Select_All_VentaDto="select cor.AMBIENTE,cor.ALTO,cor.ANCHO,cor.MOTORIZADA,tt.NOMBRE,tt.COLOR,ec.ARMADO,ec.CANO_CORTADO,ec.PROBADO,ec.TELA_CORTADA,r.CANO,r.LARGO_CADENA,cor.ID_CORTINA " +
                                                        "from VENTA v join CLIENTES c on c.ID=v.CLIENTE_ID " +
                                                        "join VENTA_CORTINA vc on vc.VENTA_ID=v.ID_VENTA " +
                                                        "join CORTINAS cor on cor.ID_CORTINA=vc.CORTINA_ID  " +
                                                        "join ESTADO_CORTINA ec on ec.ID=V.ESTADO_VENTA_ID " +
                                                        "join TIPO_TELA tt on tt.ID=cor.TIPO_TELA_ID " +
                                                        "join ROLLER r on r.ID_CORTINA=cor.ID_CORTINA where v.ID_VENTA=?";

    public static Connection conexion;
    private ClienteService clienteService = new ClienteService();
    private EstadoVentaService ServicioEstadoVenta=new EstadoVentaService();
    private CortinaService CortinaService =new CortinaService();

    public Venta saveVenta(Venta v){
       java.sql.Connection conexion=null;
        try{
            System.out.println(v.PrecioFinal);
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            System.out.println(v.getClienteIdNoPorCliente());
            Cliente c = clienteService.findById(v.getClienteIdNoPorCliente());
            System.out.println(c);
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
    public Venta saveCortina(Venta venta) {
        return null;
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
         List<Venta> ventas=new ArrayList<>();
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
                ps.setInt(1, idVenta);
                ps.setInt(2, Idcortina);
                ps.execute();
                v.AddCortina(c);
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

    public List<DtoVenta> findAllDto() {
        List<DtoVenta> Dtoventas=new ArrayList<>();
        java.sql.Connection connection = null;
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_Dto);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                DtoVenta dtoV = new DtoVenta();
                dtoV.setNombreCliente(rs.getString(1));
                dtoV.setIdCliente(rs.getInt(2));
                dtoV.setIdVenata(rs.getInt(3));
                dtoV.setFechaVenta(rs.getDate(4));
                dtoV.setMonto(rs.getInt(5));
                ObjEstadoColor Ec = GetEstadoColorVenta(rs.getByte(6),rs.getByte(7),rs.getByte(8),rs.getByte(9));
                dtoV.setEstadoActual(Ec.getEstadoAct());
                dtoV.setColorEstado(Ec.getColor());
                Dtoventas.add(dtoV);
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
        return Dtoventas;
    }
    public ObjEstadoColor GetEstadoColorVenta(Byte armado, Byte facturado, Byte instalado, Byte pagado){
        if(armado==0){
            return new ObjEstadoColor("Sin Armar","#FF0000");
        }
        if(instalado==0){
            return new ObjEstadoColor("Listo para instalar","#FFFF00");
        }
        if(pagado==0){
            return new ObjEstadoColor("Sin Pagar","#0000FF");
        }
        if(facturado==0){
            return new ObjEstadoColor("Sin Facturar","#0c340c");

        }
        return new ObjEstadoColor("Completa","#008000");
    }

    public List<DtoVentacortina> findAllDtoVC(int idVenta) {
        List<DtoVentacortina> CorinasventasDto = new ArrayList<>();
        java.sql.Connection connection = null;
        System.out.println(idVenta);
        try{
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_Select_All_VentaDto);
            statement.setInt(1, idVenta);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                System.out.println("1 cortina");
                DtoVentacortina dtoC = new DtoVentacortina();
                dtoC.setAmbiente(rs.getString(1));
                dtoC.setAltoCortina(rs.getString(2));
                dtoC.setAnchoCortina(rs.getString(3));
                dtoC.setMotorizada(rs.getByte(4));
                dtoC.setNombreTela(rs.getString(5));
                dtoC.setColorTela(rs.getString(6));
                dtoC.setCano(rs.getString(11));
                dtoC.setCadena(rs.getString(12));
                dtoC.setIdCortina(rs.getInt(13));
                ObjEstadoColor objEc = GetEstadoColorCortina(rs.getByte(7),rs.getByte(8),rs.getByte(9),rs.getByte(10));
                dtoC.setEstadoCortina(objEc.getEstadoAct());
                CorinasventasDto.add(dtoC);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                connection.close();
            }catch(Exception e){

            }
        }
        return CorinasventasDto;
    }

    public ObjEstadoColor GetEstadoColorCortina(Byte armado, Byte CanoCortado, Byte probado, Byte telaCortada){
        if(CanoCortado==0 && telaCortada==0){
            return new ObjEstadoColor("Sin Cortar tela y caño","#FF0000");
        }
        if(telaCortada==0){
            return new ObjEstadoColor("Sin Cortar tela","#FFFACD");
        }
        if(CanoCortado==0){
            return new ObjEstadoColor("Sin Cortar caño","yellow");
        }
        if(armado==0){
            return new ObjEstadoColor("Sin Armar","#008000");
        }
        if(probado==0){
            return new ObjEstadoColor("Sin probar","green");
        }
        return new ObjEstadoColor("Completa","green");
    }
}

