package com.io;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Created by Lukas on 11/2/2015.
 */
public class output {
    public static PrintWriter out;

    public output(OutputStream o) {
        out = new PrintWriter(o, true);
    }

    public void write(String s) {
        out.write(s);
        out.flush();
    }

    public void write(int i) {
        out.write(i);
        out.flush();
    }
}
