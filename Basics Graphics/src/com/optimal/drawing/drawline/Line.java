/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optimal.drawing.drawline;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author root
 */
public class Line {

    public final int x1;
    public final int x2;
    public final int y1;
    public final int y2;
    public final int r;
    public final int g;
    public final int b;

    public Line(int x1, int y1, int x2, int y2, int r, int g, int b) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.r=r;
        this.g=g;
        this.b=b;
    }

    public void paint(Graphics graphics) {

        //set random cloro
       // Random rr = new Random();
        graphics.setColor(new Color(r, g, b));

        graphics.drawLine(this.x1, this.y1, this.x2, this.y2);
        System.out.println("x:" + x1);

    }

}
