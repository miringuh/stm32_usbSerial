package org.example;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

import java.io.IOException;
import java.util.ArrayList;


public class jserial {
    String portFile;
    int baud;
    SerialPort port;
    ArrayList<Character>uart=new ArrayList<>();

    public jserial(String portfile,int baud){
        this.portFile=portfile;
        this.baud=baud;
    }
    public void serialInit(){
        port=SerialPort.getCommPort(this.portFile);
        port.setComPortParameters(baud, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        port.setComPortTimeouts(SerialPort.TIMEOUT_NONBLOCKING, 100, 100);
//    port.setFlowControl(SerialPort.FLOW_CONTROL_CTS_ENABLED);
        if (!port.openPort()) {
            System.out.println("Failed to open port.");
            return;
        }
        System.out.println("Port opened. Listening for data.......");
    }
    public char set2Hex(char val){
        char value=0;
        if ((val >= 48) & (val <= 57)) // 0....9
        {
            value = (char) (val - 48);
        }
        if ((val >= 65) & (val <= 70)) // A....F
        {
            value = (char) (val - 55);
        }
        return value;
    }
    public void getSerial(SerialPort port){
        port.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                // Listen for incoming data only
                return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
            }
            public void serialEvent(SerialPortEvent event) {
                byte[] newData = event.getReceivedData();
                String received = new String(newData);
                char[] charArray = received.toCharArray();
//                byte[] bytes = received.getBytes();
                for(char val:charArray){
                    uart.add( val);
                    System.out.print(val+" ");
                }
            }
        });
        System.out.println();

    }
                  ///// SERIAL WRITE ////
    public void serialComm(String val){
        Thread thread= new Thread();
        thread.start();
        try {
            port.getOutputStream().write(val.getBytes());
            Thread.sleep(5);
//        System.out.println(val.getBytes());
        } catch (IOException  | InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            port.getOutputStream().flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void serialComm(byte [] data){
        Thread thread= new Thread();
        thread.start();
        try {
            port.getOutputStream().write(data);
            Thread.sleep(5);
//        System.out.println(val.getBytes());
        } catch (IOException  | InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            port.getOutputStream().flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//
    public byte comp_buff(char[] buff1, char[] buff2, int size){
        byte cnt = 0;
        for (short i = 0; i < size; i++)
        {
            if (buff1[i] != buff2[i])
            {
                cnt = 0;
                return cnt;
            }
            if (buff1[i] == buff2[i])
            {
                cnt = 1;
            }
        }
        return cnt;
    }

    public void getFileName(String fd){
        int count=0;
        int cnt=0;
        int size= fd.length();
        char[] buff = new char[size];
        char[] stArray = fd.toCharArray();


            for (int i = 0; i < 512; i++) {
                for (int j = 0; j < size; j++) {
                    if(uart.get(i+j)==stArray[j]){
                        buff[j]=stArray[j];
                        System.out.print(buff[i]+" ");
                        count++;
                    }
                    if(uart.get(i+j)!=stArray[j]){
                        count=0;
                    }
                    if(count==size){
                        cnt=comp_buff(buff,stArray, size);
                        if(cnt==1){
                            System.out.println(buff+" ");
                        }
                        if(cnt==0){
                            System.out.println("No File");
                        }
                        break;
                    }
                }
                count=0;
            }


    }
    public void closeSerial(){
//    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        if (port.isOpen()) {
            port.closePort();
            System.out.println();
            System.out.println("Port closed.");
        }
//    }));

    }
}