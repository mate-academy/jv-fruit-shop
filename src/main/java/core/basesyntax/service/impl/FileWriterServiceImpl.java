package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileWriterServiceImpl implements FileWriterService {
    public void writeToFile(String fileName, List<String> lines) {
        File file = new File(fileName);
        try {
            file.createNewFile();
            Files.write(Paths.get(file.getPath()), lines);
        } catch (IOException e) {
            throw new RuntimeException("Can't create file or write: " + fileName, e);
        }
    }
}
