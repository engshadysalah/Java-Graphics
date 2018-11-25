/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optimal.drawing.drawroundrectangel;

import com.optimal.drawing.drawrectangel.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author root
 */
public class RoundRectangel {

    public final double x;
    public final double y;
    public final double width;
    public final double hight;

    public RoundRectangel(double x, double y, double width, double hight) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.hight = hight;
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(new RoundRectangle2D.Double(x, y, width, hight, 25, 25));
        

    }

}
