package core.basesyntax.fileservice;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import core.basesyntax.validation.Validator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSVFileService implements FileService {
    private final Validator validator;

    public CSVFileService(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<String[]> readFromFile(String filePath) {
        List<String[]> list = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            while (csvReader.readNext() != null) {
                String[] record = csvReader.readNext();
                if (validator.isValidRecord(record)) {
                    list.add(record);
                }
            }
        } catch (IOException | CsvException e) {
            throw new RuntimeException("Can't read from file by path: " + filePath, e);
        }
        return list;
    }

    @Override
    public void writeToFile(Map<String, Integer> balance, String filePath) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(new File(filePath)))) {
            for (Map.Entry<String, Integer> entry : balance.entrySet()) {
                csvWriter.writeNext(new String[]{entry.getKey(), String.valueOf(entry.getValue())});
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
