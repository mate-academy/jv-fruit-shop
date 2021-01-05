package core.basesyntax.service.impl;

import com.opencsv.CSVWriter;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterService implements FileWriterService {
    @Override
    public void writeToFile(Map<Fruit, Integer> balance, String filePath) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(new File(filePath)))) {
            for (Map.Entry<Fruit, Integer> entry : balance.entrySet()) {
                String[] record = new String[]{entry.getKey().getName(),
                        String.valueOf(entry.getValue())};
                csvWriter.writeNext(record);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
