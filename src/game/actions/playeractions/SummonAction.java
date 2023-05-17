package game.actions.playeractions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.archetypes.Archetype;
import game.actors.nonplayercharacters.Ally;
import game.actors.nonplayercharacters.enemies.Invader;
import game.controllers.ArchetypeManager;
import game.utils.RandomNumberGenerator;

public class SummonAction extends Action {

    private Location summonLocation;

    public SummonAction(Location summonLocation){
        this.summonLocation = summonLocation;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        boolean hasFoundExit = false;
        int num  =  RandomNumberGenerator.getRandomInt(1,4);
        Archetype archetype = ArchetypeManager.getInstance().chooseArchetype(num);
        Actor summonActor;

        if (RandomNumberGenerator.getRandomInt(100) < 50){
            summonActor =  new Ally(archetype);
        }else{
            summonActor =  new Invader(archetype);
        }

        int i = 0;
        while (i< summonLocation.getExits().size() && !hasFoundExit){
            Location exitLocation = summonLocation.getExits().get(i).getDestination();
            if (!exitLocation.containsAnActor()){
                exitLocation.addActor(summonActor);
                hasFoundExit = true;
            }
            i++;
        }
        if (hasFoundExit){
            result += summonActor + " has arrived. Prepare for battle";
        }
        else{
            result += "No guest is summoned";
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " summons a guest from another realm";
    }
}
