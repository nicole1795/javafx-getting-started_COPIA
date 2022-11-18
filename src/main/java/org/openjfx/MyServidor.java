package org.openjfx;
import java.io.* ;
import java.net.* ;

class MyServer {
    public static void main(String[] args) {
        while (true) {
            try {
               // ServerSocket ss = new ServerSocket(6661);
                Socket ss = new Socket("192.168.32.241", 6669);
                System.out.println("Esperando al cliente..."); // Esperando conexión
                Socket s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String palabras = dis.readUTF();
                System.out.println("mensaje= " + palabras);
                ss.close(); //no lo cierro porque sino no recibe los mensajes
            } catch (Exception e) {
                 System.err.println(e);
               // e.printStackTrace();
            }
        }
    }
}