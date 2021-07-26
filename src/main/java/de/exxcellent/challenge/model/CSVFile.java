package de.exxcellent.challenge.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class CSVFile {
    List<String> header = new ArrayList<>();
    List<Map<String, String>> data = new ArrayList<>();
}
