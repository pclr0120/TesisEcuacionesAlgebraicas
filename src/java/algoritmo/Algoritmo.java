/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author PCLR
 */

public class Algoritmo {

    /**
     * @param args the command line arguments
     */
    
    String[] OperadoresSimbolo={"+","+","+","+", "-","-","-","-","-","=","=","="};
    String[]SinonimosOperadores={"SUMA", "MAS", "ADICION", "AUMENTO", "RESTA", "RESTAR", "DECREMENTO", "DIFERENCIA","MENOS", "IGUAL","ES","SON"};
    String[]VariablesAlegebraicas={"K", "X", "Z", "W", "NUMEROS","DOBLE","TRIPLE", "DOS","NUMERO","UN", "Y","MAYOR","MENOR","-"};  
    public String Enunciado="la diferencia de dos numeros es igual 1529 y su suma es igual 101"; 
    ArrayList<Expresion> VariablesEncontradas; //Vairables y numeros
    ArrayList<Expresion> OperadoresEncontrados; //Solo Operadores
    
    ArrayList<Expresion> SimbolosEncontradosOrdenados; //Array ordenado Listo para Crear la ecuacion
    String[] EnunciadoValidado;
    public String EnunciadoSintildes="";
    public String Ecuacion1="";
    public String Ecuacion2="";
    public String[] Ecuaciones;
    
  
    public static  void main(String[] args) {
        // TODO code application logic here
        //Algoritmo a=new Algoritmo();
        //la suma de dos numeros es igual 190 y 1/9 de su diferencia es igual 20
        //la diferencia de dos numeros es igual 1529 y su suma es igual 101
        //1/4 de la suma de dos numeros es igual 45 y 1/3 de su diferencia es igual 4
        
        //a.procesar(a.Enunciado);
        
        
        Algoritmo a =new Algoritmo();
        a.procesar("1/4 de la suma de dos números es 45 y 1/3 de su diferencía es 4. Hallar los dos numeros.");
        
     
                         
    }
     public void procesar(String enunciado){
    
         try{
                  Enunciado=enunciado; 
        EnunciadoValidado=ValidarEnunciado(Enunciado);
        
        OperadoresEncontrados=Extreaccion(EnunciadoValidado, SinonimosOperadores, false);
        VariablesEncontradas=Extreaccion(EnunciadoValidado, VariablesAlegebraicas, true);
        SimbolosEncontradosOrdenados=OrdenarArray(OperadoresEncontrados, VariablesEncontradas);
        SimbolosEncontradosOrdenados=CambiarSinonimos(SimbolosEncontradosOrdenados, SinonimosOperadores, OperadoresSimbolo);
        if(SonDosEcuaciones(SimbolosEncontradosOrdenados)>-1){
                 Ecuacion1=CrearEcuacion1(SimbolosEncontradosOrdenados).replace(".", "");
                 Ecuacion2=CrearEcuacion2(SimbolosEncontradosOrdenados, SonDosEcuaciones(SimbolosEncontradosOrdenados),Ecuacion1 ).replace(".", "");
                 Ecuacion1=EliminarDuplicadoIgual(Ecuacion1);
                 Ecuacion2=EliminarDuplicadoIgual(Ecuacion2);
        }
        else{
          Ecuacion1=CrearEcuacion1(SimbolosEncontradosOrdenados).replace(".", "");
          Ecuacion2="No se encontro";
        }
        
        
        System.out.println("Solo una ecuacion:"+  Ecuacion1+"/"+Ecuacion2);
        String[] ecuaciones={"",""};
        ecuaciones[0]=Ecuacion1.replace(".", "");
        ecuaciones[1]=Ecuacion2.replace(".", "");
         
         System.out.println("Hola:"+Ecuacion1+"/"+Ecuacion2);
         }catch(Exception e){
         
         }
      
      
    }
    
    private boolean BuscarFraccion(String EsFraccion){
        int intIndex = EsFraccion.indexOf("/");
       
        System.out.println(intIndex);
        if(intIndex>-1){
         String[] Esnumero=EsFraccion.split("/");
         int contador=0; 
         for(int i=0;i<Esnumero.length;i++){
            if(EsNumero(Esnumero[i])){
                 contador+=1;
             }
         
         }
         if(contador==Esnumero.length)
             return true;
        }
           
        return false;
    }
    private String[] ValidarEnunciado(String Enunciado){   //Limpiar enunciado
        Enunciado=EliminarCaracteres(Enunciado);  //limpar tildes 
        EnunciadoSintildes=Enunciado;
        System.out.println("hoas:"+EnunciadoSintildes);
         String[] enunciado=null;
         String E;
         
         E=Enunciado.toUpperCase().replace(",","");
        
         E=E.replace("  ", " ");
         enunciado=E.split(" ");
         System.out.println("EnunciadoLong.:"+enunciado.length);
           for(int x=0; x<enunciado.length;x++){
             System.out.println("Enunciado:"+x+"/"+enunciado[x]);
           }
           
        return enunciado;
    }
    
    
    private  ArrayList<Expresion> Extreaccion( String[] enunciado,String[] patronesAencontrar,boolean numeros){
         ArrayList<Expresion> extraccion=new ArrayList<Expresion>();
         
         for(int x=0; x<enunciado.length;x++){
               Expresion PatronEncontrado=new Expresion();
             
        
               
             if((numeros  && this.EsNumero(enunciado[x])) || (BuscarFraccion(enunciado[x]) && numeros) ){ //para ecnontrar numeros y fracciones en el enunciado, estos se activan cuando se buscan varibales
               
                     PatronEncontrado.Posicion=x;   //se gudarda la posicion donde se encontro
                     PatronEncontrado.Valor=enunciado[x]; //y su valor(El numero)
                     extraccion.add(PatronEncontrado);
                 
                     
                 
             }else{   //si no esta activodo el encontrar numeor o tampoco es numero entonces busca otro patron de pendiendo del arraglo que se le de
             //ya sea variables o operadores
                 for(int i=0;i<patronesAencontrar.length;i++){
                     PatronEncontrado=new Expresion();
                     if(enunciado[x].toString().replace(".", "").equals(patronesAencontrar[i].toString())){
                         PatronEncontrado.Posicion=x;
                         PatronEncontrado.Valor=patronesAencontrar[i]; // en caso de de ser opereador hay que cambiarlo  por el simbolo
                         extraccion.add(PatronEncontrado);
                        
                                 
                     }
                 
                 }
             }
          
            
         
         }
          for(int y=0;y<extraccion.size();y++){
             
                 System.out.println("Numero:"+numeros+"/Encontro:"+extraccion.get(y).Posicion+"/"+extraccion.get(y).Valor);
             }
        return extraccion;
    }
    
    private ArrayList<Expresion> CambiarSinonimos( ArrayList<Expresion> PorCambiar,String[] SinonimoAcambiar,String[]simbolo){
        ArrayList<Expresion> Cambios=new ArrayList<Expresion>();
        Cambios=PorCambiar;
        for(int x=0;x<PorCambiar.size();x++){
            for(int i=0;i< SinonimoAcambiar.length; i++){
                      if(PorCambiar.get(x).Valor.toString().equals(SinonimoAcambiar[i].toString())){
                         Cambios.get(x).Posicion=x;
                         Cambios.get(x).Valor=simbolo[i];      
                      }
            }
       
        }
           //for(int y=0;y<Cambios.size();y++){
             
              //   System.out.println("Cambio:"+Cambios.get(y).Valor);
             //}
        return Cambios;
    }

    private ArrayList<Expresion>  OrdenarArray(ArrayList<Expresion> a,ArrayList<Expresion> b){
      ArrayList<Expresion> Aordenar= new ArrayList<Expresion>();
        ArrayList<Expresion> EnunciadoOrdenado= new ArrayList<Expresion>();
        //Unir variables y operadores encontrados
        for(int z=0;z<a.size();z++){
            Aordenar.add(a.get(z));
                   System.out.println("a:pos:"+a.get(z).Posicion+"/"+a.get(z).Valor);
        }
        for(int z=0;z<b.size();z++){
            Aordenar.add(b.get(z));
            System.out.println("b:pos:"+b.get(z).Posicion+"/"+b.get(z).Valor);
        }  	
         Aordenar.sort(new Comparator<Expresion>() {
            @Override
            public int compare(Expresion o1, Expresion o2) {
                return o1.Posicion.compareTo(o2.Posicion);
            }
          });
           ///fin del enunciado .
          for(int o =0; o< Aordenar.size(); o++){
                   EnunciadoOrdenado.add(Aordenar.get(o));
              if(Aordenar.get(o).Valor.indexOf(".")>-1) //fin del enunciado
                  break;
              System.out.println("ordenados:/posicion:"+Aordenar.get(o).Posicion+"/"+Aordenar.get(o).Valor);
                  }
         return EnunciadoOrdenado;
    }
    
    private int SonDosEcuaciones(ArrayList<Expresion> EnunciadoOrdenado){
        
    
        for(int i =0;i<EnunciadoOrdenado.size();i++){
               if(EnunciadoOrdenado.get(i).Valor.toString().equals("Y"))
                   return i;
                           
        }
        return -1 ;
    }
    
    
    private String CrearEcuacion1(ArrayList<Expresion> EnunciadoOrdenado){
        String ecuacion="";
        
         int dosEcuaciones=SonDosEcuaciones(SimbolosEncontradosOrdenados);
          for(int i =0;i<EnunciadoOrdenado.size();i++){
             if(i<dosEcuaciones){
              if(i==0&&(EnunciadoOrdenado.get(0).Valor.toString().equals("+")||EnunciadoOrdenado.get(0).Valor.toString().equals("-"))){
                  if(EnunciadoOrdenado.get(1).Valor.toString().equals("DOS")){
                     ecuacion+="X"+EnunciadoOrdenado.get(0).Valor.toString()+"Z"; 
                     i=3;
                  }
                    if(EnunciadoOrdenado.get(2).Valor.toString().equals("UN")){
                   ecuacion+="X"+EnunciadoOrdenado.get(0).Valor.toString()+"Z"; 
                      i=3;
                  }
              }
               if(i==0&&(BuscarFraccion(EnunciadoOrdenado.get(0).Valor) && (EnunciadoOrdenado.get(1).Valor.toString().equals("-") ||EnunciadoOrdenado.get(1).Valor.toString().equals("+")))){
                  if(EnunciadoOrdenado.get(2).Valor.toString().equals("DOS")){
                     ecuacion+=EnunciadoOrdenado.get(0).Valor+"(X"+EnunciadoOrdenado.get(1).Valor.toString()+"Z)"; 
                     i=4;
                  }
                  
              }
             
              
              ecuacion+=EnunciadoOrdenado.get(i).Valor;
             }
                           
        }
          return ecuacion;
    }
    private String CrearEcuacion2(ArrayList<Expresion> EnunciadoOrdenado,int posicionY,String ecuacion1){
      String ecuacion="";
        
          int intIndex =ecuacion1.indexOf("-");
          if(intIndex<1){
                  intIndex =ecuacion1.indexOf("+");
          }
        
          String mayor="";
          String menor="";
          
          if(intIndex>-1){
              mayor=ecuacion1.substring(intIndex-1,intIndex);
                menor=ecuacion1.substring(intIndex+1,intIndex+2);
                
          }
          
          for(int i =posicionY+1;i<EnunciadoOrdenado.size();i++){ 
               
              //caso1
              if(i==posicionY+1 && (BuscarFraccion(EnunciadoOrdenado.get(i).Valor)&&EnunciadoOrdenado.get(i+1).Valor.toString().equals("MAYOR"))){
                     ecuacion+=EnunciadoOrdenado.get(i).Valor+mayor+"="; 
                     i+=2;
              }
               if(i>posicionY+1 && (BuscarFraccion(EnunciadoOrdenado.get(i).Valor)&&EnunciadoOrdenado.get(i+1).Valor.toString().equals("MENOR"))){
                     ecuacion+=EnunciadoOrdenado.get(i).Valor+menor; 
                     i=EnunciadoOrdenado.size();
              }
               
               //fin caso1
               
               //caso2
                if(i==posicionY+1 && (BuscarFraccion(EnunciadoOrdenado.get(i).Valor)&&EnunciadoOrdenado.get(i+1).Valor.toString().equals("-"))){
                     ecuacion+=EnunciadoOrdenado.get(i).Valor+"("+mayor+"-"+menor+")="+EnunciadoOrdenado.get(EnunciadoOrdenado.size()-1).Valor; 
                     i=EnunciadoOrdenado.size();
                  }
                    if(i==posicionY+1 && (BuscarFraccion(EnunciadoOrdenado.get(i).Valor)&&EnunciadoOrdenado.get(i+1).Valor.toString().equals("+"))){
                     ecuacion+=EnunciadoOrdenado.get(i).Valor+"("+mayor+"+"+menor+")="+EnunciadoOrdenado.get(EnunciadoOrdenado.size()-1).Valor; 
                     i=EnunciadoOrdenado.size();
                  }
              //fin caso 2
              //caso 3 
                if( i==posicionY+1 &&EnunciadoOrdenado.get(i).Valor.toString().equals("-") && EnunciadoOrdenado.get(i+1).Valor.toString().equals("=") ){
                     ecuacion+=mayor+"-"+menor+"="+EnunciadoOrdenado.get(EnunciadoOrdenado.size()-1).Valor; 
                     i=EnunciadoOrdenado.size();
                  }else if( i==posicionY+1&& EnunciadoOrdenado.get(i).Valor.toString().equals("+") && EnunciadoOrdenado.get(i+1).Valor.toString().equals("=") ){
                     ecuacion+=mayor+"+"+menor+"="+EnunciadoOrdenado.get(EnunciadoOrdenado.size()-1).Valor; 
                     i=EnunciadoOrdenado.size();
                  }
                
              
              
                           
        }
          return ecuacion;
    }
    
  
    
    private boolean EsNumero(String numero){
        numero=numero.replace(".","");
        try{
            Integer.parseInt(numero);
            return true;
        }catch(NumberFormatException e1){
            
                try{
                    Float.parseFloat(numero);
                    return true;
               }catch(NumberFormatException e2){
                    return false;
               }
        }
    }
    private String EliminarDuplicadoIgual(String ecuacion){
      ecuacion=ecuacion.replace("==", "=");
         ecuacion=ecuacion.replace("==", "=");
          ecuacion=ecuacion.replace("===", "=");
            ecuacion=ecuacion.replace("===", "=");
             ecuacion=ecuacion.replace("====", "=");
            
       
        return ecuacion;
    }
    public  String EliminarCaracteres (String input) {
    String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
    String output = input;
    for (int i=0; i<original.length(); i++) {
        output = output.replace(original.charAt(i), ascii.charAt(i));
    }
    return output;
    }
    
}
