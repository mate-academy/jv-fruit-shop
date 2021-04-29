package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class WriterServiceImpl implements WriterService {
    @Override
    public void createReportFromData(String pathName, String report) {
        File file = new File(pathName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file");
        }

        try {
            Files.writeString(file.toPath(), report, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data into the file");
        }
    }
}
