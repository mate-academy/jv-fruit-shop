package core.basesyntax.serviceImpl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriterServiceImpl implements WriterService {

    @Override
    public void WriteToFile(String filePath, String report) {
        Path path = Paths.get(filePath);
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException("File was not created", e);
            }
        }
        try {
            Files.writeString(path, report);
        } catch (IOException e) {
            throw new RuntimeException("Report was not written to file", e);
        }
    }
}
