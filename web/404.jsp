
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error: 404</title>
        
            <link rel="shortcut icon" href="${pageContext.request.contextPath}/style/img/favicon.ico">
            <!-- Estilos -->
            <!-- Fuente roboto extraida desde Google -->
            <link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/roboto.css">
            <!-- Hoja de estilo Bootstrap sin alteraciones -->
            <link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/bootstrap.css">        
            <!-- Estilos y soporte para el pack de iconos para funciones javascript -->
            <link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/plugins.css">
            <!-- Hoja de estilo principal de la plantilla. Este sobreescribe al Bootstrap original -->
            <link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/main.css">        
            <!-- Estilos individuales los cuales se diferencian por colores -->
            <link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/themes.css">
            <!-- FIN Estilos -->
    </head>
    <body>
        <div class="error-container standalone themed-border-fire">
            <a href="javascript:window.history.back();" class="btn btn-success">
                <i class="icon-chevron-left"></i> Volver Atras
            </a>
            <div class="error-text">Ups, Pagina no Encontrada</div>
            <div class="error-code text-error">
                <i class="icon-warning-sign animate-360"></i> Error 404 </div>
            </div>
        </div>    
    </body>
</html>
