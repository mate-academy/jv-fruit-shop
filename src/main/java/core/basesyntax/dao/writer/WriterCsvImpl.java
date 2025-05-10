package core.basesyntax.dao.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterCsvImpl implements WriterCsv {
    @Override
    public void writeToFile(Path filePath, List<String> lines) {
        try {
            Files.write(filePath, lines);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while writing to the file: "
                    + filePath, e);
        }
    }
}
