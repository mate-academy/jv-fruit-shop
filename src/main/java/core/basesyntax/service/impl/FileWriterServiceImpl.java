package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String ERROR_MSG = "Can't write to file: ";

    @Override
    public void write(String report, String toFileName) {
        Path outputPath = Path.of(toFileName);

        File file = new File(toFileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MSG + outputPath, e);
        }
    }
}
