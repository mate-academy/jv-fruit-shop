package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriteImpl implements Writer {
    @Override
    public boolean writeData(List<String> list, String fileName) {
        try {
            Files.write(Path.of(fileName), list);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
