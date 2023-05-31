package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    private static final String FIRST_LINE = "fruit,quantity";

    @Override
    public void writeDataToFile(String path, List<String> lines) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(path))) {
            writeFirstLineToFile(bufferedWriter);
            lines.forEach(line -> {
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
