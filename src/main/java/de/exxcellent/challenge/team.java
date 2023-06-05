package de.exxcellent.challenge;

/**
 * @author bilal ranko
 * team class with corresponding fields. they are fetched by the utils class
 */

public class team implements Iteam{
    String teamName = "";
    int games = 0;
    int wins = 0;
    int losses = 0;
    int draws = 0;
    int goals = 0;
    int goalsAllowed = 0;
    int points = 0;

    fetchData fetchTeamDataCsv;

    public team(fetchData fetchTeamDataCsv){
        this.fetchTeamDataCsv = fetchTeamDataCsv;
    }
    @Override
    public int getAbsDistance(int goals, int goalsAllowed) {
        return Math.abs(goals - goalsAllowed);
    }
}