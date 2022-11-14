package com.OpenClosed;

import java.util.List;

public class Farm {
    //Cow -> DI
    List<Walkable> animals;

    public void walkAnimals(){
        for (Walkable animal : animals) {
            animal.takeAWalk();
        }
    }
}
