/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taller2;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Taller2 {


    public static void main(String[] args) {
        ejercicio2();
    }
    
    /*Metodos de comprobacion: La mayoria de ejercicios requieren una comprobacion del ingreso de datos en el formato adecuado, por eso mismo se realizaron
    metodos reutilizables que comprueban que los datos ingresados mediante un "optionpane input" sean respectivamente o un dato convertible a int o un dato 
    convertible a float.
    */
        public static int comprobacionInt(String mesaje){
            while (true){
                String entrada=JOptionPane.showInputDialog(mesaje);
                if (entrada==null){
                    System.exit(0);
                }
                try{
                    int numero=Integer.parseInt(entrada);
                    return numero;
                }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un numero entero.");
                }
            }
        }      
        
        public static float comprobacionFloat(String mesaje){
            while (true){
                String entrada=JOptionPane.showInputDialog(mesaje);
                if (entrada==null){
                    System.exit(0);
                }
                try{
                    float decimal=Float.parseFloat(entrada);
                        return decimal;
                    }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un dato numerico.");
                }
            }
        }
   
        //Se agrego un metodo para el dato tipo double, ya que en el ejercicio 4 el float tenia impresiciones con numeros grandes
        public static double comprobacionDouble(String mesaje){
            while (true){
                String entrada=JOptionPane.showInputDialog(mesaje);
                if (entrada==null){
                    System.exit(0);
                }
                try{
                    double decimal=Double.parseDouble(entrada);
                        return decimal;
                    }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un dato numerico.");
                }
            }
        }
        
    
    // 1. Solicitar un entero y determinar sí es múltiplo de 3 y además que se encuentre en el rango (100-200).
    public static void ejercicio1(){
        while (true){
            int entero=comprobacionInt("Ingrese el numero a comprobar si es multiplo de 3 dentro del rango (100-200):");
            if (entero<100||entero>200){
                JOptionPane.showMessageDialog(null, "Dato fuera de rango.");
            }else if (entero%3==0){
                JOptionPane.showMessageDialog(null, "Su numero es multiplo de 3.");
                break;
            }else{
                JOptionPane.showMessageDialog(null, "Su numero no es multiplo de 3.");
                break;
            }
        }
    }
    
    //2. Elaborar un algoritmo para leer la fecha de nacimiento de una persona y muestre su signo zodiacal.
    public static void ejercicio2(){
        //Se usa un array con la cantidad de dias que tiene cada mes usado comprobar con un "if" para que la fecha ingresada sea una fecha existente.
        while (true){
            int[] meses={31,28,31,30,31,30,31,31,30,31,30,31};
            int año=comprobacionInt("Ingrese el año.");
            if(año<0){
                JOptionPane.showMessageDialog(null, "No puede ingresar un numero negativo.");
                continue;
            }
            //comprobacion para años biciestos
            else if ((año%4==0&&(año%100)!=0)||año%400==0){
                meses[1]=29;
            }
            int nacimientomes=comprobacionInt("Para calcular su signo ingrese su mes de nacimiento en forma de numero.");
            if (nacimientomes>12||nacimientomes<1){
                JOptionPane.showMessageDialog(null, "Ingrese un mes valido (1-12).");
                continue;
            }
            int nacimientodia=comprobacionInt("Ingrese su dia de nacimiento en forma de numero.");
            if (nacimientodia>meses[nacimientomes-1]||nacimientodia<1){
                JOptionPane.showMessageDialog(null, "Ingrese una fecha valida para el mes ingresado.");
                continue;
            }
            //Se usa un metodo que hace la comprobacion de que el dia corresponda con su signo(linea 141).
            switch(nacimientomes){
                case 1:
                    signo(nacimientodia,20,"acuario","Capricornio");
                    break;
                case 2:
                    signo(nacimientodia,19,"picis","acuario");
                    break;
                case 3:
                    signo(nacimientodia,21,"aries","picis");
                    break;
                case 4:
                    signo(nacimientodia,20,"tauro","aries");
                    break;
                case 5:
                    signo(nacimientodia,21,"geminis","tauro");
                    break;
                case 6:
                    signo(nacimientodia,21,"cancer","geminis");
                    break;
                case 7:
                    signo(nacimientodia,23,"leo","cancer");
                    break;
                case 8:
                    signo(nacimientodia,23,"virgo","leo");
                    break;
                case 9:
                    signo(nacimientodia,23,"libra","virgo");
                    break;
                case 10:
                    signo(nacimientodia,23,"escorpio","libra");
                    break;
                case 11:
                    signo(nacimientodia,22,"sagitario","escorpio");
                    break;
                case 12:
                    signo(nacimientodia,22,"capricornio","sagitario");
                    break;
            }
        break;
        }
    }
    
        //Para evitar el codigo largo repetitivo en cada case use un metodo que muestre el signo correspondiente a partir de los datos ingresados
        public static void signo(int dia, int limite, String signo1, String signo2){
            if(dia>=limite){
                JOptionPane.showMessageDialog(null,"Su signo es "+signo1);
            }else{
                JOptionPane.showMessageDialog(null,"Su signo es "+signo2);
            }
        }

    //3. Tienda descuentos: Solicita el valor del producto, el valor del descuento y calcula el valor a pagar.
    public static void ejercicio3(){
        while (true){
            float valor=comprobacionFloat("Ingrese el valor del producto");
            if (valor<0){
                JOptionPane.showMessageDialog(null, "No puede ingresar numeros negativos");
                continue;
            }
            while (true){
                float descuento=comprobacionFloat("Ingrese el valor del descuento (unicamente el numero del porcentaje, sin el simbolo %)");
                if (descuento<0){
                    JOptionPane.showMessageDialog(null, "No puede ingresar numeros negativos");
                }else{
                    float cobro=(valor-(valor*(descuento/100)));
                    JOptionPane.showMessageDialog(null, "Su valor a pagar es de $"+cobro);
                    System.exit(0);
                }
            }
        }
    }
    
    //4.  Hallar el mayor de tres números y mostrar los tres organizados de menor a mayor.
    public static void ejercicio4(){
        double[] numeros=new double[3];
        numeros[0]=comprobacionDouble("Ingrese el primer número a ordenar.");
        numeros[1]=comprobacionDouble("Ingrese el segundo número a ordenar.");
        numeros[2]=comprobacionDouble("Ingrese el tercer número a ordenar.");
        Arrays.sort(numeros);
        JOptionPane.showMessageDialog(null, "Números ordenados: "+numeros[0]+", "+numeros[1]+", "+numeros[2]);
    }
    
    //5. Solicitar una fecha y hallar el día posterior teniendo en cuenta la cantidad de días de cada mes y también tener en cuenta el cambio de año.
    public static void ejercicio5(){
        //array con la cantidad de dias de cada mes (usada para la comprobacion de la fecha existente y el calculo del dia posterior)
        int[] meses={31,28,31,30,31,30,31,31,30,31,30,31};
        /*comprobacion de que la fecha ingresada exista.
        Nota: Ya que solo se usa este tipo de comprobacion en el ejercicio 5 y 2 y solo una vez en cada uno de esos ejercicios preferi escribir 
        el codigo de comprobacion de fecha otra vez antes que hacer un metodo*/
        while (true){
            int año=comprobacionInt("Ingrese el año.");
            //comprobacion para años biciestos (linea 180-183)
            if ((año%4==0&&(año%100)!=0)||año%400==0){
                meses[1]=29;
            }
            if(año<0){
                JOptionPane.showMessageDialog(null, "No puede ingresar un numero negativo.");
                continue;
            }
            int mes=comprobacionInt("Ingrese el numero del mes.");
            if (mes>12||mes<1){
                JOptionPane.showMessageDialog(null, "Ingrese un mes valido (1-12).");
                continue;
            }
            int dia=comprobacionInt("Ingrese el numero del dia");
            if (dia>meses[mes-1]||dia<1){
                JOptionPane.showMessageDialog(null, "Ingrese una fecha valida para el mes ingresado.");
                continue;
            }
            //calculo del dia posterior.
            int[] diaposterior=new int[3];
            if ((mes+1)== 13 && (dia+1)>meses[mes-1] ){
                diaposterior[2]=año+1;
                diaposterior[1]=1;
                diaposterior[0]=1;
            }else if ((dia+1)>meses[mes-1]){
                diaposterior[2]=año;
                diaposterior[1]=(mes+1);
                diaposterior[0]=1;
            }else{
                diaposterior[2]=año;
                diaposterior[1]=mes;
                diaposterior[0]=dia+1;
            }
            JOptionPane.showMessageDialog(null, "La fecha del dia posterior al ingresado es: "+diaposterior[0]+"/"+diaposterior[1]+"/"+diaposterior[2]);
            break;
                    
        }
    }
}
