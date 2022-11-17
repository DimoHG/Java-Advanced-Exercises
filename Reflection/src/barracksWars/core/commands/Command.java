package barracksWars.core.commands;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {

    private String[] data;

    public Command(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return data;
    }

}
