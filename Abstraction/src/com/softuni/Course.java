package com.softuni;

public enum Course {
    Basics("basics", 0, "first course"),
    Fundamentals("basics", 0, "first course"),
    Advanced("basics", 0, "first course");

    private String name;
    private int price;
    private String description;


    Course(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("The name of the course is %s and it costs %d", name, price);
    }
}
