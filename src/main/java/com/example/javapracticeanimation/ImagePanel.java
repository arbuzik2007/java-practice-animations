package com.example.javapracticeanimation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {

    private RectangleImage image = null;

    int x, y;

    public ImagePanel() {
        try {
            var inImage = ImageIO.read(new File("resources/helicopter.png"));
            MediaTracker mt = new MediaTracker(this);
            mt.addImage(inImage, 1);
            try {
                mt.waitForAll();
            } catch (Exception e) {
                System.out.println("Image not found.");
            }
            image = new RectangleImage(inImage, 300, 300);
        } catch (IOException ex) {
            // handle exception...
        }
    }

    private boolean checkBorders(Rectangle bounds){
        if (this.x < (bounds.getMinX()) ||
                this.x > (bounds.getWidth())) {
            return true;
        }
        return (this.y > (bounds.getHeight())) ||
                (this.y < (bounds.getMinY()));
    }
    @Override
    protected void paintComponent(Graphics g) {
        if(image == null)
            return;
        Graphics2D g2 = (Graphics2D)g;
        image.Draw(g2, this);
        super.paintComponent(g);
    }

    public void update(int step, JFrame borders) {

        if(!checkBorders(borders.getBounds())) {
            x = 0;
            y = 0;
        }

        x += step;
        y += step;
        //y += step;
        image.Move(x, y);
        repaint();
    }
}
