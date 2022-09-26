package com.softuni;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("resources/inputLineNumbers.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("resources/output.txt"));
        String line = br.readLine();
        int counter = 1;
        while(line != null){
            pw.println(counter + ". " + line);
            counter++;
            line = br.readLine();
        }
        br.close();
        pw.close();
    }
}
