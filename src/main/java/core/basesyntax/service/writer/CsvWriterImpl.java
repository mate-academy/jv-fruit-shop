package core.basesyntax.service.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvWriterImpl implements CsvWriter {
    @Override
    public void writeToFile(Path filePath, List<String> info) {
        try {
            Files.write(filePath, info);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while writing to the file: "
                    + e.getMessage());
        }
    }
}
