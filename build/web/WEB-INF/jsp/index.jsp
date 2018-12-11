<%@page import="algoritmo.Algoritmo"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Tesis</title>
    </head>
    <body style="background:#112F41" >

    <style>

        .input1{
            background: white;
            border-radius: 0px;
            max-height: 100px;
            max-width: 95%;
            width: 95%;
            height: 100px;
            margin-left: 20px;
            margin-right: 20px;
            ::placeholder{
                color:black;
                font-family:cursive;

            }




        }
        .todo{
            margin-left: 20px;
            margin-right: 20px;
        }
        .titulo{



            font-size: 20px;

        }
        .div1{

            background: black;
            border: 20px;
            width: auto;


        }
    </style>


    <form method="post"  action="resultados.jsp"   >  
        <div class="container" style="background:transparent">
            <div class="row">
                <div class="col-sm">

                </div>
                <div class="col-sm" >

                    <div class="card" style="width: 50rem;background: #ebebeb">
                        <h1 style="background: #ebebeb;text-align: center; " >Bienvenido<p style="color:rgb(107, 107, 107);font-size: 12px">Procesamiento de  enunciados algebraico</p></h1> 
                        <h6>V.Beta 1.2</h6>
                        <hr style="border: solid">
                        <label style="font-size: 12px">Ejemplo: "<label style="font-size: 12px;color:blue">1/3</label> de la diferencia de <label style="font-size: 12px;color:blue">dos</label> numeros es <label style="font-size: 12px;color:blue">igual</label> a 11 y los 4/9 del mayor equivalen a los 3/4 del menor. Hallar los dos numero."</label>

                        <hr style="border: solid;align-items: center ">
                        <div class="row">

                            <div class="col-sm">
                                <textarea name="enunciado" onkeypress=" soloLetras(event)" type="text" id="enunciado" maxlength="150"  required=""  placeholder="Escriba aqui el enunciado...(Sin caracteres especiales.. gracias)"  class="input1"></textarea>     
                           <script>
    function soloLetras(e){
      var elementValue = e.srcElement.value;
    if (elementValue) {
      var regex = /^([a-zA-Z0-9/]+ ?)*$/;
      var tempValue = elementValue.substring(0, elementValue.length - 1);
      if (!regex.test(elementValue)) {
        e.srcElement.value = tempValue;
      }
    }
    }
</script>
                            </div>

                        </div>
                        <hr style="border: solid">

                        <div class="card-body">
                            <h5 class="card-title"></h5>
                            <p class="card-text"></p>
                            <div class="row">
                                <div class="col-sm">
                                </div>
                                <div class="col-sm">


                                    <button style="color:white;background: #00a2e8;width: 100% " type="submit"   class="btn btn-primary">Procesar Enunciado</button>

                                </div>



                                <div class="col-sm">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm">

                </div>
            </div>
        </div>


    </form>

</body>

</html>
