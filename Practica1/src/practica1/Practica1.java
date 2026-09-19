/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1;

import java.util.Scanner;

public class Practica1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ejercicio1();
    }

    public static void ejercicio1() {
        int indice = comprobacionFormatoInt("Bienvenido al sistema de notas, digite el numero de estudiantes: ", 0);
        //Guardado de datos:
        String[] estudiantes = new String[indice];
        Double[] notas = new Double[indice];
        Object[][] datos = {
            estudiantes, notas
        };
        //menu:
        int menu=0;
        boolean comprobacion=false;
        while (menu!= 11) {
            menu = comprobacionFormatoInt("Menu: 1)cargar notas. 2)listar estudiantes. 3)promedio. 4)ver mejor. 5)ver peor.\n6)listar aprobados. 7)listar reprobados. 8)ver mejores. 9)aplicar bonificacion. 10)buscar. 11)salir. ", 1);
            comprobacion=comprobacionContenido(menu,comprobacion);
            if(comprobacion){
                switch (menu) {
                case 1 ->
                    datos = cargarNotas(estudiantes, notas);
                case 2 ->
                    listar(estudiantes, notas);
                case 3 ->
                    System.out.println("El promedio del curso fue de: "+promedio(notas));
                case 4 ->
                    verMejor(estudiantes, notas);
                case 5->
                    verPeor(estudiantes,notas);
                case 6->
                    listarAprobados(estudiantes,notas);
                case 7->
                    listarReprobados(estudiantes,notas);
                case 8->
                    verMejores(estudiantes,notas,promedio(notas));
                case 9->
                    aplicarBonificacionA(estudiantes,notas,promedio(notas));
                case 10->
                    buscar(estudiantes,notas);
                case 11->
                    System.exit(0);
                }
            }
        }

    }

    //comprobaciones de datos:
    public static int comprobacionFormatoInt(String mensaje, int indiceA) {
        //metodo usado para comprobar el formato y el rango de todo valor numerico entero que se necesite ingresar (numero de estudiantes y menu)
        while (true) {
            try {
                System.out.println(mensaje);
                int indice = sc.nextInt();
                sc.nextLine();
                if (indice < 0) {
                    System.out.println("Debe digitar un dato valido (numero entero mayor que cero).");
                } else if (indiceA == 1) {
                    if (indice > 11) {
                        System.out.println("El numero debe pertencer al rango 1-10");
                    } else {
                        return indice;
                    }
                } else {
                    return indice;
                }
            } catch (Exception e) {
                System.out.println("Digite un dato numerico.");
                sc.nextLine();
            }
        }
    }

    public static Double comprobacionNotas(int i) {
        //para comprobar tanto el formato (Double) como el rango de las notas ingresadas(0-5):
        while (true) {
            try {
                Double nota = sc.nextDouble();
                sc.nextLine();
                if (nota < 0 || nota > 5) {
                    System.out.println("Ingrese una nota valida, rango 0-5.");
                } else {
                    return nota;
                }
            } catch (Exception e) {
                System.out.println("Ingrese un dato numerico.");
                sc.nextLine();
            }
        }
    }

    public static boolean comprobacionContenido(int menu,boolean comprobacion) {
    //comprueba que se hayan ingresado datos de estudiantes antes de hacer cualquier otra operacion del menu.
        if(comprobacion==true){
            return true;
        }
        if (menu==1) {
                return true;
        }
        
        System.out.println("No se a ingresado ningun estudiante: ");
        return false;
    }

    
    //funciones del menu:
    
    /* 
    Para hacer mas corto el codigo todos los metodos que consisten en listar se podrian haber echo un solo metodo
    (listar, listar aprobados, listar reprobados, ver mejores) junto con otros metodos que tienen funciones similares entre si 
    con ifs aprovechando un solo bucle colocando algun valor como indiceA 
    como se hizo en el metodo comprobacionFormatoInt, pero preferi no hacerlo con el fin de que el codigo fuera mucho mas ordenado y legible, ya que de
    esta forma cada funcion del menu tiene su metodo individual.
    */
    
 
    public static Object[][] cargarNotas(String[] estudiantes, Double[] notas) {
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("Ingrese el nombre del estudiante numero: " + (i + 1));
            estudiantes[i] = sc.nextLine();
            System.out.println("Ingrese la nota del estudiante numero: " + (i + 1));
            notas[i] = comprobacionNotas(i);
        }
        Object datos[][] = {estudiantes, notas};
        return datos;
    }

    public static void listar(String[] estudiantes, Double[] notas) {
        System.out.println("Lista de estudiantes y notas:");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("Estudiante: " + estudiantes[i] + ", nota: " + notas[i] + ".");
        }
    }
    
    public static double promedio(Double[] notas) {
        double suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        double promedio = suma / notas.length;
        return promedio;
        
        

    }
          
    public static void verMejor(String[] estudiantes, Double[] notas){
        //eleji hacer el sistema de encontrar el mayor/menor de esta forma ya que si hay varios estudiantes que tengan la nota mas alta/baja muestra a todos los que tengan la nota mas alta/baja.
        for(int i=0;i<estudiantes.length;i++){
            int contador=0;
            for(int t=0; t<estudiantes.length;t++){
                if(notas[i]>=notas[t]){
                    contador++;
                }
                if(contador==estudiantes.length){
                    System.out.println("El estudiante con mayor nota es: "+estudiantes[i]+", con una nota de: "+notas[i]);
                }
            }
        }
            
    }

    public static void verPeor(String[] estudiantes, Double[] notas) {
        for(int i=0;i<estudiantes.length;i++){
            int contador=0;
            for(int t=0; t<estudiantes.length;t++){
                if(notas[i]<=notas[t]){
                    contador++;
                }
                if(contador==estudiantes.length){
                    System.out.println("El estudiante con menor nota es: "+estudiantes[i]+", con una nota de: "+notas[i]);
                }
            }
        }
    }

    public static void listarAprobados(String[] estudiantes, Double[] notas) {
        System.out.println("Lista de estudiantes aprobados:");
        boolean ejecucion=false;
        for (int i = 0; i < estudiantes.length; i++) {
            if (notas[i] >= 3.0) {
                System.out.println("Estudiante: " + estudiantes[i] + ", nota: " + notas[i] + ".");
                ejecucion=true;
            }
        }
        if (ejecucion==false){
            System.out.println("No hay estudiantes aprobados. ");
        }
    }

    public static void listarReprobados(String[] estudiantes, Double[] notas) {
        System.out.println("Lista de estudiantes Reprobados:");
        boolean ejecucion=false;
        for (int i = 0; i < estudiantes.length; i++) {
            if (notas[i] < 3.0) {
                System.out.println("Estudiante: " + estudiantes[i] + ", nota: " + notas[i] + ".");
                ejecucion=true;
            }
        }
        if (ejecucion==false){
            System.out.println("No hay estudiantes reprobados. ");
        }
    }
    
    public static void verMejores(String[] estudiantes, Double[] notas, double promedio){
        boolean ejecucion=false;
        System.out.println("Lista de los estudiantes con notas por encima del promedio:");
        for (int i = 0; i < estudiantes.length; i++) {
            if (notas[i] > promedio ) {
                System.out.println("Estudiante: " + estudiantes[i] + ", nota: " + notas[i] + ".");
                ejecucion=true;
            }
        }
        if (ejecucion==false){
            System.out.println("No hay estudiantes cuyas notas esten por encima del promedio. ");
        }
    }
    
    /* no entendi muy bien que queria decir la orden de la funcion aplicarBonificacion ya que se podria interpretar como que habia que sumar un 1% 
    a las notas con nota mayor que el promedio y luego mostrar todas las notas 
    ó que habia que sumar un 1% a todas las notas y luego mostrar aquellas que quedaran ecima del promedio.
    por eso hay 2 metodos aplicarBonificacion
    */
    public static void aplicarBonificacionA(String[] estudiantes, Double[] notas, double promedio){
        //sumar un 1% a las notas con nota mayor que el promedio y luego mostrar todos los estudiantes y sus notas
        System.out.println("Lista de estudiantes aprobados:");
        for (int i = 0; i < estudiantes.length; i++) {
            if (notas[i] > promedio ) {
                notas[i]=notas[i]+(notas[i]*0.01);
                if(notas[i]>5){
                    notas[i]=5.0;
                }
            }
        }
        listar(estudiantes,notas);
    }
    
    public static void aplicarBonificacionB(String[] estudiantes, Double[] notas, double promedio){
        //sumar un 1% a todas las notas y luego mostrar aquellas que quedaran ecima del promedio.
        for (int i = 0; i < estudiantes.length; i++) {
                notas[i]=notas[i]+(notas[i]*0.01);
                if (notas[i]>5){
                    notas[i]=5.0;
                }
        }
        verMejores(estudiantes,notas,promedio);
    }
    
    public static void buscar(String[] estudiantes, Double[] notas){
        System.out.println("Ingrese el nombre del estudiante: ");
        String nombre=sc.nextLine();
        boolean ejecucion=false;
        for (int i=0;i<estudiantes.length;i++){
            if (estudiantes[i].equals(nombre)){
                System.out.println("Estudiante: "+nombre+", nota: "+notas[i]);
                ejecucion=true;
            }
        }
        if (ejecucion==false){
            System.out.println("No hay coincidencias con la busqueda. ");
        }
    }
}
