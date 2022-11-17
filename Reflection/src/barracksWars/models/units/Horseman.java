package barracksWars.models.units;

public class Horseman extends AbstractUnit{
    public static final int HORSEMAN_HEALTH = 50;
    public static final int HORSEMAN_DAMAGE = 10;
    public Horseman() {
        super(HORSEMAN_HEALTH, HORSEMAN_DAMAGE);
    }
}
