package core.basesyntax.inout;

import core.basesyntax.exception.DataProcessingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvWriter implements ReportWriter {

    @Override
    public void write(String path, String content) {
        try {
            Files.writeString(Path.of(path), content);
        } catch (IOException e) {
            throw new DataProcessingException("Can't write to file: " + path, e);
        }
    }
}
