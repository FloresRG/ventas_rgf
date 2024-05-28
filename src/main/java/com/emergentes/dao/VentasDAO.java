
package com.emergentes.dao;

import com.emergentes.modelo.Ventas;
import java.util.List;

public interface VentasDAO {
     public void insert(Ventas cliente) throws Exception;

    public void update(Ventas cliente) throws Exception;

    public void delete(int id) throws Exception;

    public Ventas getById(int id) throws Exception;

    public List<Ventas> getlAll() throws Exception;    
}
