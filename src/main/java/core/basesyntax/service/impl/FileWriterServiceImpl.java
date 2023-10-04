package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void writeToFile(List<String> strings, String filePath) {
        try {
            Files.write(Paths.get(filePath), strings);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + filePath, e);
        }
    }
}
