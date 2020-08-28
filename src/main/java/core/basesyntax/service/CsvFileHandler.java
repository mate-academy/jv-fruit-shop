package core.basesyntax.service;

import com.opencsv.CSVReader;
import core.basesyntax.model.Command;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileHandler {
    public List<Command> processFile(String csvInputFile) {
        List<Command> listOfCommands = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvInputFile))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                listOfCommands.add(new Command(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("No such file for input");
        }
        return listOfCommands;
    }
}
