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
    List<team> fetchTeamsData() ;
    List<weather> fetchWeatherData();

    String assignTeam(HashMap<String, Integer> distances, String dayWithSmallestTempSpread);
}
