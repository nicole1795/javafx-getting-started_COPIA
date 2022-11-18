package org.openjfx;

import javafx.application.Platform;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChartUpdater extends Thread {
    private static MyChart myChart;
    public ChartUpdater(MyChart myChart) {

        ChartUpdater.myChart = myChart;
    }
   // @Override
    public static void main(String[] args) {
        while (true) {
        try {
            ServerSocket ss = new ServerSocket(6667);
           // System.out.println("Esperando al cliente..."); // Esperando conexión
            Socket s = ss.accept(); // conexiones establecidas
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println("message= " + str);
            Thread  updater = new Thread(new Runnable(){
                @Override
                public void run() { myChart.agregarvalor(Double.valueOf(str));}
            });
            Platform.runLater(updater);
            ss.close();
        } catch(Exception e){
            e.printStackTrace(); // System.err.println(e);
            }
        }

    }
}





