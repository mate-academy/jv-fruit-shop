package core.basesyntax.service.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String data, String file) {
        try {
            Files.writeString(Path.of(file), data);
        } catch (IOException e) {
            throw new RuntimeException("Can not write data to file " + file, e);
        }
    }
}
