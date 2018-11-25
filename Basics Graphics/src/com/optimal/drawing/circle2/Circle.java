/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optimal.drawing.circle2;

import com.optimal.drawing.circle.*;
import com.optimal.drawing.drawroundrectangel.*;
import com.optimal.drawing.drawrectangel.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author root
 */
public class Circle {

    public final int x;
    public final int y;
    public final int r;
 
    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.drawOval(x,y,r,r);
        
        g2d.setColor(Color.green);
        g2d.fillOval(x,y,r,r);
        

    }

}
