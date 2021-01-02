package core.basesyntax;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileService implements FileService {
    @Override
    public List<String[]> readFromFile(String filePath) {
        List<String[]> list;
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            list = csvReader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        return list;
    }

    @Override
    public void writeToFile(String filePath) {

    }
}
