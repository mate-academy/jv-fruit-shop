package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(String toFileName, String report) {
        File file = new File(toFileName);
        try {
            if (file.exists()) {
                Files.write(file.toPath(), report.getBytes(), StandardOpenOption.APPEND);
            } else {
                file.createNewFile();
                Files.write(file.toPath(), report.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + toFileName, e);
        }
    }
}
