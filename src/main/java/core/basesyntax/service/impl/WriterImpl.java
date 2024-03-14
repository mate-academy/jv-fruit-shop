package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class WriterImpl implements Writer {
    @Override
    public void writeToFolder(Map<String, String> reports, String pathToFolder) {
        for (Map.Entry<String, String> report : reports.entrySet()) {
            String fileName = report.getKey();
            Path path = Path.of(pathToFolder, fileName);
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write(report.getValue());
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file. File=" + fileName, e);
            }
        }
    }
}
