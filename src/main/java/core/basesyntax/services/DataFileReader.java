package core.basesyntax.services;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader {
    private static final int PARTS_OF_LINE = 4;

    public List<String[]> readDataFromFile(String inputFilePath) {
        List<String[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length != PARTS_OF_LINE) {
                    continue;
                }
                data.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
