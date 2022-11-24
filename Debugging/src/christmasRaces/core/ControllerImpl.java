package christmasRaces.core;


import christmasRaces.common.ExceptionMessages;
import christmasRaces.common.OutputMessages;
import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class ControllerImpl implements Controller {

    public final static int MIN_COUNT_PARTICIPANTS = 3;

    private Repository<Driver>  driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driverName) {
        if (driverRepository.getByName(driverName) != null) {
            String exceptionMessage = String.format(ExceptionMessages.DRIVER_EXISTS, driverName);
            throw new IllegalArgumentException(exceptionMessage);
        }

        Driver driver = new DriverImpl(driverName);
        driverRepository.add(driver);

        return String.format(OutputMessages.DRIVER_CREATED, driverName);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        if (carRepository.getByName(model) != null) {
            String exceptionMessage = String.format(ExceptionMessages.CAR_EXISTS, model);
            throw new IllegalArgumentException(exceptionMessage);
        }

        Car car = null;

        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
        }
        carRepository.add(car);

        return String.format(OutputMessages.CAR_CREATED, type + "Car", model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {

        Driver driver = getDriverIfExists(driverName);

        Car car = getCarIfExists(carModel);

        driver.addCar(car);

        return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {

        Race race = getRaceIfExists(raceName);

        Driver driver = getDriverIfExists(driverName);

        race.addDriver(driver);

        return String.format(OutputMessages.DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String createRace(String name, int laps) {

        Race race = raceRepository.getByName(name);
        if (race != null) {
            String exceptionMessage = String.format(ExceptionMessages.RACE_EXISTS, name);
            throw new IllegalArgumentException(exceptionMessage);
        }

        Race newRace = new RaceImpl(name, laps);

        raceRepository.add(newRace);

        return String.format(OutputMessages.RACE_CREATED, name);
    }

    @Override
    public String startRace(String raceName) {

        Race race = getRaceIfExists(raceName);

        if (race.getDrivers().size() < MIN_COUNT_PARTICIPANTS) {
            String exceptionMessage = String.format(ExceptionMessages.RACE_INVALID, MIN_COUNT_PARTICIPANTS);
            throw new IllegalArgumentException(exceptionMessage);
        }

        Collection<Driver> drivers = race.getDrivers();
        int numOfLaps = race.getLaps();

        List<Driver> winners = drivers.stream()
                .sorted((f, s) -> Double.compare (s.getCar().calculateRacePoints(numOfLaps), f.getCar().calculateRacePoints(numOfLaps)))
                .limit(3)
                .collect(Collectors.toList());

        raceRepository.remove(race);

        StringBuilder sb = new StringBuilder();

        sb.append(String.format(OutputMessages.DRIVER_FIRST_POSITION, winners.get(0).getName(), race.getName()))
                .append(System.lineSeparator())
                .append(String.format(OutputMessages.DRIVER_SECOND_POSITION, winners.get(1).getName(), race.getName()))
                .append(System.lineSeparator())
                .append(String.format(OutputMessages.DRIVER_THIRD_POSITION, winners.get(2).getName(), race.getName()));

        return sb.toString().trim();
    }

    private Car getCarIfExists(String carModel) {
        Car car = carRepository.getByName(carModel);
        if (car == null) {
            String exceptionMessage = String.format(ExceptionMessages.CAR_NOT_FOUND, carModel);
            throw new IllegalArgumentException(exceptionMessage);
        }
        return car;
    }

    private Driver getDriverIfExists(String driverName) {
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            String exceptionMessage = String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName);
            throw new IllegalArgumentException(exceptionMessage);
        }
        return driver;
    }

    private Race getRaceIfExists(String raceName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            String exceptionMessage = String.format(ExceptionMessages.RACE_NOT_FOUND, raceName);
            throw new IllegalArgumentException(exceptionMessage);
        }
        return race;
    }
}
