package de.exxcellent.challenge;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    static List<team> teams = new ArrayList<>();
    public static void fetchTeamData(){

        String filePath = "./src/main/resources/de/exxcellent/challenge/football.csv";
        FileReader fr;
        try {
            fr = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            throw new RuntimeException(e);
        }

        CSVParser csvParser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(true)
                .build();
        CSVReader csvReader = new CSVReaderBuilder(fr)
                .withSkipLines(1)
                .withCSVParser(csvParser)
                .build();
        String[] nextLine;
        while (true) {
            try {
                if ((nextLine = csvReader.readNext()) == null) break;
            } catch (IOException | CsvValidationException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Arrays.toString(nextLine));
            team t = new team();
            t.teamName = nextLine[0];
            t.games = Integer.parseInt(nextLine[1]);
            t.wins = Integer.parseInt(nextLine[2]);
            t.losses = Integer.parseInt(nextLine[3]);
            t.draws = Integer.parseInt(nextLine[4]);
            t.goals = Integer.parseInt(nextLine[5]);
            t.goalsAllowed = Integer.parseInt(nextLine[6]);
            t.points = Integer.parseInt(nextLine[7]);
            teams.add(t);
        }
    }

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        HashMap<Integer, String> distances = new HashMap<>();
        fetchTeamData();
        for (de.exxcellent.challenge.team team : teams) {
            distances.put(team.getDistance(team.goals, team.goalsAllowed), team.teamName);
        }
        System.out.println(distances);
        System.out.println(Collections.max(distances.values()));

        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
