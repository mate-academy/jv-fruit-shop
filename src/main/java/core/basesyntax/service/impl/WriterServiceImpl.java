package core.basesyntax.service.impl;

import core.basesyntax.exceptions.WriteReportToFileException;
import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeReportToFile(String pathToFile, String report) {
        File file = new File(pathToFile);
        try {
            file.createNewFile();
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new WriteReportToFileException("Can't write data to file " + pathToFile, e);
        }
    }
}
