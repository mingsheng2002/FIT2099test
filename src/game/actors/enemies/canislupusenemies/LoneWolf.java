package game.actors.enemies.canislupusenemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.resets.Resettable;
import game.actors.enemies.Enemy;
import game.behaviours.AttackBehaviour;
import game.resets.ResetManager;
import game.enums.Status;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class LoneWolf extends CanisLupus implements Resettable {

    private static final int SPAWN_CHANCE = 33;
    private static final int DESPAWN_CHANCE = 10;
    private static final int HIT_POINTS = 102;
    private static final int DAMAGE = 97;
    private static final int HIT_RATE = 95;
    private static final int MIN_RUNES_AWARD = 55;
    private static final int MAX_RUNES_AWARD = 1470;

    /**
     * Constructor.
     *
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', HIT_POINTS, SPAWN_CHANCE, DESPAWN_CHANCE, MIN_RUNES_AWARD, MAX_RUNES_AWARD);
        ResetManager.getInstance().registerResettable(this);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(DAMAGE, "bites", HIT_RATE);
    }

    @Override
    public void reset() {
        if (this.getMap() != null ){
            getMap().removeActor(this);
        }
    }
}
