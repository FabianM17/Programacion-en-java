/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taller4;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class Taller4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ejercicio1();
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
    
    public static void ejercicio1() {

        int capacidad = comprobacionInt("Ingrese el numero maximo de estudiantes");
        Object[][] datos = new Object[capacidad][2]; // [][0]=nombre, [][1]=telefono
        int contador = 0;
        while (true) {
            String[] opciones = {
                "Registrar estudiante",
                "Consultar estudiante",
                "Modificar nombre estudiante",
                "Modificar telefono estudiante",
                "Eliminar estudiante",
                "Imprimir listado",
                "Salir"
            };
            int menu = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione la opcion:",
                    "Gestion de estudiantes",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            switch (menu) {
                case 0:
                    if (contador >= capacidad) {
                        JOptionPane.showMessageDialog(null, "No hay mas espacio.");
                        break;
                    }
                    String nombre = JOptionPane.showInputDialog("Ingrese nombre:");
                    String telefono = JOptionPane.showInputDialog("Ingrese telefono:");
                    datos[contador][0] = nombre;
                    datos[contador][1] = telefono;
                    contador++;
                    JOptionPane.showMessageDialog(null, "Estudiante registrado.");
                    break;
                case 1:
                    String buscar = JOptionPane.showInputDialog("Ingrese nombre a consultar:");
                    int pos = -1;
                    for (int i = 0; i < contador; i++) {
                        if (datos[i][0].equals(buscar)) {
                            pos = i;
                            break;
                        }
                    }
                    if (pos == -1) {
                        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Nombre: " + datos[pos][0] +
                                "\nTelefono: " + datos[pos][1]);
                    }
                    break;
                case 2:
                    String nombreMod = JOptionPane.showInputDialog("Ingrese nombre actual:");
                    int posMod = -1;
                    for (int i = 0; i < contador; i++) {
                        if (datos[i][0].equals(nombreMod)) {
                            posMod = i;
                            break;
                        }
                    }
                    if (posMod == -1) {
                        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
                    } else {
                        String nuevoNombre = JOptionPane.showInputDialog("Ingrese nuevo nombre:");
                        datos[posMod][0] = nuevoNombre;
                        JOptionPane.showMessageDialog(null, "Nombre actualizado.");
                    }
                    break;
                case 3:
                    String nombreTel = JOptionPane.showInputDialog("Ingrese nombre:");
                    int posTel = -1;
                    for (int i = 0; i < contador; i++) {
                        if (datos[i][0].equals(nombreTel)) {
                            posTel = i;
                            break;
                        }
                    }
                    if (posTel == -1) {
                        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
                    } else {
                        String nuevoTel = JOptionPane.showInputDialog("Ingrese nuevo telefono:");
                        datos[posTel][1] = nuevoTel;
                        JOptionPane.showMessageDialog(null, "Telefono actualizado.");
                    }
                    break;
                case 4:
                    String nombreEliminar = JOptionPane.showInputDialog("Ingrese nombre a eliminar:");
                    int posEliminar = -1;
                    for (int i = 0; i < contador; i++) {
                        if (datos[i][0].equals(nombreEliminar)) {
                            posEliminar = i;
                            break;
                        }
                    }
                    if (posEliminar == -1) {
                        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
                    } else {
                        for (int i = posEliminar; i < contador - 1; i++) {
                            datos[i][0] = datos[i + 1][0];
                            datos[i][1] = datos[i + 1][1];
                        }
                        contador--;
                        JOptionPane.showMessageDialog(null, "Estudiante eliminado.");
                    }
                    break;
                case 5:
                    if (contador == 0) {
                        JOptionPane.showMessageDialog(null, "No hay estudiantes registrados.");
                        break;
                    }
                    String listado = "LISTADO DE ESTUDIANTES\n\n";
                    for (int i = 0; i < contador; i++) {
                        listado += "Nombre: " + datos[i][0] +". Telefono: " + datos[i][1] + "\n";
                    }
                    JOptionPane.showMessageDialog(null, listado);
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
    
    public static void ejercicio2() {
        int totalBoletas = comprobacionInt("Ingrese la cantidad total de boletas disponibles:");
        int disponibles = totalBoletas;
        int capacidad = 100;
        Object[][] datos = new Object[capacidad][2];
        int contador = 0;
        while (true) {
            if (disponibles == 0) {
                JOptionPane.showMessageDialog(null, "Boletas agotadas. Programa finalizado.");
                System.exit(0);
            }
            String cedula = JOptionPane.showInputDialog("Boletas disponibles: " + disponibles +"\nIngrese numero de cedula:"
            );
            int posicion = -1;
            for (int i = 0; i < contador; i++) {
                if (datos[i][0].equals(cedula)) {
                    posicion = i;
                    break;
                }
            }
            if (posicion == -1) {
                int cantidad = comprobacionInt("¿Cuantas boletas desea comprar? (Max 4)");
                if (cantidad > 4) {
                    JOptionPane.showMessageDialog(null, "No puede comprar mas de 4 boletas.");
                    continue;
                }
                if (cantidad > disponibles) {
                    JOptionPane.showMessageDialog(null, "No hay suficientes boletas disponibles.");
                    continue;
                }
                datos[contador][0] = cedula;
                datos[contador][1] = cantidad;
                contador++;
                disponibles -= cantidad;
            } 
            else {
                int compradas = (int) datos[posicion][1];
                if (compradas == 4) {
                    JOptionPane.showMessageDialog(null, "Ya alcanzo el limite maximo de 4 boletas.");
                    continue;
                }
                int restantesPermitidas = 4 - compradas;
                int cantidadNueva = comprobacionInt("Ya tiene " + compradas + " boletas.\nPuede comprar maximo " +restantesPermitidas + "\n¿Cuantas desea comprar?"
                );
                if (cantidadNueva > restantesPermitidas) {
                    JOptionPane.showMessageDialog(null, "Supera el limite permitido.");
                    continue;
                }
                if (cantidadNueva > disponibles) {
                    JOptionPane.showMessageDialog(null, "No hay suficientes boletas disponibles.");
                    continue;
                }
                datos[posicion][1] = compradas + cantidadNueva;
                disponibles -= cantidadNueva;
            }
            JOptionPane.showMessageDialog(null,"Venta realizada con exito." + "\nTotal vendidas: " + (totalBoletas - disponibles) +"\nBoletas disponibles: " + disponibles);
        }
    }
    
}
