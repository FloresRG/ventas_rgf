package com.emergentes.dao;

import com.emergentes.modelo.Cliente;
import com.emergentes.utiles.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOimpl extends conexionDB implements ClienteDAO {

    @Override
    public void insert(Cliente Cliente) throws Exception {
        try {
            this.conectar();            
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO clientes (nombre,correo,celular) VALUES(?,?,?)");
            ps.setString(1, Cliente.getNombre());
            ps.setString(2, Cliente.getCorreo());
            ps.setString(3, Cliente.getCelular());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Cliente Cliente) throws Exception {
        try {
            this.conectar();            
            PreparedStatement ps = this.conn.prepareStatement("UPDATE clientes SET nombre=?,correo=?,celular=? WHERE id=?");
            ps.setString(1, Cliente.getNombre());
            ps.setString(2, Cliente.getCorreo());
            ps.setString(3, Cliente.getCelular());
            ps.setInt(4, Cliente.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();            
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM clientes WHERE id=?");                        
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Cliente getById(int id) throws Exception {
        Cliente cli= new Cliente();
         try {
            this.conectar();            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM clientes WHERE id=?");                        
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                cli.setId(rs.getInt("id"));
                cli.setNombre(rs.getString("nombre"));                
                cli.setCorreo(rs.getString("correo"));
                cli.setCelular(rs.getString("celular"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
         return cli;
    }

    @Override
    public List<Cliente> getlAll() throws Exception {
        List<Cliente> lista=null;
        try {
            this.conectar();            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM clientes");                                    
            ResultSet rs=ps.executeQuery();
            lista=new ArrayList();
            while(rs.next()){
                Cliente cli= new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNombre(rs.getString("nombre"));                
                cli.setCorreo(rs.getString("correo"));
                cli.setCelular(rs.getString("celular"));
                lista.add(cli);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
         return lista;
    }

}
