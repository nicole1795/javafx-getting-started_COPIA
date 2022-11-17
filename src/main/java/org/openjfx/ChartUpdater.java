package org.openjfx;

import javafx.application.Platform;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChartUpdater extends Thread {
    private static MyChart myChart;
    public ChartUpdater(MyChart myChart) {

        this.myChart = myChart;
    }
   // @Override
    public static void main(String[] args) {
        while (true) {
        try {
            ServerSocket ss = new ServerSocket(6663);
            Socket s = ss.accept(); // conexiones establecidas
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println("message= " + str);
            Thread updater = new Thread(new Runnable() {
                @Override
                public void run() {
                    myChart.agregarvalor(Double.valueOf(str));
                }
            });
            ss.close();
            Platform.runLater(updater);
            } catch(Exception e){
                System.err.println(e);
            }
        }

    }
}





