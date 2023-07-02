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
 * @author bilal ranko
 * this class holds essential functions for the program
 */

public class fetchTeamCsv implements IfetchData {

    @Override
    public List<team> getData(String filePath) {
        List<team> teams = new ArrayList<>();
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
        return teams;
    }

    /*
    //weather data processor. puts spread data into a hashmap
    public void processWeatherData(HashMap<String, Integer> spread, String filePath, utils u) {
        for (de.exxcellent.challenge.weather weather : u.fetchWeatherData(filePath)) {
            spread.put(String.valueOf(weather.day), weather.getSpread(weather.mxt, weather.mnt));
        }
    }*/
}
