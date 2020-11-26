/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.udp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eda
 */
public class UDPServer {
     
    public static void main(String args[]) throws Exception{
        
        System.out.println("Servidor");
       
         
        
        
        
        while(true){
        DatagramSocket serverSocket = new DatagramSocket(9876);    
        byte[] receiveData;
        byte[] sendData;
        ArrayList<String> clientes = new ArrayList<String>();
        while(true){
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            System.out.println("Mensaje Recibido:"+sentence);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            clientes.add(Integer.toString(port));
            
            
                for (int i = 0; i < clientes.size(); i++) {
                    String capitalizedSentence = "Cliente:"+sentence ;
                    sendData = capitalizedSentence.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, Integer.parseInt(clientes.get(i)));
                    serverSocket.send(sendPacket);
                }
              
                
            }
                  
        }
    }
    
}
 

