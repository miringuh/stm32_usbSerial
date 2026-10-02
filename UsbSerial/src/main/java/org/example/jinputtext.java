package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class jinputtext {
    JTextArea area;
    String file;
    int yn;
    int xn;
    int width;
    int height;
    String name;
    StringBuffer buff;
public jinputtext() {

}
public jinputtext(int xn, int yn, int w, int h, String name) {
    this.xn=xn;
    this.yn=yn;
    this.width=w;
    this.height=h;
    this.name=name;
    buff=new StringBuffer();
}
public JTextArea getTextArea(){
    area = new JTextArea();
    area.setName(this.name);
    area.setBounds(this.xn, this.yn, this.width, this.height);
    area.setSize(this.width, this.height);
    area.setWrapStyleWord(true);
    area.setEnabled(true);
    area.setDragEnabled(true);
    area.setText("");
    area.setLayout(null);
    Border border = new LineBorder(new Color(162, 183, 220, 207), 5, true);
    area.setBorder(border);
    area.setVisible(true);
    area.addInputMethodListener(new InputMethodListener() {
        @Override
        public void inputMethodTextChanged(InputMethodEvent event) {
            System.out.println(event.getText());
        }
        
        @Override
        public void caretPositionChanged(InputMethodEvent event) {
        
        }
    });
    area.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.print(e.getKeyChar());
            
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
        
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
        
        }
    });
    return area;
}
}