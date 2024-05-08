
package com.example.sistemaannedecor2.Conexiones;


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL= "jdbc:sqlserver:localhost;databaseName=SistemaCortinas";
    private static final String connectionUrl = "jdbc:sqlserver://localhost.\\SQLEXPRESS;user=SQLAnneDecor;password=SQLAnneDecor;databaseName=SistemaCortinas;encrypt=true;trustServerCertificate=true;";
    private static final String USER="SQLAnneDecor";
    private static final String PASSWORD="SQLAnneDecor";


    private static final String SQL_DROP_CREATE_CORTINA = 
            "DROP TABLE IF EXISTS CORTINAS; "
            + "CREATE TABLE CORTINAS("
            + "ID INT IDENTITY(1,1) PRIMARY KEY,"
            + "ALTO C NOT NULL,"
            + "ANCHO decimal(18, 0) NOT NULL,"
            + "TIPO_TELA_ID INT,"
            + "ESTADO_CORTINA_ID INT,"
            + "MOTORIZADA BIT)";

    private static final String SQL_DROP_ROLLER =
            "DROP TABLE IF EXISTS ROLLER; "
                    + "CREATE TABLE ROLLER("
                    + "ID INT IDENTITY(1,1) PRIMARY KEY," +
                      "ID_CORTINA INT NOT NULL" +
                      "CADENA_METALICA BIT NOT NULL"+
                      "CANO int NOT NULL" +
                      "LARGO_CADENA character)";
    
   private static final String SQL_DROP_CREATE_VENTA = "DROP TABLE IF EXISTS VENTA; "
            + "CREATE TABLE VENTA(ID INT IDENTITY(1,1) PRIMARY KEY,"
            + "CLIENTE_ID INT,"
            + "ESTADO_VENTA_ID INT,"
            + "FECHA DATE,"
            + "PRECIO INT)";
   
   private static final String SQL_DROP_CREATE_VENTA_CORTINA = "DROP TABLE IF EXISTS VENTA_CORTINA; "
            + "CREATE TABLE VENTA_CORTINA("
            + "ID INT IDENTITY(1,1) PRIMARY KEY,"
            + "VENTA_ID INT,"
            + "CORTINA_ID INT)";
   
   private static final String SQL_DROP_CREATE_CLIENTE = "DROP TABLE IF EXISTS CLIENTE; "
            + "CREATE TABLE CLIENTE("
            + "ID INT IDENTITY(1,1) PRIMARY KEY,"
            + "RUT INT,"
            + "NOMBRE VARCHAR(50),"
           +  "TELEFONO INT, "
           + "DIRECCION VARCHAR(100))";
   
   private static final String SQL_DROP_CREATE_ESTADO_CORTINA = "DROP TABLE IF EXISTS ESTADO_CORTINA; "
            + "CREATE TABLE ESTADO_CORTINA("
            + "ID INT IDENTITY(1,1) PRIMARY KEY,"
            + "TELA_CORTADA BIT,"
            + "CANO_CORTADO BIT,"
            + "ARMADO BIT,"
            + "PROBADO BIT)";
   private static final String SQL_DROP_CREATE_ESTADO_VENTA = "DROP TABLE IF EXISTS ESTADO_VENTA; CREATE TABLE ESTADO_VENTA(ID INT PRIMARY KEY IDENTITY(1,1)," +
           "ARMADO BIT NOT NULL,INSTALADO BIT NOT NULL,PAGADO BIT NOT NULL,FACTURADO BIT NOT NULL)";

   private static final String SQL_DROP_CREATE_TIPO_TELA = "DROP TABLE IF EXISTS TIPO_TELA; "
            + "CREATE TABLE TIPO_TELA("
            + "ID INT IDENTITY(1,1) PRIMARY KEY,"
            + "NOMBRE VARCHAR(50),"
            + "COLOR VARCHAR(30),"
            + "DESCRIPCION VARCHAR(100))";
   
   private static final String SQL_INSERT_TIPO_TELA = "INSERT INTO TIPO_TELA(NOMBRE,COLOR,DESCRIPCION)"
           + "VALUES('BLACKOUT','NEGRO',''),('SCREEN','BLANCO','');";
   private static final String SQL_INSERT = "INSERT INTO CLIENTE";
   
    public static Connection GetConexion() throws Exception{
        Class.forName(DRIVER);
        return DriverManager.getConnection(connectionUrl);
    }
    
    public static void createTables(){
        Connection connection=null;
                try{
                    connection = GetConexion();
                    Statement statement = connection.createStatement();
                    statement.execute(SQL_DROP_ROLLER);
                    statement.execute(SQL_DROP_CREATE_TIPO_TELA);
                    statement.execute(SQL_DROP_CREATE_ESTADO_VENTA);
                    statement.execute(SQL_DROP_CREATE_ESTADO_CORTINA);
                    statement.execute(SQL_DROP_CREATE_CLIENTE);
                    statement.execute(SQL_DROP_CREATE_VENTA);
                    statement.execute(SQL_DROP_CREATE_CORTINA);
                    statement.execute(SQL_DROP_CREATE_VENTA_CORTINA);
                }catch(Exception e){
               e.printStackTrace();
                }
    }
    

    
}
