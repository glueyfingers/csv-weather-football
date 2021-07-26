package de.exxcellent.challenge.analysis;

import de.exxcellent.challenge.model.CSVFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static de.exxcellent.challenge.analysis.FootballAnalysis.*;
import static de.exxcellent.challenge.analysis.WeatherAnalysis.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class FootballAnalysisTest {
    @Mock
    private CSVFile csvFile;

    private FootballAnalysis analysis;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        analysis = new FootballAnalysis();
    }

    @Test
    void smallestDistance_noData_ThrowException() {
        NoSuchElementException thrown = assertThrows(NoSuchElementException.class, () -> analysis.smallestDistance(csvFile));
    }

    @Test
    void smallestDistance_footballData_ReturnNotNull() {
        when(csvFile.getData()).thenReturn(createFootballData());
        Map<String, String> day =  analysis.smallestDistance(csvFile);
        assertNotNull(day);
    }

    private List<Map<String, String>> createFootballData() {
        List<Map<String, String>> weatherData = new ArrayList<>();
        weatherData.add(createEntry("Team1","1","7"));
        weatherData.add(createEntry("Team2","2","3"));
        weatherData.add(createEntry("Team3","2","5"));
        return weatherData;
    }

    private Map<String, String> createEntry(String team, String goals, String goalsAllowed) {
        Map<String, String> entry = new HashMap<>();
        entry.put(TEAM, team);
        entry.put(GOALS, goals);
        entry.put(GOALS_ALLOWED, goalsAllowed);
        return entry;
    }
}
