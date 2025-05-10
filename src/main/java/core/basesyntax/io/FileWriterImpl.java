package core.basesyntax.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterImpl implements FileWriter {

    @Override
    public void writer(List<String> report, String fileName) {

        Path filePath = Path.of(fileName);

        try {
            Files.write(filePath, report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write files", e);
        }
    }
}
