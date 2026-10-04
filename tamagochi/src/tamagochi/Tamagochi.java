/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tamagochi;
import tamagochi.modelo.Mascota;
import java.util.Scanner;
import java.util.ArrayList;

public class Tamagochi {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        menu(mascotas);
    }

    public static void menu(ArrayList<Mascota> mascotas) {
        while (true) {
            System.out.println("Ingrese la accion a realiar: 1)Jugar. 2)Crear mascota. 3)Editar mascota. 4)Eliminar mascota. 5)listar mascotas. 6)instrucciones. 7)salir.");
            int indice = sc.nextInt();
            sc.nextLine();
            switch (indice) {
                case 1 -> {
                    if (mascotas.size() != 0) {
                        jugar(mascotas);
                    } else {
                        System.out.println("Debe crear primero una mascota antes de poder jugar");
                    }
                }
                case 2 -> {
                    crearMascota(mascotas);
                }
                case 3 -> {
                    if (mascotas.size() != 0) {
                        editarMascota(mascotas);
                    } else {
                        System.out.println("Debe crear primero una mascota.");
                    }
                }
                case 4 -> {
                    if (mascotas.size() != 0) {
                        eliminarMascota(mascotas);
                    } else {
                        System.out.println("Debe crear primero una mascota.");
                    }
                }
                case 5 -> {
                    if (mascotas.size() != 0) {
                        listarMascotas(mascotas);
                    } else {
                        System.out.println("No hay mascotas registradas.");
                    }
                }
                case 6 -> {
                    instrucciones();
                }
                case 7 -> {
                    System.exit(0);
                }
            }

        }

    }

    public static void jugar(ArrayList<Mascota> mascotas) {
        System.out.println("Digite el id de la mascota, si no lo sabe revise el registro (opcion 5)");
        int id = sc.nextInt();
        sc.nextLine();
        if (id > (mascotas.size() - 1) || (mascotas.get(id) == null)) {
            System.out.println("No hay ninguna mascota registrada con esa id.");
        } else {
            System.out.println("¿Iniciar el juego como la mascota: " + mascotas.get(id).getNombre() + ", id: " + id + "?");
            System.out.println("Digite 1 para inicar el juego, presione 2 para volver al menu de inicio");
            int indice = sc.nextInt();
            if (indice == 1) {
                menuJuego(mascotas.get(id));
            } else if (indice == 2) {
                return;
            }
        }

    }

    public static void crearMascota(ArrayList<Mascota> mascotas) {
        System.out.println("Digite el nombre de la nueva mascota.");
        String nombre = sc.nextLine();
        mascotas.add(new Mascota(nombre));
        System.out.println("La mascota " + nombre + " fue registrada, se le asigno el id: " + (mascotas.size() - 1) + ".");
    }

    public static void eliminarMascota(ArrayList<Mascota> mascotas) {
        System.out.println("Digite el id de la mascota a eliminar, si no lo sabe revise el registro (opcion 5)");
        int id = sc.nextInt();
        sc.nextLine();
        if ((id > (mascotas.size() - 1)) || (mascotas.get(id) == null)) {
            System.out.println("No hay ninguna mascota registrada con esa id.");
        } else {
            mascotas.set(id, null);
            System.out.println("La mascota se elimino correctamente");
        }

    }

    public static void editarMascota(ArrayList<Mascota> mascotas) {
        System.out.println("Digite el id de la mascota a editar, si no lo sabe revise el registro (opcion 5)");
        int id = sc.nextInt();
        sc.nextLine();
        if ((id > (mascotas.size() - 1)) || (mascotas.get(id) == null)) {
            System.out.println("No hay ninguna mascota registrada con esa id.");
        } else {
            System.out.println("Ingrese el nuevo nombre de la mascota, nombre anterior " + mascotas.get(id).getNombre());
            String nombre = sc.nextLine();
            mascotas.get(id).setNombre(nombre);
            System.out.println("El nombre de la mascota se edito correctamente.");
        }
    }

    public static void listarMascotas(ArrayList<Mascota> mascotas) {
        for (int i = 0; i < mascotas.size(); i++) {
            if (mascotas.get(i) != null) {
                System.out.print("ID: " + i+". ");
                mascotas.get(i).estadisticas();
            }
        }
    }

    public static void menuJuego(Mascota mascota) {
        while (true) {
            System.out.println("Digite la accion a realizar: 1)Comer. 2)Ducharse. 3)Jugar. 4)Trabajar. 5)Dormir. 6)Estadisticas. 7)Salir.");
            int indice = sc.nextInt();
            sc.nextLine();
            switch (indice) {
                case 1 -> {
                    mascota.comer();
                }
                case 2 -> {
                    mascota.ducha();
                }
                case 3 -> {
                    mascota.jugar();
                }
                case 4 -> {
                    mascota.trabajar();
                }
                case 5 -> {
                    mascota.dormir();
                }
                case 6 -> {
                    mascota.estadisticas();
                    mascota.getDia();
                }
                case 7 -> {
                    return;
                }

            }
        }

    }

    //este texto se lo pedi al chatgpt, me dio pereza escribir las instrucciones a mano.
    public static void instrucciones() {
        System.out.println("""
            
            ==================== INSTRUCCIONES ====================
            
            ¡Bienvenido!
            Tu objetivo es cuidar a tus mascotas y mantenerlas con vida
            el mayor tiempo posible.
            
            ESTADÍSTICAS:
            - Energia: indica qué tan descansada está tu mascota.
            - Felicidad: indica qué tan feliz está.
            - Limpieza: indica qué tan limpia está.
            - Salud: si llega a 0, tu mascota muere.
            - Dinero: se utiliza principalmente para comprar comida.
            
            ACCIONES:
            
            [1] COMER
            - Cuesta $7.5.
            - Aumenta la energía y la salud.
            - Aumenta ligeramente la felicidad.
            - Disminuye la limpieza.
            - Consume 1 acción.
            
            [2] JUGAR
            - Aumenta bastante la felicidad.
            - Disminuye la energía y la limpieza.
            - Puede disminuir ligeramente la salud.
            - Consume 1 acción.
            
            [3] DUCHA
            - Aumenta bastante la limpieza.
            - Consume un poco de energía.
            - Aumenta ligeramente la felicidad.
            - Consume 1 acción.
            
            [4] TRABAJAR
            - Te da dinero.
            - Consume bastante energía.
            - Disminuye la limpieza y la felicidad.
            - Consume 2 acciones.
            
            [5] DORMIR
            - Recupera bastante energía.
            - Aumenta la felicidad.
            - Puede disminuir ligeramente la limpieza.
            - Finaliza el día y reinicia las acciones.
            
            ACCIONES Y DÍAS:
            - Cada día tienes un número limitado de acciones.
            - Trabajar consume 2 acciones; las demás acciones consumen 1.
            - Si te excedes realizando acciones, recibirás penalizaciones.
            - Dormir permite finalizar el día voluntariamente.
            
            PENALIZACIONES:
            - Si la energía llega a 0, la mascota se desmaya.
            - Si la felicidad llega a 0, entra en depresión.
            - Si el dinero llega a 0, entras en bancarrota.
            - Si la limpieza llega a 0, la mascota estará muy sucia.
            - Estas situaciones pueden reducir otras estadísticas.
            - Si la salud llega a 0, la mascota muere.
            
            CONSEJO:
            ¡Equilibra tus acciones! No te concentres solamente en una
            estadística y recuerda descansar antes de quedarte sin energía.
            
            ===========================================================
            """);
    }
}
