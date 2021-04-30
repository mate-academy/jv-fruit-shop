package core.basesyntax.FileServise;

import core.basesyntax.FileServise.WriteService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteServiceImpl implements WriteService {
    @Override
    public void write(String report, String filePath) {
        File file = new File(filePath);
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
