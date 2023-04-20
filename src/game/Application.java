package game;

import game.actors.Player;
import game.actors.enemies.GiantCrab;
import game.actors.enemies.HeavySkeletalSwordsman;
import game.actors.enemies.LoneWolf;
import game.environments.*;

import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPInputStream;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Graveyard(), new GustOfWind(), new PuddleOfWater());

		List<String> map = Arrays.asList(
				"..............n............................................................",
				"...~..................#####....######...........&.....................&....",
				"......................#..___....____#......................................",
				"..............~...................__#..................&...................",
				".......~..............._____........#........n........................n....",
				"......................#............_#......................................",
				"......................#...........###......................................",
				"...........................................................................",
				"...........................................................................",
				"..................................###___###................................",
				"..................................________#................................",
				"..................................#________................................",
				"..................................#_______#................................",
				"..................................###___###................................",
				"....................................#___#..................................",
				"...........................................................................",
				"...........................................................................",
				"...........................................................................",
				"..####__##....................................................######..##...",
				"..#.....__....................................................#....____....",
				"..#___..........................................................__.....#...",
				"..####__###..................................................._.....__.#...",
				"..............................................................###..__###...",
				"...........................................................................");
		GameMap gameMap = new GameMap(groundFactory, map);
		world.addGameMap(gameMap);

		/*
		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		 */

//		gameMap.at(30, 10).addActor(new LoneWolf());
//
		gameMap.at(29, 10).addActor(new GiantCrab());
		gameMap.at(28, 15).addActor(new GiantCrab());
		gameMap.at(29, 11).addActor(new GiantCrab());
		gameMap.at(28, 12).addActor(new GiantCrab());
		gameMap.at(29, 13).addActor(new GiantCrab());
		gameMap.at(28, 14).addActor(new GiantCrab());
//
//		gameMap.at(27, 10).addActor(new HeavySkeletalSwordsman());
//		gameMap.at(26, 10).addActor(new HeavySkeletalSwordsman());
//		gameMap.at(50, 11).addActor(new HeavySkeletalSwordsman());
//		gameMap.at(49, 10).addActor(new LoneWolf());
//		gameMap.at(50, 9).addActor(new GiantCrab());

		// HINT: what does it mean to prefer composition to inheritance?
		Player player = new Player("Tarnished", '@', 300);
		world.addPlayer(player, gameMap.at(50, 10));

		world.run();
	}
}
