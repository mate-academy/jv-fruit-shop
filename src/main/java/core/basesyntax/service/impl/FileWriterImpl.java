package core.basesyntax.service.impl;

import core.basesyntax.exception.WriteToFileException;
import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterImpl implements FileWriter {

    @Override
    public void writeTo(String filePath, List<String> rows) {
        try {
            Files.write(Path.of(filePath), rows);
        } catch (IOException e) {
            throw new WriteToFileException("Can't write to file " + filePath);
        }
    }
}
