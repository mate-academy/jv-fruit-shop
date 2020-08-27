package core.basesyntax.service;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileHandler {
    public List<String[]> processFile(String csvInputFile) {
        List<String[]> listOfCommands = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvInputFile))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                listOfCommands.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("No such file for input");
        }
        return listOfCommands;
    }
}
