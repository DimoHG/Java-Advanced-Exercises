package christmasRaces.entities.races;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

public class RaceImpl implements Race {

    private final static int NAME_LENGTH = 5;
    private final static int MIN_LAPS = 1;

    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        this.name = name;
        this.laps = laps;
        this.drivers = new ArrayList<>();
    }

    private void setName(String name){
        if (name == null || name.trim().length() < NAME_LENGTH) {
            String exceptionMessage = String.format(ExceptionMessages.INVALID_NAME, name, NAME_LENGTH);
            throw new IllegalArgumentException(exceptionMessage);
        }
        this.name = name;
    }

    private void setLaps(int laps) {
        if(laps < MIN_LAPS) {
            String exceptionMessage = String.format(ExceptionMessages.INVALID_NUMBER_OF_LAPS, MIN_LAPS);
            throw new IllegalArgumentException(exceptionMessage);
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if(driver == null) {
            String exceptionMessage = String.format(ExceptionMessages.DRIVER_INVALID);
            throw new IllegalArgumentException(exceptionMessage);
        } else if(!driver.getCanParticipate()) {
            String exceptionMessage = String.format(ExceptionMessages.DRIVER_NOT_PARTICIPATE, driver.getName());
            throw new IllegalArgumentException(exceptionMessage);
        } else if(drivers.contains(driver)){
            String exceptionMessage = String.format(ExceptionMessages.DRIVER_ALREADY_ADDED, driver.getName(), this.name);
            throw new IllegalArgumentException(exceptionMessage);
        }
        drivers.add(driver);

    }
}
