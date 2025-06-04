package core.basesyntax.service.write;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(String report, String pathName) {
        try {
            Files.write(Path.of(pathName), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file.. " + pathName, e);
        }
    }
}
