package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterToCsvImpl implements Writer {
    @Override
    public void writeReport(String path, List<String> list) {
        try {
            Files.write(Path.of(path), list);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + path, e);
        }
    }
}
