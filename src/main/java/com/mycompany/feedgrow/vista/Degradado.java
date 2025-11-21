
package com.mycompany.feedgrow.vista;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Degradado extends JPanel {
    private Color color1, color2;
    private boolean vertical;

    public Degradado(int c1r, int c1g, int c1b, int c2r, int c2g, int c2b, boolean vertical) {
        this.color1 = new Color(c1r, c1g, c1b);
        this.color2 = new Color(c2r, c2g, c2b);
        this.vertical = vertical;
        setOpaque(false); // importante: para que los hijos sigan visibles
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();

        GradientPaint grad = vertical
                ? new GradientPaint(0, 0, color1, 0, h, color2)
                : new GradientPaint(0, 0, color1, w, 0, color2);

        d.setPaint(grad);
        d.fillRect(0, 0, w, h);
    }
}
