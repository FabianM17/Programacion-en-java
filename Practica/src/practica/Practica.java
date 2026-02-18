/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Practica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ejercicio1();
    }
    //Sucecion de fibonacci 0 - 50
    public static void ejercicio1(){
        long[] sucecion=new long [50];
        sucecion[0]=0;
        sucecion[1]=1;
        System.out.println(sucecion[0]);
        System.out.println(sucecion[1]);
        for (int i=2;i<50;i++){
            sucecion[i]=sucecion[i-1]+sucecion[i-2];
            System.out.println(sucecion[i]);
        }
    }
    
    public static void ejercicio2(){
    
    }
   
    
}
