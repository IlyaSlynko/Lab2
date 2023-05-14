package org.dstu.shapes.animation;

import org.dstu.components.GraphicsPanel;
import org.dstu.shapes.Shape;
import org.dstu.shapes.Square;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class Animator implements Runnable {
    protected Shape shape ;
    protected JComponent component;

    public Animator(Shape shape, JComponent component) {
        this.shape = shape;
        this.component = component;
    }
}
