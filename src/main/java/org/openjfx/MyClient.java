/*package org.openjfx;
import java.io.*;
import java.net.*;

public class MyClient {
    public static void main (String[] args) {
        try{
            Socket s=new Socket("localhost",6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("hola servidor");
            dout.flush();
            dout.close();
            s.close();
        }catch (Exception e){
            System.err.println(e);}
        }
    }

*/
