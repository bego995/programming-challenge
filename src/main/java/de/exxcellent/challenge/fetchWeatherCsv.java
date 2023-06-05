package de.exxcellent.challenge;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fetchWeatherCsv implements fetchData {
    @Override
    public List<weather> getData(String filePath) {
        List<weather> weatherDays = new ArrayList<>();
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
            weather w = new weather(this);
            w.day = Integer.parseInt(nextLine[0]);
            w.mxt = Integer.parseInt(nextLine[1]);
            w.mnt = Integer.parseInt(nextLine[2]);
            weatherDays.add(w);
        }
        return weatherDays;
    }
}
