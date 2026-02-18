/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taller3;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Taller3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ejercicio3();
    }
    
        public static Double comprobacionDouble(String mesaje){
            while (true){
                String entrada=JOptionPane.showInputDialog(mesaje);
                if (entrada==null){
                    System.exit(0);
                }
                try{
                    double decimal=Double.parseDouble(entrada);
                    if (decimal<1){
                        JOptionPane.showMessageDialog(null, "No puede ingresar numeros negativos");
                        continue;
                    }
                    return decimal;
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un valor numerico.");
                }
            }
        }
        
        public static Integer comprobacionInt(String mesaje){
            while (true){
                String entrada=JOptionPane.showInputDialog(mesaje);
                if (entrada==null){
                    System.exit(0);
                }
                try{
                    int entero=Integer.parseInt(entrada);
                    if (entero<1){
                        JOptionPane.showMessageDialog(null, "Ingrese un valor mayor que cero.");
                        continue;
                    }
                    return entero;
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ingrese un numero entero.");
                }
            }
        }
        
        public static Double comprobacionNota(String mesaje){
            while(true){
                double nota=comprobacionDouble(mesaje);
                if (nota>5){
                    JOptionPane.showMessageDialog(null, "Dato fuera de rango (0-5).");
                }else{
                return nota;
                }
            }
        }
    
    public static void ejercicio1(){
        String[] opciones={"Saludar","Despedirse","Salir"};
        int menu=JOptionPane.showOptionDialog(null, "Seleccione una de las opciones:", "Menu de Opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (menu==0){
            JOptionPane.showMessageDialog(null, "Hola!.");
        }else if(menu==1){
            JOptionPane.showMessageDialog(null, "Adios.");
        }else if(menu==2){
            System.exit(0);
        }
    }
    
    public static void ejercicio2(){
        String[] opciones={"Cuadrado","Circulo","Triangulo","Rectangulo","Salir"};
        int menu=JOptionPane.showOptionDialog(null, "Seleccione la figura a calcular su area:", "Calculo de area.", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        switch (menu){
            case 0:
                double lado=comprobacionDouble("Ingrese el tamaño de un lado del cuadrado.");
                double area_cuadrado=lado*lado;
                JOptionPane.showMessageDialog(null, "El area del cuadrado es de: "+area_cuadrado+" unidades.");
                break;
            case 1:
                double radio=comprobacionDouble("Ingrese el tamaño del radio del circulo.");
                double area_circulo=((radio*radio)*Math.PI);
                JOptionPane.showMessageDialog(null, "El area del circulo es de: "+area_circulo+" unidades.");
                break;
            case 2:
                double base_triangulo=comprobacionDouble("Ingrese el tamaño de la base del triangulo.");
                double altura_triangulo=comprobacionDouble("Ingrese el tamaño de la altura del triangulo.");
                double area_triangulo=(altura_triangulo*base_triangulo)/2;
                JOptionPane.showMessageDialog(null, "El area del triangulo es de: "+area_triangulo+" unidades.");
                break;
            case 3:
                double base_rectangulo=comprobacionDouble("Ingrese el tamaño de la base del rectangulo.");
                double altura_rectangulo=comprobacionDouble("Ingrese el tamaño de la altura del rectangulo.");
                double area_rectangulo=(altura_rectangulo*base_rectangulo);
                JOptionPane.showMessageDialog(null, "El area del triangulo es de: "+area_rectangulo+" unidades.");
                break;
            case 4:
                System.exit(0);
        }
    
    
    
    }
    
    public static void ejercicio3(){
        int estudiantes = comprobacionInt("Ingrese el numero de estudiantes totales");
        Object[][] datos = new Object[estudiantes][4];
        boolean datosRegistrados = false;
        while (true){

            String[] opciones = {
                "Registro de notas.",
                "Promedio de materia",
                "Promedio de estudiante",
                "Estudiantes aprobados/reprobados",
                "Salir"
            };

            String[] opciones_promedio_materia = {
                "Matematicas",
                "Ingles",
                "Español",
                "Salir"
            };

            int menu = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione la opcion a realizar:",
                    "Editor de notas.",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            switch (menu){
                // registro de notas
                case 0:
                    for (int i = 0; i < estudiantes; i++){
                        datos[i][0] = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
                        datos[i][1] = comprobacionNota("Ingrese la nota de Matematicas.");
                        datos[i][2] = comprobacionNota("Ingrese la nota de Ingles.");
                        datos[i][3] = comprobacionNota("Ingrese la nota de Español.");
                    }
                    datosRegistrados = true;
                    JOptionPane.showMessageDialog(null, "Datos registrados correctamente.");
                    break;

                // Promedio por materia
                case 1:

                    if (!datosRegistrados){
                        JOptionPane.showMessageDialog(null, "Primero debe registrar datos.");
                        break;
                    }
                    int materia = JOptionPane.showOptionDialog(null,"Seleccione la materia:","Promedio por materia",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones_promedio_materia,opciones_promedio_materia[0]);
                    if (materia == 3) break;
                    double suma = 0;
                    for (int i = 0; i < estudiantes; i++){
                        suma += (double) datos[i][materia + 1];
                    }
                    double promedio = suma / estudiantes;
                    JOptionPane.showMessageDialog(null,"El promedio es: " + promedio);
                    break;
                // Promedio por estudiante
                case 2:
                    if (!datosRegistrados){
                        JOptionPane.showMessageDialog(null, "Primero debe registrar datos.");
                        break;
                    }
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
                    int posicion = -1;
                    for (int i = 0; i < estudiantes; i++){
                        if (datos[i][0].equals(nombre)){
                            posicion = i;
                            break;
                        }
                    }
                    if (posicion == -1){
                        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
                        break;
                    }
                    double sumaEst = 0;
                    for (int i = 1; i < 4; i++){
                        sumaEst += (double) datos[posicion][i];
                    }
                    double promedioEst = sumaEst / 3;
                    JOptionPane.showMessageDialog(null,"El promedio del estudiante es: "+promedioEst);
                    break;
                // numero de aprobados y desaprobados
                case 3:
                    if (!datosRegistrados){
                        JOptionPane.showMessageDialog(null, "Primero debe registrar datos.");
                        break;
                    }
                    int mat = JOptionPane.showOptionDialog(null,"Seleccione la materia:","Aprobados/Reprobados",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones_promedio_materia,opciones_promedio_materia[0]
                    );
                    if (mat == 3) break;
                    int aprobados = 0;
                    for (int i = 0; i < estudiantes; i++){
                        if ((double) datos[i][mat + 1] >= 3){
                            aprobados++;
                        }
                    }
                    int reprobados = estudiantes-aprobados;
                    JOptionPane.showMessageDialog(null,"Aprobados: " + aprobados+". Reprobados: " + reprobados);
                    break;
                case 4:
                    System.exit(0);
            }
        }
}

    
    
}
