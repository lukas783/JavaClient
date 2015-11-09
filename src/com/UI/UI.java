package com.UI;

import com.Client;
import com.net.ConnectionHandler;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Lukas on 11/9/2015.
 */
public class UI extends JFrame implements KeyListener {

    Client c;
    private String username = "";

    public UI() {
        initUI();
    }

    private void initUI() {
        /**
         * adds
         **/
        add(new Background());
        addKeyListener(this);

        /**
         * JFrame(this) params
         **/
        setSize(1024, 768);
        setTitle("Client...");
        setFocusable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key: " +e.getKeyChar());

        if(e.getKeyChar() == e.VK_ENTER) {
            System.out.println("Enter pressed, sending stuff to server.. Username: "+username);
            ConnectionHandler con = new ConnectionHandler();
            username = "";
        } else if(username.length() > 27) {
            System.out.println("Username too long, ignoring..");
        } else if(e.getKeyChar() == e.VK_BACK_SPACE) {
            if(username.length() > 0)
                username = username.substring(0, username.length()-1);
            System.out.println("Deleted... Username: "+username);
        } else {
            username += e.getKeyChar();
            System.out.println("Username is "+username);
        }
      /*  if(e.getKeyChar() == e.VK_ENTER) { // enter
            ConnectionHandler con = new ConnectionHandler();
            System.out.println("Attempted to login with username " + c.username);
            c.username = "";
            //u.setText(username);
            repaint();
            return;
        }
        if(c.username.length() >= 28) {
            //u.setText(username);
            repaint();
            return;
        }
        c.username = c.username+e.getKeyChar();
        //u.setText(username);
        repaint();
        System.out.println("Username is currently: "+ c.username);
        */
    }
    @Override
    public void keyTyped(KeyEvent e) {


    }

}
