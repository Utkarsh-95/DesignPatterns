/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Utkarsh Pratap Singh
 */
package com.solid.srp;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class SRP {

    private final List<String> entries = new ArrayList<>();

    private static int count = 0;

    public void addEntry(String text) {
        entries.add("" + (++count) + ": " + text);
    }

    public void removeEntry(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

    // here we break SRP
    public void save(String filename) throws Exception {
        try (PrintStream out = new PrintStream(filename)) {
            out.println(toString());
        }
    }

    public void load(String filename) {
    }

    public void load(URL url) {
    }
}

// handles the responsibility of persisting objects
class Persistence {

    public void saveToFile(SRP srp,
            String filename, boolean overwrite) throws Exception {
        if (overwrite || new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(srp.toString());
            }
        }
    }

    public void load(SRP srp, String filename) {
    }

    public void load(SRP srp, URL url) {
    }
}

public class SRPDemo {

    public static void main(String[] args) throws Exception {
        SRP j = new SRP();
        j.addEntry("I cried today");
        j.addEntry("I ate a bug");
        System.out.println(j);
//        j.removeEntry(1);

        Persistence p = new Persistence();
        String filename = "F:\\TEST.txt";
        p.saveToFile(j, filename, true);

        // windows!
        Runtime.getRuntime().exec("notepad.exe " + filename);
    }
}
