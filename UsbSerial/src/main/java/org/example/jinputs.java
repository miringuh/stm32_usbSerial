package org.example;

import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class jinputs {
    JTextField text = new JTextField();
    jserial mserial;
    int yn;
    int xn;
    int width;
    int height;
    String name;
    StringBuffer data=new StringBuffer();

    public jinputs(int xn, int yn, int w, int h, String name) {
        this.xn = xn;
        this.yn = yn;
        this.width = w;
        this.height = h;
        this.name = name;
    }
//
public JTextField initInputs(jserial serial) {
    mserial=serial;
    text.setName(this.name);
    text.setBounds(this.xn, this.yn, this.width, this.height);
    text.setEditable(true);
    text.setLayout(null);
    text.setEnabled(true);
    text.setToolTipText("send Data");
    text.setBorder(new BevelBorder(BevelBorder.RAISED));
    text.setVisible(true);
    //         KEYS
    text.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            data.append(e.getKeyChar());
            text.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        @Override
        public void keyPressed(KeyEvent e) {}
        @Override
        public void keyReleased(KeyEvent e) {}
    });
    //         ACTION
    text.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mserial.serialComm(data.toString().toUpperCase());
            mserial.getSerial(serial.port);
            data.delete(0,data.capacity());
            text.setText(" ");
            text.setCaretPosition(0);


        }
    });
    //         MOUSE
    text.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

            data.delete(0,data.capacity());
            text.setText(" ");
            text.setCaretPosition(0);
        }
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
    });
    return text;
}


}