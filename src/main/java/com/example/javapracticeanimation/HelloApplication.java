package com.example.javapracticeanimation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;

public class HelloApplication extends Application {
    static JFrame getFrame(){
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2-250,
                dimension.height/2 - 150,
                1500,
                1300);
        return jFrame;
    }

    private static void startAnimation() {
        JFrame frame = getFrame();
        var panel = new ImagePanel();
        panel.setVisible(true);
        frame.setContentPane(panel);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(30), t -> panel.update(10, frame)
                ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();


    }

    @Override
    public void start(Stage stage) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(HelloApplication::startAnimation);

    }

    public static void main(String[] args) {
        launch();
    }
}