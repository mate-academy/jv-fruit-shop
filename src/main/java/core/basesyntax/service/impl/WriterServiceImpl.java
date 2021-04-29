package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class WriterServiceImpl implements WriterService {
    private static final String EXCEPTION_MESSAGE = "Can't write data into the file";

    @Override
    public void write(String pathName, String data) {
        try {
            Files.writeString(new File(pathName).toPath(), data, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
    }
}
