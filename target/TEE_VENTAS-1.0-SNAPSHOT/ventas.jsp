<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--jalamos el enlace de bots https://getbootstrap.com/docs/5.3/getting-started/introduction/-->
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Punto de Venta</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <div class="container">
            <h1>Ventas</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="clientes"/>
            </jsp:include>
            <br>
            <!--boton de color primario y tamaño medio-->
            <!--iconos https://fontawesome.com/icons/plus-minus?f=classic&s=solid-->
            <a href="VentaControlador?action=add" class="btn btn-primary btn-sm"><i class="fa-solid fa-plus-minus"></i>Nuevo</a>              
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>NOMBRE DE CLIENTE</th>
                    <th>PRODUCTO</th>
                    <th>FECHA</th>
                    <th></th>
                    <th></th>
                </tr>                         
                <c:forEach var="item" items="${ventas}"><!--lo de ventas es el atributo del request-->
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.cliente}</td>
                        <td>${item.producto}</td>                   
                        <td>${item.fecha}</td>                   
                        <td><a href="VentaControlador?action=edit&id=${item.id}"><i class="fa-solid fa-pen-to-square"></i> Editar</a></td>                    
                        <td><a href="VentaControlador?action=delete&id=${item.id}" onclick="return confirm('Esta seguro ?')"><i class="fa-solid fa-trash"></i> Eliminar</a></td>
                    </tr> 
                </c:forEach>
            </table>
        </div>    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>