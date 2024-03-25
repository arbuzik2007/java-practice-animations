package com.example.javapracticeanimation;

import javax.swing.*;
import java.awt.*;

public class DiagonalMovementPanel extends ImagePanel {
    boolean checkBorders(Rectangle bounds) {
        if (this.x < (bounds.getMinX()) ||
                this.x > (bounds.getWidth() - width)) {
            return true;
        }
        return (this.y > (bounds.getHeight() - height)) ||
                (this.y < (bounds.getMinY()));
    }

    @Override
    void update(int step, JFrame frame) {
        var borders = new Rectangle(0, 0, frame.getWidth(), frame.getHeight());
        if (checkBorders(borders.getBounds())) {
            x = 0;
            y = 0;
        }

        x += step;
        y += step;

        this.image.Move(x, y);
        repaint();
    }
}
