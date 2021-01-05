package core.basesyntax.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.validation.CSVValidator;
import core.basesyntax.validation.Validator;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReaderService implements FileReaderService {
    @Override
    public List<Transaction> readFromFile(String filePath) {
        Validator validator = new CSVValidator();
        List<Transaction> list = new ArrayList<>();
        String[] line;
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            while ((line = reader.readNext()) != null) {
                if (validator.isValidLine(line)) {
                    list.add(new Transaction(Operation.getOperation(line[0]),
                            new Fruit(line[1]), Integer.valueOf(line[2])));
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Can't read from file by path: " + filePath, e);
        }
        return list;
    }
}
