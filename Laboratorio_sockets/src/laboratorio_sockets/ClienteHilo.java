package laboratorio_sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import javax.swing.JOptionPane;

public class ClienteHilo extends Thread {

    private DataInputStream in;
    private DataOutputStream out;

    public ClienteHilo(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {

        Scanner sn = new Scanner(System.in);

       
        int opcion = 0;
        boolean salir = false;

        while (!salir) {

            try {
                System.out.println("1. Dado un vector de n posiciones, ordenarlo de manera ascendente usando el algoritmo de mergesort");
                System.out.println("2. Dado un vector de n posiciones, ordenarlo de manera ascendente usando el algoritmo de heapsort");
                System.out.println("3. Dado un vector de n posiciones, ordenarlo de manera ascendente usando el algoritmo de quicksort.");
                System.out.println("4. Salir");

                opcion = sn.nextInt();
                out.writeInt(opcion);

                switch (opcion) {
                    case 1:
                        int vector[], n, pos, aux;
                        
                        n = Integer.parseInt(JOptionPane.showInputDialog("Dígite el número de elementos del vector"));
                        
                        vector = new int[n];
                        
                        System.out.println("El vector original es: ");
                        for (int i = 0; i<n; i++) { 
                            vector[i] = new Random().nextInt(50);
                            System.out.print(vector[i]+" "); 
                            
                        }
                        
                        //Ordenamiento heapsort
                        for (int i=0; i<n; i++) {
                            pos = i;
                            aux = vector[i];
                            
                            while((pos>0) && (vector[pos-1] > aux)) {
                                vector[pos] = vector[pos-1];
                                pos--;
                            }
                            vector[pos] = aux;
                        }
                        
                        System.out.println("\nVector ordenado en forma ascendente");
                        for (int i=0; i<n; i++) {
                            System.out.print(vector[i]+ " ");
                        }
                        System.out.println("");
                        

                        
                        break;
                    case 2:

                        break;
                    case 3:
                        
        
        
                        

    }
    
    public static void imprimeArreglo(int[] arreglo) {
  
        imprimeArreglo(arreglo);
        
                        quicksort(arreglo, 0, 9);
                
                        imprimeArreglo(arreglo);
    
        for(int i = 0 ; i < arreglo.length ; i++) {
            System.out.print(arreglo[i]+" ");
        }
        System.out.println("");
        System.out.println("___________________");
        System.out.println("");
    
    }
    
    public static void quicksort(int[] arreglo, int izq, int der) {
    
        
        int pivote = arreglo[izq];
       
        int i = izq;
        int j = der;
        int swap;
       
        while(i < j) {
            
            while(arreglo[i] <= pivote && i < j) {
                i++;
            }
            
            while(arreglo[j] > pivote) {
                j--;
            }
            
            if(i < j) {
                swap = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = swap;
                
                imprimeArreglo(arreglo);
            }
        }
        arreglo[izq] = arreglo[j];
        arreglo[j] = pivote;
        
        if(izq < j - 1) {
            quicksort(arreglo, izq, j - 1);
        }
        if(j + 1 < der) {
            quicksort(arreglo, j + 1, der);
        }
    }
    
                       
                        break;
                    case 4:

                        break;
                    default:
                        System.out.println("\nPor favor ingrese una opción valida\n");
                        mensaje = in.readUTF();
                        System.out.println(mensaje);

                }
                while (opcion != 4);
            } catch (IOException ex) {
                Logger.getLogger(ClienteHilo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    
}
