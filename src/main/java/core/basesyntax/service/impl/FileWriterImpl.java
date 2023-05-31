package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public void writeDataToFile(String path) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(path))) {
            writeFirstLineToFile(bufferedWriter);
            Storage.STORAGE_MAP.entrySet().stream()
                    .map(entry -> entry.getKey() + COMMA_SEPARATOR
                            + entry.getValue() + System.lineSeparator())
                    .forEach(line -> {
                        try {
                            bufferedWriter.write(line);
                        } catch (IOException e) {
                            throw new RuntimeException("Failed to write to file: " + path, e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException("Failed to open file: " + path, e);
        }
    }

    private void writeFirstLineToFile(BufferedWriter bufferedWriter) throws IOException {
        String firstLine = FIRST_LINE + System.lineSeparator();
        bufferedWriter.write(firstLine);
    }
}
