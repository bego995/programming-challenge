package de.exxcellent.challenge;

import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Iteam {
    public int getDistance(int goals, int goalsAllowed);
    public void fetchData();
}
