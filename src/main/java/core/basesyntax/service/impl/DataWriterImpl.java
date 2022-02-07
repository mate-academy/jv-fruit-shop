package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataWriterImpl implements DataWriter {

    @Override
    public boolean writeDataToFile(List<String> list, String filename) {
        try {
            Files.write(Path.of(filename), list);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file");
        }
    }
}
