package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    int frmWidth=600;
    int frmHeight=400;
    static void main() {
        Main mn=new Main();
        jframe frame=new jframe(600,0,mn.frmWidth, mn.frmHeight, "USB_SERIAL");
        jpanel pane=new jpanel(10,10,580,340,"panel");

        jserial serial=new jserial("/dev/ttyUSB0",19200);
        serial.serialInit();

        jlabel jlabel = new jlabel(200, 10, 40, "STM32");
        JLabel getlabel = jlabel.getlabel("STM32 DATA I/O");

        jinputs write = new jinputs(10, 50, 250, 30, "write");
        JTextField jTextField = write.initInputs(serial);

        jbutton button=new jbutton(300,50,100,30,"..SEND..");
        JButton button1 = button.getButton(serial,write);

        jbutton exitbut=new jbutton(410,50,100,30,"..EXIT..");
        JButton buttonExit = exitbut.getButtonExit(serial);

        //////////////////////////////////////
        ArrayList<Component>wdts=new ArrayList<>();//panel
        wdts.addFirst(button1);
        wdts.add(buttonExit);
        wdts.add(jTextField);
        wdts.add(getlabel);
//
        JPanel panel = pane.getpanelComp(wdts);
        ArrayList<Component>comp=new ArrayList<>();//image
        comp.addFirst(panel);

        frame.getFrame(comp);//all


//        Timer timer=new Timer(4,e->{
//
//            if(!serial.uart.isEmpty() ){
//                serial.getFileName("Second_file");
//                serial.uart.clear();
//            }
//        });
//        timer.start();
    }
}