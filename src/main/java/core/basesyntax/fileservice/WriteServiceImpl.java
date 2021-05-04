package core.basesyntax.fileservice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteServiceImpl implements WriteService {
    @Override
    public void writeToFile(String report, String filePath) {
        File file = new File(filePath);
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can not write to file...", e);
        }
    }
}
