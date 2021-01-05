package core.basesyntax.service;

import com.opencsv.CSVWriter;
import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class CsvFileWriter implements FilesWriter {
    private final String[] head = {"fruit", "quantity"};

    @Override
    public void write(String fileName) {
        try (CSVWriter writer = new CSVWriter(Files.newBufferedWriter(Path.of(fileName)),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)) {
            writer.writeNext(head);
            for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
                writer.writeNext(new String[]{entry.getKey().getName(),
                        String.valueOf(entry.getValue())});
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName);
        }
    }
}
