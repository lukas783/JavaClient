package com.UI;

import com.Client;
import com.net.ConnectionHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Lukas on 11/9/2015.
 */
public class Background extends JPanel {

    public Background() {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw(g);
    }

    private void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);


        g2d.setFont(new Font("Serif", Font.BOLD, 40));
        g2d.drawString("Random Framework", 200, 150);
        g2d.setFont(new Font("Serif", Font.BOLD, 20));
        g2d.drawString("Username: ", 100, 250);
        g2d.drawString("Password: ", 100, 300);
        //g2d.drawString(c.username, 175, 250);
    }




}
