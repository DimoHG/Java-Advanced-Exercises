package christmasRaces.entities.drivers;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.entities.cars.Car;

public class DriverImpl implements Driver {
    public final static int NAME_LENGTH = 5;

    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        this.setName(name);
        this.canParticipate = false;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < NAME_LENGTH) {
            String exceptionMessage = String.format(ExceptionMessages.INVALID_NAME, name, NAME_LENGTH);
            throw new IllegalArgumentException(exceptionMessage);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if(car == null){
            String exceptionMessage = String.format(ExceptionMessages.CAR_INVALID, car);
        throw new IllegalArgumentException(exceptionMessage);
        }
        this.car = car;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return car != null;
    }
}
