package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

public class jpanel {
JPanel jp;
int xn;
int yn;
int width;
int height;
String name;
ArrayList<String> comp;
public jpanel(){

}
public jpanel(int x,int y,int width,int height,String name){
    this.xn=x;
    this.yn=y;
    this.width=width;
    this.height=height;
    this.name=name;
    jp = new JPanel();
}

    public  JPanel getpanelComp(Component apane) {

        jp.setBounds(this.xn, this.yn, this.width, this.height);
        jp.setName(this.name);
        jp.setBackground(new Color(212, 217, 225, 213));
        jp.setPreferredSize(new Dimension(this.width, this.height));
        Border border = new LineBorder(new Color(216, 218, 227, 222), 1, true);
        jp.setBorder(border);
        jp.setEnabled(true);
        jp.setLayout(null);
        jp.add(apane);
        jp.setVisible(true);
        return jp;
    }
    public  JPanel getpanelComp(ArrayList<Component> apane) {
        jp = new JPanel();
        jp.setBounds(this.xn, this.yn, this.width, this.height);
        jp.setName(this.name);
        jp.setBackground(new Color(233, 231, 229, 213));
        jp.setPreferredSize(new Dimension(this.width, this.height));
        Border border = new LineBorder(new Color(216, 218, 227, 222), 1, true);
        jp.setBorder(border);
        jp.setEnabled(true);
        jp.setLayout(null);
        for(Component ccp:apane){
            jp.add(ccp);
        }
        jp.setVisible(true);
        return jp;
    }

}