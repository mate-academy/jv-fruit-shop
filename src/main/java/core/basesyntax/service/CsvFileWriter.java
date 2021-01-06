package core.basesyntax.service;

import com.opencsv.CSVWriter;
import core.basesyntax.model.Fruit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class CsvFileWriter implements FilesWriter {
    private static final String[] HEAD = {"fruit", "quantity"};

    @Override
    public void write(Map<Fruit, Integer> report, String fileName) {
        try (CSVWriter writer = new CSVWriter(Files.newBufferedWriter(Path.of(fileName)),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)) {
            writer.writeNext(HEAD);
            for (Map.Entry<Fruit, Integer> entry : report.entrySet()) {
                writer.writeNext(new String[]{entry.getKey().getName(),
                        String.valueOf(entry.getValue())});
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName);
        }
    }
}
