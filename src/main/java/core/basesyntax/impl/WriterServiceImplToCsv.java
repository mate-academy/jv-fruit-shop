package core.basesyntax.impl;

import core.basesyntax.servise.WriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class WriterServiceImplToCsv implements WriterService {
    @Override
    public void writeToFile(String report, String filePath) {
        Path path = Path.of(filePath);
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: "
                    + path.getFileName(), e);
        }
    }
}
