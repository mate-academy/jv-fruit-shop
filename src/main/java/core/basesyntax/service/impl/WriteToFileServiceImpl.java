package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToFileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteToFileServiceImpl implements WriteToFileService {
    private static final String PATH_TO_REPORT = "src/main/resources/report.csv";

    @Override
    public void writeToFile(String report) {
        Path path = Paths.get(PATH_TO_REPORT);

        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException("File can't be created.", e);
            }
        }

        try {
            Files.write(path, report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("It is impossible to write to file "
                                        + PATH_TO_REPORT, e);
        }
    }
}
