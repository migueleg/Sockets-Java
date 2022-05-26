/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio_sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MG
 */
public class ServidorHilo extends Thread {
    
    private DataInputStream in;
    private DataOutputStream out;
    private String nombreCliente;
    
    public ServidorHilo(DataInputStream in, DataOutputStream out, String nombreCliente) {
        this.in = in;
        this.out = out;
        this.nombreCliente = nombreCliente;
    }
    
    @Override
    public void run() {
        
        int opcion;
        
        while (true) {
            
            try {
                opcion = in.readInt();
                switch (opcion) {
                    case 1:
                        out.writeUTF("Trabajando en ello...");
                    
                        break;
                    
                    case 2:
                        break;
                    
                    case 3:
                        break;
                    
                    case 4:
                        break;
               
                    default:
                        out.writeUTF("Solo numero del 1 al 4");
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
 
    
    
    
}
