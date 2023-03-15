package core.basesyntax.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {

    public void writeToFile(String pathToFile, String data) {
        byte[] bs = data.getBytes();
        {
            try {
                Files.write(Path.of(pathToFile), bs);
            } catch (IOException e) {
                throw new RuntimeException("Can't write to file " + pathToFile, e);
            }
        }
    }
}
