/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphicstutorial;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author root
 */
public class Part_10 extends JFrame {

    public Part_10() {

        initUI();
    }

    private void initUI() {

        setTitle("Ex1");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Surface());
        setSize(1042, 1024);
        setLocationRelativeTo(null);
    }

    class Surface extends JPanel {

        private void doDrawing(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;

            //set random cloro
            Random r = new Random();

            g2d.translate(512, 512);
            
            for (int line = 0; line < 100; line++) {

                g2d.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));

                float strokeWidth = r.nextFloat() * 50;
                BasicStroke bs = new BasicStroke(strokeWidth);

                double startX = r.nextDouble() * 1024;
                double startY = r.nextDouble() * 1024;
                double width = r.nextDouble() * 1024 / 8;
                double height = r.nextDouble() * 1024 / 8;
                double ctrlX = r.nextDouble() * 1024;
                double ctrlY = r.nextDouble() * 1024;
                double ctrlX2 = r.nextDouble() * 1024;
                double ctrlY2 = r.nextDouble() * 1024;

                g2d.fill(new Arc2D.Double(startX, startY, width, height, 0, 270, Arc2D.PIE));

                g2d.rotate(Math.PI / 8);
                
            }
             
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
            doDrawing(g);
        }

    }

    public static void main(String[] args) {

        new Part_10();
    }
}
