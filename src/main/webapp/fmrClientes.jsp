
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
            <h1>Formulario de Clientes</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="clientes"/>
            </jsp:include>
            <br>
            <!--boton de color primario y tamaño medio-->
            <!--iconos https://fontawesome.com/icons/plus-minus?f=classic&s=solid-->
            <form action="ClienteControlador" method="POST" >               
                <input type="hidden" name="id" value="${cliente.id}">
                <div class="mb-3">
                    <label for="" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="" name="nombre" value="${cliente.nombre}" placeholder="Escriba su nombre">                    
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Correo Electronico</label>
                    <input type="email" class="form-control" id="" name="correo" value="${cliente.correo}" placeholder="Escriba su correo electronico">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Celular</label>
                    <input type="text" class="form-control" id="" name="celular" value="${cliente.celular}">
                </div>                
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>
</html>