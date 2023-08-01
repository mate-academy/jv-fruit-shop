package core.basesyntax.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterCsvFile {

    public void writeReport(String report, String toFileName) {
        try {
            Files.write(Path.of(toFileName), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file, ", e);
        }
    }

}
