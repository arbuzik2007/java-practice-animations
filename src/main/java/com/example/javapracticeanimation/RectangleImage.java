package com.example.javapracticeanimation;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class RectangleImage {
    private BufferedImage image;
    private Rectangle rect;

    public RectangleImage(BufferedImage img, int width, int height) {
        this.image = img;
        this.rect = new Rectangle(0, 0, width, height);
    }

    public BufferedImage getImage() {
        return image;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void Move(int x, int y){
        this.rect.setBounds(x, y, rect.width, rect.height);
    }

    public void Draw(Graphics2D g2, ImageObserver o){
        g2.drawImage(this.image, this.rect.x, this.rect.y, this.rect.width, this.rect.height, o);
        g2.dispose();
    }
}
