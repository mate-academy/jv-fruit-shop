package core.basesyntax.service.impl;

import core.basesyntax.service.ServiceWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ServiceWriterImpl implements ServiceWriter {
    @Override
    public void writeFile(String toFileName, String data) {
        try {
            Files.write(Path.of(toFileName), data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}
