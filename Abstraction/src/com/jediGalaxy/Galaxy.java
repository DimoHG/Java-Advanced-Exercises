package com.jediGalaxy;

public class Galaxy {
    private Field field;
    private Jedi jedi;
    private EvilPower evilPower;

    public Galaxy(Field field, Jedi jedi) {
        this.field = field;
        this.jedi = jedi;
        evilPower = new EvilPower();
    }

    public int moveJedi() {
        return jedi.move(field);
    }

    public void moveEvil(int rowEvil, int colEvil) {
       evilPower.move(rowEvil, colEvil, field);
    }
}
