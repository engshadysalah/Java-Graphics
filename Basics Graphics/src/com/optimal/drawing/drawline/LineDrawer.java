/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optimal.drawing.drawline;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author shady
 */
// https://www.youtube.com/watch?v=DjSJjK5_4zE
//https://stackoverflow.com/questions/9442389/find-length-of-line-in-java Length to cm
public class LineDrawer extends JFrame {

    private int xbegin = 0;
    private int ybegin = 0;
    private int xend = 0;
    private int yend = 0;

    JPanel jPanel;

    //private  ArrayList<Line> lines;
    private ArrayList<Line> lines = new ArrayList<Line>();
    Random r = new Random();

    public void addLine(int xbegin, int ybegin, int xend, int yend) {

        lines.add(new Line(xbegin, ybegin, xend, yend, r.nextInt(256), r.nextInt(256), r.nextInt(256)));

        double length = Math.sqrt(pow((xend - xbegin), 2) + pow((yend - ybegin), 2));

        System.out.println("===========> length is = " + length);

    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        // g.setFont(new Font ("Monospaced", Font.BOLD, 100));
        //graphics.setColor(Color.green);
        //graphics.drawLine(xbegin, ybegin, xend, yend);
        //g.drawRect(xbegin, ybegin, xend, yend);
        // graphics.setPaintMode();

        jPanel.getGraphics().setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        jPanel.getGraphics().drawLine(xbegin, ybegin, xend, yend);

        if (lines.isEmpty()) {

            System.out.println("list is Empty ");

        } else {

            for (final Line l : lines) {

              l.paint(jPanel.getGraphics());

                System.out.println("List siza : " + lines.size());
            }
        }
    }

    public LineDrawer() {

        jPanel = new JPanel();
        add(jPanel);
        //jPanel.setBackground(Color.white);

        setTitle("Drawer");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        jPanel.addMouseListener(mouseHandler);
        jPanel.addMouseMotionListener(mouseMotionHandler);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DELETE) {

                    System.out.println("deleeeeeeeeeeeeeet");
                    xbegin = 0;
                    ybegin = 0;
                    xend = 0;
                    yend = 0;

                    if (lines.isEmpty()) {

                    } else {

                        lines.remove(lines.size() - 1);
                        repaint();

                    }

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

    }

    public MouseListener mouseHandler = new MouseAdapter() {

        @Override
        public void mousePressed(MouseEvent e) {

            xbegin = e.getX();
            ybegin = e.getY();

        }

        @Override
        public void mouseReleased(MouseEvent e) {

            System.out.println("e.getX() " + e.getX());
            System.out.println("e.getpoint " + e.getPoint());
            xend = e.getX();
            yend = e.getY();

            System.out.println("xend " + xend);

            if ((xbegin == xend) && (ybegin == yend)) {

                System.out.println("Cann't Paint Line");
            } else {
                addLine(xbegin, ybegin, xend, yend);
            }
        }

    };

    public MouseMotionListener mouseMotionHandler = new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {

            xend = e.getX();
            yend = e.getY();
            // Random r = new Random();

           // Line line = new Line(xbegin, ybegin, xend, yend, 1, 1, 1);
           // line.paint(jPanel.getGraphics());
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {

            System.out.println("e.getX() " + e.getX());
            System.out.println("e.getpoint " + e.getPoint());

        }

    };

    public static void main(String[] args) {

        new LineDrawer();

    }

}
