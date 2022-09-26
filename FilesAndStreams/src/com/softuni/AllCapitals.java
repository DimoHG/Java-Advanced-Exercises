package com.softuni;

import java.io.*;
import java.util.Locale;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("resources/output.txt"));
        BufferedReader br = new BufferedReader(new FileReader("resources/input.txt"));
        br.lines().forEach(line -> pw.println(line.toUpperCase()));
        br.close();
        pw.close();
    }
}
