package game.actors.enemies.skeletalenemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.resets.Resettable;
import game.resets.ResetManager;
import game.weapons.portableweapons.Grossmesser;

public class HeavySkeletalSwordsman extends Skeletal implements Resettable {

  private static final int SPAWN_CHANCE = 27;
  private static final int DESPAWN_CHANCE = 10;
  private static final int HIT_POINTS = 153;
  private static final int MIN_RUNES_AWARD = 35;
  private static final int MAX_RUNES_AWARD = 892;

  /**
   * Constructor.
   *
   */
  public HeavySkeletalSwordsman(){
    super("Heavy Skeletal Swordsman", 'q', HIT_POINTS, SPAWN_CHANCE, DESPAWN_CHANCE, MIN_RUNES_AWARD, MAX_RUNES_AWARD);
    this.addWeaponToInventory(new Grossmesser());
    ResetManager.getInstance().registerResettable(this);
  }

  @Override
  public void reset() {
    if (this.getMap() != null){
      getMap().removeActor(this);
    }
  }
}
