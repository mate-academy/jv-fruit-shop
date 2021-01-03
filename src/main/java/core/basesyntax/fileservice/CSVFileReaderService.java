package core.basesyntax.fileservice;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import core.basesyntax.validation.CSVValidator;
import core.basesyntax.validation.Validator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSVFileReaderService implements FileReaderService {
    @Override
    public List<String[]> readFromFile(String filePath) {
        List<String[]> list = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] record;
            while ((record = csvReader.readNext()) != null) {
                list.add(record);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file by path: " + filePath, e);
        } catch (CsvValidationException e) {
            throw new RuntimeException("Invalid file " + filePath, e);
        }
        return list;
    }
}
