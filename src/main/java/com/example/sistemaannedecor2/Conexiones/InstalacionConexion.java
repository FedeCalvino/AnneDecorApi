package com.example.sistemaannedecor2.Conexiones;

import com.example.sistemaannedecor2.Clases.Cortina;
import com.example.sistemaannedecor2.Clases.Instalacion;
import com.example.sistemaannedecor2.Clases.TipoTela;
import com.example.sistemaannedecor2.Dto.DtoInstalacion;
import com.example.sistemaannedecor2.Dto.DtoVentacortina;
import com.example.sistemaannedecor2.Dto.ObjEstadoColor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InstalacionConexion implements IConexion<DtoInstalacion> {

    private static final String SQL_DELETE = "DELETE FROM INSTALACION WHERE ID_INSTALACION = ?";
    private static final String SQL_INSERT_INSTALACION = "INSERT INTO INSTALACION(ID_VENTA,COMIENZO,FINAL,ACLARACIONES,TITULO) VALUES (?,?,?,?,?)";
    private static final String SQL_GET_INSTALACION = "select I. ID_INSTALACION,v. ID_VENTA,I. COMIENZO,I. FINAL,I. ACLARACIONES,I. TITULO,c. DIRECCION,c. TELEFONO,v. OBRA,cor. ALTO,cor. ANCHO,cor.[AMBIENTE] ,cor. MOTORIZADA,cor.TIPO_TELA_ID, tp.NOMBRE,tp.COLOR,r.CANO,r.LARGO_CADENA,cor. ID_CORTINA,r. POSICION,r. LADO_CADENA from venta v join CLIENTES c on c. ID=v. CLIENTE_ID join VENTA_CORTINA vc on vc. VENTA_ID=v. ID_VENTA join CORTINAS cor on cor.[ID_CORTINA]=vc. CORTINA_ID join ROLLER r on r.ID_CORTINA=cor.[ID_CORTINA] join TIPO_TELA tp on tp. ID=cor. TIPO_TELA_ID join INSTALACION I on I.[ID_VENTA]=V. ID_VENTA order by I.ID_INSTALACION";
    @Override
    public DtoInstalacion save(DtoInstalacion dtoInstalacion) {
        java.sql.Connection conexion=null;
        try{
            conexion = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_INSERT_INSTALACION, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,dtoInstalacion.getIdVenta());
            ps.setString(2,dtoInstalacion.getStart());
            ps.setString(3,dtoInstalacion.getEnd());
            ps.setString(4,dtoInstalacion.getAclaraciones());
            ps.setString(5,dtoInstalacion.getTitulo());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                dtoInstalacion.setIDInstalacion(rs.getInt(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                conexion.close();
            }catch(Exception e){
            }
        }
        return dtoInstalacion;
    }

    @Override
    public DtoInstalacion findById(Integer id) {
        return null;
    }

    @Override
    public void Update(DtoInstalacion dtoInstalacion) {

    }

    @Override
    public void delete(Integer id) {
        System.out.println(id);
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
    public List<DtoInstalacion> findAll() {
        List<DtoInstalacion> DtoIList = new ArrayList<>();
        java.sql.Connection connection = null;
        try {
            connection = (java.sql.Connection) Conexion.GetConexion();
            PreparedStatement statement = connection.prepareStatement(SQL_GET_INSTALACION);
            ResultSet rs = statement.executeQuery();
            DtoInstalacion DI = null;
            int IdInstalacionAnterior = -1;
            boolean Add=false;
            while (rs.next()) {
                boolean AddCortinas = false;
                int IdInstalacion = rs.getInt(1);
                boolean NextInstalacion = IdInstalacion != IdInstalacionAnterior;
                if (NextInstalacion) {
                    if (DI != null) {
                        DtoIList.add(DI);
                    }
                    DI = new DtoInstalacion(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                    IdInstalacionAnterior = IdInstalacion;
                    DI.setIDInstalacion(IdInstalacion);
                    DI.setDireccion(rs.getString(7));
                    DI.setTelefono(rs.getString(8));
                    DI.setObra(rs.getString(9));
                }

                DtoVentacortina dtoC = new DtoVentacortina();

                dtoC.setAmbiente(rs.getString(12));
                dtoC.setAltoCortina(rs.getString(10));
                dtoC.setAnchoCortina(rs.getString(11));
                dtoC.setMotorizada(rs.getByte(13));
                dtoC.setNombreTela(rs.getString(15));
                dtoC.setColorTela(rs.getString(16));
                dtoC.setCano(rs.getString(17));
                dtoC.setIdCortina(rs.getInt(19));
                dtoC.setPosicion(rs.getString(20));
                dtoC.setLadoCadena(rs.getString(21));

                DI.AddCortina(dtoC);

            }
            // Agregar la última instalación a la lista
            if (DI != null) {
                DtoIList.add(DI);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(DtoIList.size());
        return DtoIList;
    }
}
