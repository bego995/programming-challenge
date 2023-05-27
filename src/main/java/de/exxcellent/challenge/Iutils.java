package de.exxcellent.challenge;

import java.util.HashMap;
import java.util.List;

/**
 * @author bilal ranko
 * an interface of necessary functions
 * here we can add functions or override the existing functions to fetch
 * other types of data (such as json.. etc)
 */
public interface Iutils {
    List<team> fetchTeamsData(String filePath) ;
    List<weather> fetchWeatherData(String filePath);
    String assignVariable(HashMap<String, Integer> distances, String dayWithSmallestTempSpread);
    void processTeamData(HashMap<String, Integer> distances, String filePath, utils u);
    void processWeatherData(HashMap<String, Integer> spread, String filePath, utils u);

}
