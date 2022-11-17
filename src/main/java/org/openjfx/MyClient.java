package org.openjfx;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        while (true) {
            try {
                Socket s = new Socket("localhost", 6661);
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                //dout.writeUTF("0.52"); //envio de datos al server

                Scanner entrada = new Scanner(System.in);
                System.out.print("Introduzca su mensaje: ");
                String mensaje = entrada.nextLine();
                dout.writeUTF(mensaje);
                //System.out.println("¡Hola " + nombre + "!");
                dout.flush();
                dout.close();
                s.close();
                /*     crear un if para cerrar la conexion desde el cliente
                if (entrada.equals("off")){
                        dout.flush();
                        dout.close();
                        s.close();}
                                else {
                                    String mensaje = entrada.nextLine();
                                    dout.writeUTF(mensaje);
                                    //System.out.println("¡Hola " + nombre + "!");
                                    dout.flush();
                        }
*/
            }
            catch (Exception e) {
                System.err.println(e);
            }
        }
    }

}
