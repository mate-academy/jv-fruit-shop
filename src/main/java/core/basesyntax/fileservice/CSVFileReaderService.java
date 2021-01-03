package core.basesyntax.fileservice;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import core.basesyntax.validation.CSVValidator;
import core.basesyntax.validation.Validator;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSVFileReaderService implements FileReaderService {
    @Override
    public List<String[]> readFromFile(String filePath) {
        Validator validator = new CSVValidator();
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
}
