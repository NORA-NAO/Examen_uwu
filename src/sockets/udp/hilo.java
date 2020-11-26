/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Eda
 */
public class hilo extends Thread{
    public hilo(){
        
        
        
        
    }
    
    
    
    public void run(){
    try{
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] reciveData;
            byte[] sendData = new byte[1024];
            String sentence = new String();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            clientSocket.send(sendPacket);
            while(true){
                reciveData = new byte[1024];
                DatagramPacket recivePacket = new DatagramPacket(reciveData, reciveData.length);
                clientSocket.receive(recivePacket);
                String modifiedSentence = new String(recivePacket.getData());
                System.out.println(modifiedSentence);
            }
            
        }catch(Exception e){
            System.out.println("Nooooooo error :ccc");
            
        }
    }
    
    
}
