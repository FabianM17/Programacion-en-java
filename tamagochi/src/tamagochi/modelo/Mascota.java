/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tamagochi.modelo;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Mascota {

    static Random random = new Random();

    String nombre;
    int energia;
    int felicidad;
    int limpieza;
    double dinero;
    int acciones;
    int salud;
    boolean vivo = true;
    int dia;

    public boolean estado() {
        if (vivo == true) {
            return true;
        } else {
            System.out.println("Esta mascota esta muerta, no puede realizar acciones.");
            return false;
        }
    }

    public void penalizaciones() {
        if (energia == 0) {
            System.out.println("¡" + nombre + " se a desmayado por gastar toda su energia!");
            setEnergia(10);
            int a = limpieza;
            int b = felicidad;
            int c = salud;
            setLimpieza(limpieza - (random.nextInt(11) + 15));
            setFelicidad(felicidad - (random.nextInt(11) + 15));
            setSalud(salud - (random.nextInt(6) + 5));
            System.out.println("Limpieza: -" + (a - limpieza) + ", felicidad: -" + (b - felicidad) + ", salud: -" + (c - salud) + ".");

            acciones = 0;
            penalizaciones();
            System.out.println("Se finalizo el dia: " + dia + ". Acciones realizadas: " + acciones + ".");
            estadisticas();
            dia++;
        }
        if (felicidad == 0) {
            setFelicidad(5);
            System.out.println("!" + nombre + " a entrado en depresion!");
            int a = limpieza;
            int b = energia;
            int c = salud;
            setLimpieza(limpieza - (random.nextInt(11) + 10));
            setEnergia(energia - (random.nextInt(11) + 10));
            setSalud(salud - (random.nextInt(6) + 5));
            System.out.println("Limpieza: -" + (a - limpieza) + ", energia: -" + (b - energia) + ", salud: -" + (c - salud) + ".");

            System.out.println("Acciones realizadas: " + acciones + ".");
            estadisticas();
        }
        if (dinero == 0) {
            setDinero(1);
            System.out.println("Has caido en bancarrota!");
            int a = felicidad;
            setFelicidad(felicidad - (random.nextInt(11) + 10));
            System.out.println("Felicidad: -" + (a - felicidad) + ".");
            System.out.println("Acciones realizadas: " + acciones + ".");
            estadisticas();
        }
        if (limpieza == 0) {
            limpieza = 1;
            int a = energia;
            int b = felicidad;
            int c = salud;

            System.out.println("!" + nombre + " esta muy sucio!");
            setEnergia(energia - (random.nextInt(11) + 10));
            setFelicidad(felicidad - (random.nextInt(11) + 5));
            setSalud(salud - (random.nextInt(6) + 5));
            System.out.println("Energia: -" + (a - energia) + ", felicidad: -" + (b - felicidad) + ", salud: -" + (c - salud) + ".");

            System.out.println("Acciones realizadas: " + acciones + ".");
            estadisticas();
        }
        if (salud == 0) {
            System.out.println("¡" + nombre + " a muerto!");
            vivo = false;
            System.out.println("Tu mascota " + nombre + " sobrevivio: " + dia + " dias.");
            estadisticas();
        }

    }

    public void acciones(int indice1) {
        if (indice1 == 0) {
            acciones++;
        } else {
            acciones = acciones + 2;
        }

        if (acciones == 6) {
            System.out.println("Solo te queda una accion recomendada, recomendamos ir a dormir.");
        }
        if (acciones >= 7) {
            for (int i = 0; true; i++) {
                int indice = random.nextInt(7 - i);
                if (indice == 1 || indice == 0) {
                    System.out.println("Te has excedido!");
                    int a = energia;
                    int b = felicidad;
                    int c = limpieza;
                    int d = salud;
                    setEnergia(energia - (random.nextInt(11) + 10));
                    setFelicidad(felicidad - (random.nextInt(11) + 5));
                    setLimpieza(limpieza - (random.nextInt(11) + 5));
                    setSalud(salud - (random.nextInt(6)));
                    System.out.println("Energia: -" + (a - energia) + ", felicidad: -" + (b - felicidad) + ", limpieza: -" + (c - limpieza) + ", salud: " + (d - salud) + ".");
                    penalizaciones();
                    System.out.println("Se a finalizado el: " + dia + ". Acciones realizadas: " + acciones + ".");
                    estadisticas();
                    dia++;
                    acciones = 0;
                    return;
                }
            }

        }
    }

    public void comer() {
        if (estado()) {
            if (dinero < 8) {
                System.out.println("No has podido comprar la comida por falta de dinero!");
                acciones(0);
            } else {
                int b = energia;
                int c = salud;
                int d = limpieza;
                int e = felicidad;
                setDinero(dinero - 7.5);
                setEnergia(energia + random.nextInt(11) + 10);
                setSalud(salud + random.nextInt(3));
                setLimpieza(limpieza - (random.nextInt(11) + 5));
                setFelicidad(felicidad + random.nextInt(3));
                System.out.println("Dinero: -7.5, energia: +" + (energia - b) + ", salud: +" + (salud - c) + ", limpieza: -" + (d - limpieza) + ", felicidad: +" + (felicidad - e) + ".");
                penalizaciones();
                acciones(0);
                System.out.println("Acciones realizadas: " + acciones + ".");
                estadisticas();
            }
        }

    }

    public void jugar() {
        if (estado()) {
            int a = energia;
            setEnergia(energia - (random.nextInt(11) + 15));
            int b = felicidad;
            setFelicidad(felicidad + random.nextInt(21) + 15);
            int c = limpieza;
            setLimpieza(limpieza - (random.nextInt(21) + 5));
            int d = salud;
            setSalud(salud - (random.nextInt(4)));
            System.out.println("Energia: -" + (a - energia) + ", felicidad: +" + (felicidad - b) + ", limpieza: -" + (c - limpieza) + ", salud: -" + (d - salud) + ".");
            penalizaciones();
            acciones(0);
            System.out.println("Acciones realizadas: " + acciones + ".");
            estadisticas();
        }

    }

    public void ducha() {
        if (estado()) {
            int a = limpieza;
            setLimpieza(limpieza + random.nextInt(31) + 30);
            int b = energia;
            setEnergia(energia - (random.nextInt(6)));
            int c = felicidad;
            setFelicidad(felicidad + random.nextInt(4));
            System.out.println("Limpieza: +" + (limpieza - a) + ", energia: -" + (b - energia) + ", felicidad: " + (felicidad - c) + ".");
            penalizaciones();
            acciones(0);
            System.out.println("Acciones realizadas: " + acciones + ".");
            estadisticas();
        }

    }

    public void trabajar() {
        if (estado()) {
            double a = dinero;
            setDinero(dinero + random.nextDouble(31) + 20);
            int b = energia;
            setEnergia(energia - (random.nextInt(21) + 15));
            int c = limpieza;
            setLimpieza(limpieza - (random.nextInt(21) + 10));
            int d = felicidad;
            setFelicidad(felicidad - (random.nextInt(21) + 10));
            System.out.println("Dinero: +" + (dinero - a) + ", energia: -" + (b - energia) + ", limpieza: -" + (c - limpieza) + ", felicidad: -" + (c - felicidad));
            penalizaciones();
            acciones(1);
            System.out.println("Acciones realizadas: " + acciones + ".");
            estadisticas();
        }

    }

    public void dormir() {
        if (estado()) {
            int a = limpieza;
            setLimpieza(limpieza - random.nextInt(4));
            int b = energia;
            setEnergia(energia + random.nextInt(31) + 40);
            int c = felicidad;
            setFelicidad(felicidad + random.nextInt(11) + 10);
            System.out.println("Limpieza: -" + (a - limpieza) + ", energia: +" + (energia - b) + ", felicidad: +" + (felicidad - c) + ".");
            penalizaciones();
            acciones = 0;
            System.out.println("Se a finalizado el dia: " + dia + ". ");
            estadisticas();
            dia++;
        }

    }

    public void estadisticas() {
        String estado = "";
        if (vivo) {
            estado = "vivo";
        } else {
            estado = "muerto";
        }
        System.out.println("Las estadisticas de " + nombre + " son: Energia: " + energia + ", felicidad: " + felicidad + ", limpieza: " + limpieza + ", dinero: " + Math.round(dinero) + ", salud: " + salud + ", estado: " + estado + ". \n");
    }

    public Mascota(String nombre) {
        this.nombre = nombre;
        this.energia = 70;
        this.felicidad = 60;
        this.limpieza = 70;
        this.salud = 100;
        this.dinero = 30;
        this.acciones = 0;
        this.dia = 1;
        this.vivo = true;
    }

    public void setEnergia(int energia) {
        if (energia > 100) {
            this.energia = 100;
        } else if (energia < 0) {
            this.energia = 0;
        } else {
            this.energia = energia;
        }

    }

    public void setFelicidad(int felicidad) {
        if (felicidad > 100) {
            this.felicidad = 100;
        } else if (felicidad < 0) {
            this.felicidad = 0;
        } else {
            this.felicidad = energia;
        }
    }

    public void setLimpieza(int limpieza) {
        if (limpieza > 100) {
            this.limpieza = 100;
        } else if (limpieza < 0) {
            this.limpieza = 0;
        } else {
            this.limpieza = limpieza;
        }
    }

    public void setDinero(double dinero) {
        if (dinero > 100) {
            this.dinero = 100;
        } else if (dinero < 0) {
            this.dinero = 0;
        } else {
            this.dinero = dinero;
        }
    }

    public void setSalud(int salud) {
        if (salud > 100) {
            this.salud = 100;
        } else if (salud < 0) {
            this.salud = 0;
        } else {
            this.salud = salud;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isVivo() {
        return vivo;
    }

    public int getDia() {
        return dia;
    }

    public int getEnergia() {
        return energia;
    }

    public int getFelicidad() {
        return felicidad;
    }

    public int getLimpieza() {
        return limpieza;
    }

    public double getDinero() {
        return dinero;
    }

    public int getAcciones() {
        return acciones;
    }

    public int getSalud() {
        return salud;
    }

}
