package core.basesyntax.service;

import core.basesyntax.db.Storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvWriterService implements DataWriterService {
    private final String path;

    public CsvWriterService(String path) {
        this.path = path;
    }

    @Override
    public void writeData() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write("fruit,quantity" + System.lineSeparator());
            for (Map.Entry<String, Integer> fruitEntry : Storage.FRUIT_STORAGE.entrySet()) {
                bufferedWriter.write(fruitEntry.getKey() + ","
                        + fruitEntry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not write data to report");
        }

    }
}
