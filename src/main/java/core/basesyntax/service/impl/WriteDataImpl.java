package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriteDataImpl implements DataWriter {
    @Override
    public boolean writeData(List<String> list, String fileName) {
        try {
            Files.write(Path.of(fileName), list);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("It is not possible to write this file " + fileName, e);
        }
    }
}
