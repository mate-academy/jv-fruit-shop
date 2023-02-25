package core.basesyntax.service.imp;

import core.basesyntax.db.Storage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterService {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String CSV_SEPARATOR = ",";

    public void writeFile(String name) {
        File file = new File(name);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(FIRST_LINE + System.lineSeparator());
            for (Map.Entry<String, Integer> fruit : Storage.fruits.entrySet()) {
                bufferedWriter.write(fruit.getKey() + CSV_SEPARATOR
                        + fruit.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write in file " + file, e);
        }
    }
}
