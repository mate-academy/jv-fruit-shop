package core.basesyntax.writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriterImpl implements WriterService {

    @Override
    public void writeDataToFile(String report, String path) {

        File file = new File(path);

        try {
            Files.write(file.toPath(), report.getBytes());

        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);

        }
    }
}
