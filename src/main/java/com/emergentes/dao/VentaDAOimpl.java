package com.emergentes.dao;

import com.emergentes.modelo.Ventas;
import com.emergentes.utiles.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOimpl extends conexionDB implements VentasDAO {

    @Override
    public void insert(Ventas ventas) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO ventas (producto_id,cliente_id,fecha) VALUES(?,?,?)");
            ps.setInt(1, ventas.getProducto_id());
            ps.setInt(2, ventas.getCliente_id());
            ps.setDate(3, ventas.getFecha());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Ventas ventas) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE ventas SET producto_id=?,cliente_id=?,fecha=?  WHERE id=?");
            ps.setInt(1, ventas.getProducto_id());
            ps.setInt(2, ventas.getCliente_id());
            ps.setDate(3, ventas.getFecha());
            ps.setInt(4, ventas.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM ventas WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Ventas getById(int id) throws Exception {
        Ventas ven = new Ventas();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM ventas WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ven.setId(rs.getInt("id"));
                ven.setProducto_id(rs.getInt("producto_id"));
                ven.setCliente_id(rs.getInt("cliente_id"));
                ven.setFecha(rs.getDate("fecha"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return ven;
    }

    @Override
    public List<Ventas> getlAll() throws Exception {
        List<Ventas> lista = null;
        try {
            this.conectar();
            String sql = "SELECT v.*,p.nombre AS producto ,c.nombre AS cliente FROM ventas v ";
            sql += "LEFT JOIN productos p ON (v.producto_id=p.id) ";
            sql += "LEFT JOIN clientes c ON (c.id=v.cliente_id) ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista=new ArrayList();
            while (rs.next()) {
                Ventas ven = new Ventas();
                ven.setId(rs.getInt("id"));
                ven.setProducto_id(rs.getInt("producto_id"));
                ven.setCliente_id(rs.getInt("cliente_id"));
                ven.setFecha(rs.getDate("fecha"));
                ven.setCliente(rs.getString("cliente"));
                ven.setProducto(rs.getString("producto"));
                lista.add(ven);
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
