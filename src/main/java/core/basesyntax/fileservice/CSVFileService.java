package core.basesyntax.fileservice;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    public void writeToFile(List<String[]> records, String filePath) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            for (String[] record : records) {
                csvWriter.writeNext(record);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
