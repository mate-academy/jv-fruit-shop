package core.basesyntax.writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriterImpl implements WriterService {

    @Override
    public void writeDataToFile(String report, String path) {
        if (report == null || path == null) {
            throw new RuntimeException("One of parameter is null.");
        }

        File file = new File(path);

        try {
            Files.writeString(file.toPath(), report);

        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + path, e);

        }
    }
}
