package org.openjfx;
import java.io.* ;
import java.net.* ;

class MyServer {
    public static void main(String[] args) {
        while (true) {
            try {
                ServerSocket ss = new ServerSocket(6661);
                System.out.println("Esperando al cliente..."); // Esperando conexión
                Socket s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String palabras = (String) dis.readUTF();
                System.out.println("mensaje= " + palabras);
                ss.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}