package de.exxcellent.challenge;

import java.util.*;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        //a hashmap of team names and absolute distances
        HashMap<String, Integer> distances = new HashMap<>();
        //a hashmap of day number and it's corresponding spread
        HashMap<String, Integer> spread = new HashMap<>();

        String teamFilePath = "./src/main/resources/de/exxcellent/challenge/football.csv";
        String weatherFilePath = "./src/main/resources/de/exxcellent/challenge/weather.csv";

        //read the csv file and put into the above hashmaps
        utils u = new utils();
        u.processTeamData(distances, teamFilePath, u);
        u.processWeatherData(spread, weatherFilePath, u);


        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        //call the function to assign the right day
        dayWithSmallestTempSpread = u.assignVariable(spread, dayWithSmallestTempSpread);
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        //call the function to assign the right team
        teamWithSmallestGoalSpread = u.assignVariable(distances, teamWithSmallestGoalSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

    }
}
