package com;

import com.io.output;
import com.net.ConnectionHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.*;

/**
 * Created by Lukas on 10/31/2015.
 */
public class Client extends JPanel implements MouseListener, KeyListener {

    public boolean online = false;
    public output ostream;
    public Graphics g;
    String username = "";
    JTextArea u;

    //Creates an invokable run statement that 'kicks off' the GUI/Applet
    public static void main(String[] argv) {
        Runnable r = () -> {
            init();
        };
        SwingUtilities.invokeLater(r);

    }

    public static void init() {
        JFrame frame = new JFrame("Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent content = new Client();
        //content.setOpaque(true);
        frame.setContentPane(content);
        frame.getContentPane().setBackground(Color.black);
        frame.setSize(1024, 768);
        frame.setVisible(true);
    }

    public Graphics getGraphics() {
        Graphics g = super.getGraphics();
        //g.translate(4, 24);
        return g;
    }

    public Client() {
        super(null);
        //g = super.getGraphics();
        u = new JTextArea();
        JLabel userL = new JLabel("Username: ");
        userL.setForeground(Color.white);
        userL.setBounds(50, 100, 120, 50);
        add(userL);
        super.addKeyListener(this);
        Font font = new Font("Helvetica", 1, 13);
        //g.setFont(font);
        //g.setColor(Color.white);
        //g.drawString("Username2: ", 200, 200);

        u.addKeyListener(this);
        u.setBounds(170, 100, 120, 50);
        u.setBackground(Color.black);
        u.setForeground(Color.white);
        u.setLineWrap(false);
        u.setEditable(false);
        add(u);
        //u.setVisible(false);
        addMouseListener(this);
    }

    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Something...");
        System.out.println(e.getPoint());
        if(online) {
            ostream.write(e.getX());
            ostream.write(e.getY());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key: " +e.getKeyChar());
        if(e.getKeyChar() == e.VK_ENTER) { // enter
            ConnectionHandler c = new ConnectionHandler();
            System.out.println("Attempted to login with username " +username);
            username = "";
            u.setText(username);
            repaint();
            return;
        }
        if(username.length() >= 28) {
            u.setText(username);
            repaint();
            return;
        }
        username = username+e.getKeyChar();
        u.setText(username);
        repaint();
        System.out.println("Username is currently: "+username);
    }
    @Override
    public void keyTyped(KeyEvent e) {


    }
}
