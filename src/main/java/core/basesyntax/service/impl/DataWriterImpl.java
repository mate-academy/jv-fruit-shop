package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataWriterImpl implements DataWriter {

    @Override
    public boolean writeDataToFile(List<String> list, String fileName) {
        try {
            Files.write(Path.of(fileName), list);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
