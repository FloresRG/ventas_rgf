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
            <h1>Formulario de Ventas</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="ventas"/>
            </jsp:include>
            <br>
            <!--boton de color primario y tamaño medio-->
            <!--iconos https://fontawesome.com/icons/plus-minus?f=classic&s=solid-->
            <form action="VentaControlador" method="Post" >               
                <input type="hidden" name="id" value="${venta.id}">
                <div class="mb-3">
                    <label for="" class="form-label">Cliente</label>                    
                    <select name="cliente_id" class="form-control">
                        <option value="">--Seleccione un cliente--</option>
                        <c:forEach var="item" items="${lista_clientes}">
                            <option value="${item.id}"
                                    <c:if test="${venta.cliente_id==item.id}">
                                        selected
                                    </c:if>
                                    >${item.nombre}</option>
                        </c:forEach> 
                    </select>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Producto</label>                    
                    <select name="producto_id" class="form-control">
                        <option value="">--Seleccione un producto--</option>
                        <c:forEach var="item" items="${lista_productos}">                            
                            <option value="${item.id}"   
                                    <c:if test="${venta.producto_id==item.id}">
                                        selected
                                    </c:if>
                                    >${item.nombre}</option>
                        </c:forEach> 
                    </select>
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">Fecha</label>
                    <input type="text" class="form-control" id="" name="fecha" value="${venta.fecha}"placeholder="Escriba la fecha">
                </div>                
                <button type="submit" class="btn btn-primary">Enviar</button>                
            </form>
        </div>    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>