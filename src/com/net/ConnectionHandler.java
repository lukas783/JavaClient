package com.net;

import com.io.output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Lukas on 11/2/2015.
 */
public class ConnectionHandler {

    private static String serverIP = "127.0.0.1";
    private static int port = 17372;
    private static int REVISION = 0;
    private static int MAJOR = 0;
    private static int MINOR = 0;

    public ConnectionHandler() {
        // Basic connecting to a server for a client..
        try {
            Socket client = new Socket(serverIP, port);
            output out = new output(client.getOutputStream());
            //PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String input;
            System.out.println("[CLIENT] - Loading client.");
            System.out.println("[CLIENT] - Sending handshake to client");
            out.write(Integer.toString(REVISION) + "." + Integer.toString(MAJOR) + "." + Integer.toString(MINOR));
        } catch (UnknownHostException uhe) {
            uhe.printStackTrace();
            System.out.println("[UnknownHostException] - Unable to find host");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("[IOException] - Unable to r/w to server");
        }
    }

}
