package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterServiceImpl implements WriterService {

    private static final int LINE_OFFSET = 1;

    @Override
    public void writeToFile(List<String> data, String filePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(filePath))) {
            if (data != null) {
                for (int i = 0; i < data.size() - LINE_OFFSET; i++) {
                    writer.write(data.get(i));
                    writer.newLine();
                }
                writer.write(data.get(data.size() - LINE_OFFSET));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing a file: " + filePath, e);
        }
    }
}
