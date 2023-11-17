package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataWriterImpl implements DataWriter {
    @Override
    public void write(List<String> strings, String filePath) {
        String content = String.join(System.lineSeparator(), strings);
        try {
            Files.writeString(Path.of(filePath), content);
        } catch (IOException e) {
            throw new RuntimeException("Unable to write data to the specified path: " + filePath
                    + ". Data: " + strings, e);
        }
    }
}
