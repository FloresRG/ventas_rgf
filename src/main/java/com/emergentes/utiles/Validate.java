 
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Validate extends conexionDB{
    Connection conn= this.conectar();
    PreparedStatement ps;
    
    public boolean checkUser(String email,String password){
        boolean res=false;
        try {            
            String sql="SELECT * FROM USUARIOS WHERE email=? AND password=SHA1(?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            res=rs.next();            
        } catch (SQLException ex) {
            Logger.getLogger(Validate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
