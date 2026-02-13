/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taller1;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Taller1 {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        ejercicio5();
    }
    
    public static void ejercicio1(){
        float[] notas= new float[5];

        for (int i=0; i<5; i++){
            boolean valido=true;
            while (valido){
                try{
                    String entrada=JOptionPane.showInputDialog("Ingrese la nota numero "+(i+1)+":");
                    if (entrada==null){
                        System.exit(0);
                    }
                    notas[i]=Float.parseFloat(entrada);
                    valido=false;
                }
                catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                }
            }    
        }
        float promedio=(notas[0]+notas[1]+notas[2]+notas[3]+notas[4])/5;
        JOptionPane.showMessageDialog(null, "Su promedio es de: "+promedio);
    }
    
    public static void ejercicio2(){
        float[] notas=new float[3];
        String[] indice=new String[3];
            indice[0]="de parciales (55%):";
            indice[1]="de quizes (30%):";
            indice[2]="de trabajo final (15%):";
        for (int i=0; i<3; i++){
            boolean valido=true;
            while (valido){
                try{
                    String entrada=JOptionPane.showInputDialog("Ingrese la nota "+indice[i]);
                    if (entrada==null){System.exit(0);}
                    notas[i]=Float.parseFloat(entrada);
                        if (notas[i]<0||notas[i]>5){
                            JOptionPane.showMessageDialog(null, "ingrese un numero entre 1 y 5:");
                        }else{valido=false;}
                }
                catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                }
            }    
        }
        float calificacionfinal=(float) ((notas[0]*0.55)+(notas[1]*0.3)+(notas[2]*0.15));
        JOptionPane.showMessageDialog(null,"su calificacion final es de: "+calificacionfinal);
    }
    
    public static void ejercicio3(){
    String nombre=JOptionPane.showInputDialog("Ingrese su nombre:");
    float horas=Datos("Ingrese la cantidad de horas trabajadas. ");
    float pago=Datos("Ingrese el pago por hora. ");
    float resultado=(horas*pago);
    JOptionPane.showMessageDialog(null,nombre+" su pago es de $"+resultado);
    }
        //Funcion usada en el ejercicio 3
        public static float Datos(String mesaje){
        while (true){
            String dato=JOptionPane.showInputDialog(mesaje);
            if (dato==null){System.exit(0);}
                try{
                float info=Float.parseFloat(dato);
                if (info<0){
                JOptionPane.showMessageDialog(null, "No puede ingresar numeros negativos");
                } else {return info;} 
                }catch(NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                }
            
                
            
        }
    }

    public static void ejercicio4(){
        while (true){
            try{
                String numero=JOptionPane.showInputDialog("Ingrese su numero a verificar.");
                if (numero==null){
                    System.exit(0);
                }
                int numero1=Integer.parseInt(numero);
                float residuo=numero1%2;
                if (residuo==0){
                    JOptionPane.showMessageDialog(null, "El numero ingresado es par.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "El numero ingresado es impar.");
                }
                break;
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Debe ingresar un numero entero. ");
            }
        }
    }

    public static void ejercicio5(){
        float[] numero=new float[3];
        float[] resultado=new float[3];
        for (int i=0;i<3;i++){
            numero[i]=verificar("Ingrese el dato #"+(i+1));
        }
        resultado[0]=(numero[0]+numero[1]);
        resultado[1]=(numero[1]+numero[2]);
        resultado[2]=(numero[0]+numero[2]);
        boolean verif=false;
        for (int i=0;i<3;i++){
            for (int x=0;x<3;x++){
                if (resultado[i]==numero[x]){
                    JOptionPane.showMessageDialog(null, "El numero "+resultado[i]+" es la suma de los otros 2 numeros.");
                    verif=true;
                    break;
                }
            }
        }
        if (verif==false){JOptionPane.showMessageDialog(null,"Ninguno de los numeros ingresados es la suma de los otros 2 numeros.");}
    }
        //Funcion usada en el ejercicio 5
        public static float verificar(String mesaje){
        while (true){
            String numero=JOptionPane.showInputDialog(mesaje);
            if (numero==null){System.exit(0);}
            try{
                float dato=Float.parseFloat(numero);
                return dato;
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingrese un dato numerico.");
            }

        }
        
    }
}


