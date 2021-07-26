package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.model.CSVFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CSVReaderTest {
    private CSVReader reader;

    @BeforeEach
    void setUp() {
        reader = new CSVReader();
    }

    @Test
    void readFile_noValidFile_throwException(){
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> reader.readFile("filename"), "IO exception was expected");
    }

    @Test
    void readFile_validFile_returnCSVObject() {
        CSVFile csv = reader.readFile("/validFile.csv");
        assertNotNull(csv);
    }

    @Test
    void readFile_validFileWithHeader_returnCSVFileHasHeader() {
        CSVFile csv = reader.readFile("/validFile.csv");
        assertNotNull(csv.getHeader());
        assertEquals(2, csv.getHeader().size());
    }

    @Test
    void readFile_validFileWithContent_returnCSVFileHasData() {
        CSVFile csv = reader.readFile("/validFile.csv");
        assertNotNull(csv.getData());
        assertEquals(1, csv.getData().size());
    }
}
