package barracksWars.models.units;

public class Gunner extends AbstractUnit{
    public static final int GUNNER_HEALTH = 20;
    public static final int GUNNER_DAMAGE = 20;
    public Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }
}
