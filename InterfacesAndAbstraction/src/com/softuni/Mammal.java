package com.softuni;

public abstract class Mammal implements Animal{
    private int requiredMilk;
    public void drinkMilk(){
        System.out.println("Drinking milk");
    }


    public int getRequiredMilk() {
        return requiredMilk;
    }

    public void setRequiredMilk(int requiredMilk) {
        this.requiredMilk = requiredMilk;
    }

    public abstract void walk();
}
