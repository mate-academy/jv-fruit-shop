package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriterImpl implements Writer {
    @Override
    public void writeFile(String list, String outputFileName) {
        File file = new File(outputFileName);
        try {
            Files.write(file.toPath(), list.getBytes());
        } catch (IOException o) {
            throw new RuntimeException("Can't created file " + outputFileName);
        }
    }
}
