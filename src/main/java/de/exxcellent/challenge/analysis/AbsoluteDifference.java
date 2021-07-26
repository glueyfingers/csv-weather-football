package de.exxcellent.challenge.analysis;

import java.util.Comparator;
import java.util.Map;

public class AbsoluteDifference implements Comparator<Map<String, String>> {
    private final String firstField;
    private final String secondField;

    public AbsoluteDifference(String firstField, String secondField) {
        this.firstField = firstField;
        this.secondField = secondField;
    }

    @Override
    public int compare(Map<String, String> firstSet, Map<String, String> secondSet) {
        int firstDiff = getDifference(firstSet);
        int secondDiff = getDifference(secondSet);
        return Integer.compare(firstDiff, secondDiff);
    }

    private int getDifference(Map<String, String> data) {
        int minValue = Integer.parseInt(data.get(firstField));
        int maxValue = Integer.parseInt(data.get(secondField));
        return Math.abs(maxValue - minValue);
    }
}
