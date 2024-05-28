package core.basesyntax.writer;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterImpl implements CsvWriter {
    @Override
    public void writeToCsv(String data, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + fileName, e);
        }
    }
}
