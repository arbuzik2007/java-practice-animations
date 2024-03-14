package com.example.javapracticeanimation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HelloApplication extends Application {
    static JFrame getFrame(int width, int height){
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2-250,
                dimension.height/2 - 150,
                width,
                height);
        return jFrame;
    }

    private static void startDiagonalAnimation() {
        JFrame frame = getFrame(700, 700);
        var panel = new DiagonalMovementPanel();
        panel.setVisible(true);
        frame.setContentPane(panel);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(30), t -> panel.update(10, frame)
                ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private static void startSquareAnimation(){
        JFrame frame = getFrame(700, 700);
        var panel = new SquareMovementPanel();
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
        JFrame menu = getFrame(400, 100);
        menu.setLayout(new GridBagLayout());
        //menu.setLayout();
        Button option1 =  new Button("Diagonal Movement Demo");
        option1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(HelloApplication::startDiagonalAnimation);
            }
        });
        menu.add(option1);
        Button option2 = new Button("Square Movement Demo");
        option2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(HelloApplication::startSquareAnimation);
            }
        });
        menu.add(option2);
    }

    public static void main(String[] args) {
        launch();
    }
}