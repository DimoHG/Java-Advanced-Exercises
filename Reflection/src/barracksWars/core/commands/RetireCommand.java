package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class RetireCommand extends Command{
    @Inject
    private Repository repository;

    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        try{
            String unitType = getData()[1];
            repository.removeUnit(unitType);
            return String.format("%s retired!", unitType);
        } catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }
}
