package com.ceva.shape.circle;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import com.ceva.shape.SimpleShape;

public class Circle implements SimpleShape
{
    private Icon m_icon;

    public Circle() {
        m_icon = new ImageIcon(this.getClass().getResource("circle.png"));
    }

    public String getName() {
        return "Circle";
    }

    public Icon getIcon() {
        return m_icon;
    }

    /**
     * Implements the <tt>SimpleShape.draw()</tt> method for painting the shape.
     *
     * @param g2 The graphics object used for painting.
     * @param p The position to paint the triangle.
     **/
    public void draw(Graphics2D g2, Point p) {
        int x = p.x - 25;
        int y = p.y - 25;
        GradientPaint gradient = new GradientPaint(x, y, Color.RED, x + 50, y, Color.WHITE);
        g2.setPaint(gradient);
        g2.fill(new Ellipse2D.Double(x, y, 50, 50));
        BasicStroke wideStroke = new BasicStroke(2.0f);
        g2.setColor(Color.black);
        g2.setStroke(wideStroke);
        g2.draw(new Ellipse2D.Double(x, y, 50, 50));
    }
}
