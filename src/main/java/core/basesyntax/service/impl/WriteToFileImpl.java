package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteToFileImpl implements Writer {

    @Override
    public void writeReport(String data, String outputPath) {
        try {
            Files.writeString(Path.of(outputPath), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file "
                   + outputPath + System.lineSeparator(), e);
        }
    }
}
