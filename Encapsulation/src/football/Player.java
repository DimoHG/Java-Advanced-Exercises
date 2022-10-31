package football;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public double overallSkillLevel(){
        return (endurance + dribble + sprint + passing + shooting) / 5.0;
    }

    private void setName(String name) {
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        checkIfInRange(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void checkIfInRange(int value, String propertyName){
        if(value < 0  || value > 100){
            throw new IllegalArgumentException(propertyName + " should be between 0 and 100.");
        }
    }

    private void setSprint(int sprint) {
        checkIfInRange(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if(dribble < 0  || dribble > 100){
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if(passing < 0  || passing > 100){
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if(shooting < 0  || shooting > 100){
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }

    public String getName() {
        return name;
    }
}
