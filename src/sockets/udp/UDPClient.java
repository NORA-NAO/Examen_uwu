/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.udp;

/**
 *
 * @author Eda
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UDPClient {
 
    public static void main(String[] args) throws UnknownHostException, IOException {
         
        System.out.println("Cliente Conectado\n");
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost"); //si es un servicio en linea se necesita poner la dirección IP en vez de "localhost"
        byte[] sendData, sendData1;
        hilo hi = new hilo();
        hi.start();
        boolean shi= true;
    
        
        
        while(shi){
            System.out.println("Desea enviar un mensaje? si = 1 /no = 2");
            sendData = new byte[1024];
            sendData1 = new byte[1024];
            String sentence= inFromUser.readLine();
            Pattern pa = Pattern.compile("^\\d+$");
            Matcher txt = pa.matcher(sentence);
            
            
            if (sentence.equals("1")) {
                if(txt.matches()==true) { 
                System.out.println("Ingresa p:\n");
                String p = inFromUser.readLine();
                 
                BigInteger  p1 =new BigInteger(p);
                System.out.println("Ingresa q:\n");
                String q = inFromUser.readLine();
                 
                BigInteger q1 =new BigInteger(q);
                RSA rsa = new RSA(p1,q1);
                rsa.generarClaves(p1,q1);
                sendData =  p.getBytes();
                sendData1 = q.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
                DatagramPacket sendPacket1 = new DatagramPacket(sendData1, sendData1.length, IPAddress, 9876);
                clientSocket.send(sendPacket);
                clientSocket.send(sendPacket1);
            
            } else{
                System.out.println("Ingresa caracteres Numericos, Por favor :3");
            }
          }else{
            
                System.exit(0);
          }
      
           /*if (sentence.equals("/^[0-9]$/")) {
               shi=false;
               System.out.println("adiooooooooo");
           }else if(sentence.equalsIgnoreCase("sho")){
                   shi = true;
                   System.out.println("efectivamente puso sho");
           } */
   
       } clientSocket.close();
        
       
    }
}

