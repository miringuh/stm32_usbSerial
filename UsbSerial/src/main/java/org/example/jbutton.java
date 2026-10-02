package org.example;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class jbutton extends JButton{
    jserial mserial;
    int xn;
    int yn;
    int width;
    int height;
    JButton button=new JButton();
    String name;

    public jbutton(int x,int y,int w,int h,String name) {
    this.xn=x;
    this.yn=y;
    this.height=h;
    this.width=w;
    this.name=name;
}
    public JButton getButton(jserial serial,jinputs write) {
        mserial=serial;
        button.setName(name);
        button.setText(name);
        button.setBounds(this.xn,this.yn,this.width,this.height);
        button.setFont(new Font(Font.SANS_SERIF,Font.BOLD,12));
        button.setEnabled(true);
        button.setVisible(true);
        button.setLayout(null);
        button.setBackground(new Color(135, 229, 206));
        button.setBorder(new BevelBorder(BevelBorder.RAISED));
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { }
            @Override
            public void mousePressed(MouseEvent e) {
                mserial.serialComm(write.data.toString().toUpperCase());
                mserial.getSerial(serial.port);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                int length = write.data.length();
                write.data.delete(0,length);
                write.text.setText(" ");
                write.text.setCaretPosition(0);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
//                    serial.getFileName("Second_file");
//                System.out.print(serial.uart.size()+" ");
//                if (serial.uart.size()>=512){
//                    //serial.getFileName("Second_file");
//                    serial.uart.clear();
//                }


            }
        });
        return button;
    }
    public JButton getButtonExit(jserial serial) {
        button.setName(name);
        button.setText(name);
        button.setBounds(this.xn,this.yn,this.width,this.height);
        button.setFont(new Font(Font.SANS_SERIF,Font.BOLD,12));
        button.setEnabled(true);
        button.setVisible(true);
        button.setLayout(null);
        button.setBackground(new Color(207, 133, 110));
        button.setBorder(new BevelBorder(BevelBorder.RAISED));
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {serial.closeSerial(); }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        return button;
    }
}