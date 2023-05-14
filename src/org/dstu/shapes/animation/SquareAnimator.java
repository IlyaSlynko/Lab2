package org.dstu.shapes.animation;

import org.dstu.components.GraphicsPanel;
import org.dstu.shapes.Shape;
import org.dstu.shapes.Square;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SquareAnimator extends Animator {

    public SquareAnimator(Shape shape, JComponent component) {
       super(shape, component);
    }

    @Override
    public void run() {
        GraphicsPanel graphicsPanel = (GraphicsPanel) component;
        while (true) {
            boolean intersect = false;
            for (Shape shape : graphicsPanel.getShapes()){
                if (shape instanceof Square otherSquare) {
                    if (shape.intersects(otherSquare)){
                        intersect = true;
                        break;
                    }
                }
            }
            if (intersect) {
                shape.moveRel(0, (int) (Math.random() * 40));
            } else {
                shape.moveRel(0, -(int) (Math.random() * 10));
            }
            if (component != null) {
                component.repaint();
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
