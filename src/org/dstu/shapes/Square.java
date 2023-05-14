package org.dstu.shapes;

import org.dstu.components.GraphicsPanel;
import org.dstu.shapes.animation.SquareAnimator;

import javax.swing.*;
import java.awt.*;

public class Square extends Shape {
    protected int side;

    public Square() {
    }

    public Square(int x, int y, int side, Color color) {
        super(x, y, color);
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, side, side);
        g.fillRect(x, y, side, side);
    }

    @Override
    public SquareAnimator getAnimator(JComponent component ) {
        return new SquareAnimator(this, component);
    }

    @Override
    public boolean intersects(Shape otherShape) {
        if (otherShape instanceof Square otherSquare) {
            int thisRight = x + side;
            int thisBottom = y + side;
            int otherRight = otherShape.x + otherSquare.side;
            int otherBottom = otherShape.y + otherSquare.side;

            if (thisRight <= otherShape.x) {
                return false;
            }

            if (x >= otherRight) {
                return false;
            }

            if (thisBottom <= otherShape.y) {
                return false;
            }

            return y < otherBottom;
        }
        else {
            return false;
        }
    }
}


