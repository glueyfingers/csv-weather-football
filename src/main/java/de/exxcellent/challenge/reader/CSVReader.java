package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.App;
import de.exxcellent.challenge.model.CSVFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CSVReader {


    public static final String DELIMITER = ",";

    public CSVFile readFile(String file) {

        String line;
        boolean firstLine = true;
        CSVFile csvFile = null;
        try (InputStream in = App.class.getResourceAsStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))){
            csvFile = new CSVFile();
            while  ((line = reader.readLine()) != null) {
                if (firstLine) {
                    readHeader(csvFile.getHeader(), line);
                    firstLine = false;
                } else {
                    readData(csvFile.getHeader(), csvFile.getData(), line);
               }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return csvFile;
    }

    private void readHeader(List<String>emptyHeader, String line) {
        emptyHeader.addAll(Arrays.asList(line.split(DELIMITER)));
    }

    private void readData(List<String> header, List<Map<String, String>> data, String line) {
        AtomicInteger i = new AtomicInteger();
        Map<String, String> dataEntry = new HashMap<>();
        Arrays.stream(line.split(DELIMITER)).forEach(value -> {
            dataEntry.put(header.get(i.get()), value);
            i.getAndIncrement();
        });
        data.add(dataEntry);
    }

}
