package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class jlabel {
    JLabel lab;
    int xn;
    int yn;
    int width;
    int height;
    String name;

    public jlabel() {}

    public jlabel(int xn, int yn, int h, String name) {
        this.xn = xn;
        this.yn = yn;
        this.width = (name.length()*30) ;
        this.height = h;
        this.name = name;
    }
    public JLabel getlabel(String word) {
        lab = new JLabel();
        lab.setName(this.name);
        lab.setText(word);
        lab.setBounds(this.xn, this.yn, this.width, this.height);
        lab.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
        lab.setLayout(null);
        lab.setEnabled(true);
        lab.setVisible(true);
        lab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        return lab;
    }}