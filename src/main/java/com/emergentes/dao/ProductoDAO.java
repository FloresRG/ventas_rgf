
package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import java.util.List;

public interface ProductoDAO {
 public void insert(Producto cliente) throws Exception;

    public void update(Producto cliente) throws Exception;

    public void delete(int id) throws Exception;

    public Producto getById(int id) throws Exception;

    public List<Producto > getlAll() throws Exception;    
}
