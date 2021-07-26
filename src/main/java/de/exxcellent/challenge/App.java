package de.exxcellent.challenge;

import de.exxcellent.challenge.analysis.FootballAnalysis;
import de.exxcellent.challenge.analysis.WeatherAnalysis;
import de.exxcellent.challenge.reader.CSVReader;

import java.io.*;
import java.util.Map;

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

        // String filename = "/de/exxcellent/challenge/weather.csv"

        Map<String, String> day = new WeatherAnalysis()
                .smallestSpread(new CSVReader().readFile("/de/exxcellent/challenge/weather.csv"));

        Map<String, String> team = new FootballAnalysis()
                .smallestDistance(new CSVReader().readFile("/de/exxcellent/challenge/football.csv"));


        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", day.get(WeatherAnalysis.DAY));

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", team.get(FootballAnalysis.TEAM));
    }
}
