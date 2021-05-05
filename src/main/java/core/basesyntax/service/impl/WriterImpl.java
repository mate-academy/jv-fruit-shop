package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriterImpl implements Writer {

    @Override
    public boolean writer(String report, String toFilePath) {
        File file = new File(toFilePath);
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to a file", e);
        }
        return true;
    }
}
