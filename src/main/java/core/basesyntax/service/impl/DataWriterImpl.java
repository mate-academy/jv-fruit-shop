package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataWriterImpl implements DataWriter {
    @Override
    public void write(List<String> strings, String filePath) {
        String content = String.join(System.lineSeparator(), strings);
        Path path = Paths.get(filePath);
        try {
            BufferedWriter writer = Files.newBufferedWriter(path);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write " + filePath
                   + " with data : " + strings, e);
        }
    }
}
