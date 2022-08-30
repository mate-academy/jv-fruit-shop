package core.basesyntax.service.implementation;

import core.basesyntax.service.FileDataWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

public class FileDataWriterImpl implements FileDataWriter {
    @Override
    public void writeData(String path, String data) {
        try {
            Files.write(Path.of(path), Collections.singleton(data));
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + path,e);
        }
    }
}
