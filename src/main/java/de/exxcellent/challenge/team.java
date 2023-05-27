package de.exxcellent.challenge;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class team implements Iteam{
    String teamName = "";
    int games = 0;
    int wins = 0;
    int losses = 0;
    int draws = 0;
    int goals = 0;
    int goalsAllowed = 0;
    int points = 0;

    @Override
    public int getDistance(int goals, int goalsAllowed) {
        return goals - goalsAllowed;
    }

    @Override
    public void fetchData(){

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
            this.teamName = nextLine[0];
            this.games = Integer.parseInt(nextLine[1]);
            this.wins = Integer.parseInt(nextLine[2]);
            this.losses = Integer.parseInt(nextLine[3]);
            this.draws = Integer.parseInt(nextLine[4]);
            this.goals = Integer.parseInt(nextLine[5]);
            this.goalsAllowed = Integer.parseInt(nextLine[6]);
            this.points = Integer.parseInt(nextLine[7]);
        }
    }
}