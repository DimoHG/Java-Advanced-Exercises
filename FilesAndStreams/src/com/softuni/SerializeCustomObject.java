package com.softuni;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course course = new Course();
        course.name = "Java Advanced September 2022";
        course.numberOfStudents = 250;

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("resources/courses.ser"));
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("resources/courses.ser"));

        output.writeObject(course); //serialize -> write to file

        Course courseFromFile = (Course) input.readObject(); //deserialize, -> read from file
        System.out.println(courseFromFile.numberOfStudents);
        System.out.println(courseFromFile.name);
    }
}
