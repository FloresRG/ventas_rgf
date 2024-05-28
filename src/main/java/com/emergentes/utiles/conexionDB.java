package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexionDB {
//static String driver = "com.mysql.jdbc.Driver";        
static String driver = "com.mysql.cj.jdbc.Driver";        
    static String url = "jdbc:mysql://localhost:3306/BD_VENTAS";
    static String usuario = "root";
    static String password = "";

    protected Connection conn = null;

    public conexionDB() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion ok" + conn);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la Conexion");
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar" +ex.getMessage());
        }
    }

}
