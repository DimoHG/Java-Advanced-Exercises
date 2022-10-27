package com.jediGalaxy;

public class EvilPower {
    public void move(int rowEvil, int colEvil, Field field) {
        while (rowEvil >= 0 && colEvil >= 0) {
            if (field.isInBounds(rowEvil, colEvil)) {
                field.setValue(rowEvil, colEvil, 0);
            }
            rowEvil--;
            colEvil--;
        }
    }
}
