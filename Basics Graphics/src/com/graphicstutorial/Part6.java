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
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;
import javafx.scene.shape.QuadCurve;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author root
 */
public class Part6 extends JFrame {

    public Part6() {

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

            for (int line = 0; line < 100; line++) {

                g2d.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));

                float strokeWidth = r.nextFloat() * 50;
                BasicStroke bs = new BasicStroke(strokeWidth);

                double startX = r.nextDouble() * 1024;
                double startY = r.nextDouble() * 1024;
                double endX = r.nextDouble() * 1024;
                double endY = r.nextDouble() * 1024;
                double ctrlX = r.nextDouble() * 1024 ;
                double ctrlY = r.nextDouble() * 1024 ;

                //create new QuadeCurve2D.Float
                QuadCurve2D q = new QuadCurve2D.Double();

                //draw with coordinates
                q.setCurve(10, 512, ctrlX, ctrlY, 1010, 512);
                g2d.draw(q);

            }
            //   RenderingHints rh = new RenderingHints(RenderingHints.KEY_RENDERING,
            //     RenderingHints.VALUE_ANTIALIAS_ON);
            //  rh.putIfAbsent(RenderingHints.KEY_RENDERING,
            //        RenderingHints.VALUE_ANTIALIAS_ON);
            //   g2d.fillRect(30, 20, 50, 50);
            //   g2d.fillRect(120, 20, 90, 50);
            //   g2d.fillRoundRect(250, 20, 70, 60, 20, 20);
            //g2d.fill(new Ellipse2D.Double(10, 100, 80, 100));
//            g2d.fillArc(120, 130, 110, 100, 5, 150);
//            g2d.fillOval(270, 130, 50, 50);
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
            doDrawing(g);
        }

    }

    public static void main(String[] args) {

        new Part6();
    }
}
