package com.emergentes.controlador;

import com.emergentes.dao.ClienteDAO;
import com.emergentes.dao.ClienteDAOimpl;
import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;
import com.emergentes.dao.VentaDAOimpl;
import com.emergentes.dao.VentasDAO;
import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Producto;
import com.emergentes.modelo.Ventas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet(name = "VentaControlador", urlPatterns = {"/VentaControlador"})
public class VentaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            VentasDAO dao = new VentaDAOimpl();
            ProductoDAO daoProducto = new ProductoDAOimpl();
            ClienteDAO daoCliente = new ClienteDAOimpl();
            int id; //edita o eliminar
            List<Producto> lista_productos = null;
            List<Cliente> lista_clientes = null;
            //opracion de adicion, edicion,eliminacion
            Ventas venta = new Ventas();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_productos = daoProducto.getlAll();
                    lista_clientes = daoCliente.getlAll();
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_clientes", lista_clientes);
                    //objeto venta 
                    request.setAttribute("venta", venta); //esta vacio este es otro
                    request.getRequestDispatcher("frmventas.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    venta = dao.getById(id);
                    lista_productos = daoProducto.getlAll();
                    lista_clientes = daoCliente.getlAll();
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_clientes", lista_clientes);
                    request.setAttribute("venta", venta); //esta vacio
                    request.getRequestDispatcher("frmventas.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("VentaControlador");
                    break;
                case "view":
                    List<Ventas> lista = dao.getlAll();
                    request.setAttribute("ventas", lista);//atributo ventas
                    //enviar a la vista
                    request.getRequestDispatcher("ventas.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        VentasDAO dao = new VentaDAOimpl();
        // si es 0 es nuevo
        int id = Integer.parseInt(request.getParameter("id"));
        int cliente_id = Integer.parseInt(request.getParameter("cliente_id"));
        int producto_id = Integer.parseInt(request.getParameter("producto_id"));
        String fecha = request.getParameter("fecha");

        Ventas venta = new Ventas();
        venta.setId(id);
        venta.setProducto_id(producto_id);
        venta.setCliente_id(cliente_id);
        venta.setFecha(ConvierteFecha(fecha));           
        if (id == 0) {
            //nuevo           
            try {
                dao.insert(venta);                                                             
            } catch (Exception ex) {
                System.out.println("Error" + ex.getMessage());
            }
        } else {
            //MODIFICAR                         
            try {
                dao.update(venta);             
            } catch (Exception ex) {
                System.out.println("Error" + ex.getMessage());
            }
        }
        response.sendRedirect("VentaControlador");

    }

    Date ConvierteFecha(String fecha) {
        Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return fechaBD;
    }

}
