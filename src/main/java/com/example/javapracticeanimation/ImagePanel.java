package com.example.javapracticeanimation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class ImagePanel extends JPanel {

    protected RectangleImage image = null;
    int height;
    int width;
    protected int x, y;

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
            ImageIcon icon = new ImageIcon(inImage);
            int scale = 3;
            width = icon.getIconWidth() / scale;
            height = icon.getIconHeight() / scale;
            image = new RectangleImage(inImage, width, height);
        } catch (IOException ex) {
            // handle exception...
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        if(image == null)
            return;
        Graphics2D g2 = (Graphics2D)g;
        image.Draw(g2, this);
        super.paintComponent(g);
    }

    abstract void update(int step, JFrame borders);
}

