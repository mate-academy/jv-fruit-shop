package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterServ;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class CsvFileWriter implements FileWriterServ {
    @Override
    public void write(String report, String filePath) {
        Path path = Path.of(filePath);
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: "
                    + path.getFileName(), e);
        }
    }
}
