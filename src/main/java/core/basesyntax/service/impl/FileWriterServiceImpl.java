package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String toFileName, String report) {
        File file = new File(toFileName);
        try {
            Files.write(file.toPath(), report.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't create file " + toFileName);
        }
    }
}
