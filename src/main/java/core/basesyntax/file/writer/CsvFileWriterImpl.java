package core.basesyntax.file.writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileWriterImpl implements CsvFileWriter {
    @Override
    public void writeDataToFile(File file, List<String> report) {
        try {
            Files.write(Path.of(file.getPath()), report);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write data to file " + file.getPath(), e);
        }
    }
}
