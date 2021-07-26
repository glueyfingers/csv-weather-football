package de.exxcellent.challenge.analysis;

import de.exxcellent.challenge.model.CSVFile;

import java.util.Comparator;
import java.util.Map;

public class WeatherAnalysis {
    public static final String DAY = "Day";
    static final String MAX_TEMPERATURE = "MxT";
    static final String MIN_TEMPERATURE = "MnT";

    public Map<String, String> smallestSpread(CSVFile csvFile) {
        return csvFile.getData()
                .stream()
                .min(new AbsoluteDifference(MIN_TEMPERATURE, MAX_TEMPERATURE))
                .orElseThrow();
    }

}
