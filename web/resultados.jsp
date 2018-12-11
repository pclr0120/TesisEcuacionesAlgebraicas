<%-- 
    Document   : Resultados
    Created on : 14/11/2018, 02:12:30 AM
    Author     : PCLR
--%>


<%@page import="algoritmo.Algoritmo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background:#112F41">



        <%!
            public String ec1;
            public String ec2;
            public String mensaje = "Enunciado no valido";
        %>
        <%

            Algoritmo algo = new Algoritmo();
            algo.Ecuacion1 = "";
            algo.Ecuacion2 = "";

            try {

                algo.Enunciado = request.getParameter("enunciado");

                algo.procesar(algo.Enunciado);

                ec1 = algo.Ecuacion1;
                ec2 = algo.Ecuacion2;

                if (ec2.length() > 0 && ec2 != "" && ec1.length() > 1) {
                    mensaje = "";
                } else {
                    mensaje = "Enunciado no valido!";
                    algo.Enunciado = "Enunciado no valido!";
                }

            } catch (Exception e) {

            }

        %>
        <form method="post"  >  
            <div class="container" style="background:transparent">
                <div class="row">
                    <div class="col-sm">

                    </div>
                    <div class="col-sm">


                        <div class="card" style="width: 50rem;background: #ebebeb;">
                            <h1 style="background:white;text-align: center;background: #ebebeb " >Resultados</h1> 
                            <hr style="border: 10%">
                            <div class="todo" >
                                <h5>Enunciado:<h5>
                                        <p style="font-size:12px;color:#005BA8"><%=algo.Enunciado%></p>

                                        <h1 style="color:red"><%=mensaje%></h1>
                                        </div>
                                        <hr style="border: solid">
                                        <div class="todo" >
                                            <h5>Ecuacion 1:</h5>
                                            <input style="border-radius:0px;width: 100%"  value="<%= ec1%>" placeholder="A qui va Ecuacion 1" name="ecuacion1">
                                        </div>

                                        <hr style="border: solid">
                                        <div class="todo"  >
                                            <h5>Ecuacion 2:</h5>
                                            <input  style="border-radius:0px;width: 100%" name="Ecuacion2" value="<%= ec2%>" placeholder="A aqui va Ecuacion2">
                                        </div>
                                        <hr style="border: solid">
                                        <div class="card-body">
                                            <h5 class="card-title"></h5>
                                            <p class="card-text"></p>
                                            <div class="row">

                                                <div class="col-sm">

                                                    <a href="index.htm" style="color:white;background: #d32102;width: 100% " class="btn ">Intentar con otro enunciado</a>
                                                </div>
                                                <div class="col-sm">
                                                    <button style="color:white;background: #00a2e8;width: 100% "  class="btn btn-primary">Consultar Ecuaciones</button>

                                                </div>
                                            </div> </div>
                                        </div>
                                        </div>
                                        <div class="col-sm">

                                        </div>
                                        </div>
                                        </div>


                                        </form>
                                        </body>
                                        </html>
