/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optimal.drawing.drawroundrectangel;

import com.optimal.drawing.drawrectangel.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author root
 */
public class RoundRectangelDrawer extends JFrame {

    JPanel jPanel;

    private ArrayList<RoundRectangel> rectangels = new ArrayList<RoundRectangel>();

    int Removed = 0;

    Point pointStart = null;
    Point pointsEnd = null;

    public RoundRectangelDrawer() {

        jPanel = new JPanel();

        add(jPanel);

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

                    pointStart = new Point(0, 0);
                    pointsEnd = new Point(0, 0);

                    if (rectangels.isEmpty()) {

                    } else {

                        rectangels.remove(rectangels.size() - 1);

                        repaint();

                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

    }

    public void addRectangel(double xbegin, double ybegin, double width, double hight) {

        rectangels.add(new RoundRectangel(xbegin, ybegin, width, hight));

        System.out.println("===========> Done ");

    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        if (pointStart == null) {
        } else {

            // to show pointes of rectangel while drawing
            //jPanel.getGraphics().drawRect((int) pointStart.x, (int) pointStart.y, (int) pointsEnd.distance(pointStart.x, pointsEnd.y), (int) pointsEnd.distance(pointsEnd.x, pointStart.y));
            Graphics2D g2d = (Graphics2D) jPanel.getGraphics();
            g2d.draw(new RoundRectangle2D.Double(pointStart.x, pointStart.y, pointsEnd.distance(pointStart.x, pointsEnd.y), pointsEnd.distance(pointsEnd.x, pointStart.y), 25, 25));

            if (rectangels.isEmpty()) {

                System.out.println("list is Empty ");

            } else {

                for (final RoundRectangel r : rectangels) {

                    r.paint(jPanel.getGraphics());

                    System.out.println("List size : " + rectangels.size());

                }

            }
        }

    }

    public MouseListener mouseHandler = new MouseAdapter() {

        @Override
        public void mousePressed(MouseEvent e) {

            pointStart = e.getPoint();

        }

        @Override
        public void mouseReleased(MouseEvent e) {

            pointsEnd = e.getPoint();

            if (e.getPoint().distance(pointStart.x, pointsEnd.y) == 0.0) {

                System.out.println("Cann't paint");

            } else {

                System.out.println("x" + e.getPoint().x);

                addRectangel(pointStart.x, pointStart.y, e.getPoint().distance(pointStart.x, pointsEnd.y), e.getPoint().distance(pointsEnd.x, pointStart.y));

                System.out.println("===>  Rec Area = " + e.getPoint().distance(pointStart.x, pointsEnd.x) * e.getPoint().distance(pointsEnd.x, pointStart.y));

                repaint();

            }
        }

    };

    public MouseMotionListener mouseMotionHandler = new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {

            pointsEnd = e.getPoint();

            repaint();
        }

    };

    public static void main(String[] args) {

        new RoundRectangelDrawer();

    }

}
