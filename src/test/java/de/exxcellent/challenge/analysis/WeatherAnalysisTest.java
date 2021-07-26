package de.exxcellent.challenge.analysis;

import de.exxcellent.challenge.model.CSVFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static de.exxcellent.challenge.analysis.WeatherAnalysis.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


public class WeatherAnalysisTest {
    @Mock
    private CSVFile csvFile;

    private WeatherAnalysis analysis;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        analysis = new WeatherAnalysis();
    }

    @Test
    void smallestSpread_noData_ThrowException() {
        NoSuchElementException thrown = assertThrows(NoSuchElementException.class, () -> analysis.smallestSpread(csvFile));
    }

    @Test
    void smallestSpread_weatherData_ReturnNotNull() {
        when(csvFile.getData()).thenReturn(createWeatherData());
        Map<String, String> day =  analysis.smallestSpread(csvFile);
        assertNotNull(day);
    }

    @Test
    void smallestSpread_weatherData_ReturnSmallestTempSpread() {
        when(csvFile.getData()).thenReturn(createWeatherData());
        Map<String, String> day =  analysis.smallestSpread(csvFile);
        assertEquals("2", day.get(DAY));
    }

    private List<Map<String, String>> createWeatherData() {
        List<Map<String, String>> weatherData = new ArrayList<>();
        weatherData.add(createEntry("1","1","7"));
        weatherData.add(createEntry("2","2","3"));
        weatherData.add(createEntry("3","2","5"));
        return weatherData;
    }

    private Map<String, String> createEntry(String day, String min, String max) {
        Map<String, String> entry = new HashMap<>();
        entry.put(DAY, day);
        entry.put(MIN_TEMPERATURE, min);
        entry.put(MAX_TEMPERATURE, max);
        return entry;
    }
}
