package de.exxcellent.challenge.analysis;

import de.exxcellent.challenge.model.CSVFile;

import java.util.Map;

public class FootballAnalysis {
    public static final String TEAM = "Team";
    static final String GOALS = "Goals";
    static final String GOALS_ALLOWED = "Goals Allowed";

    public Map<String, String> smallestDistance(CSVFile csvFile) {
        return csvFile.getData()
                .stream()
                .min(new AbsoluteDifference(GOALS, GOALS_ALLOWED))
                .orElseThrow();
    }
}
