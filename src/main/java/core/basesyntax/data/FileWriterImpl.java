package core.basesyntax.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String resultingReport, String path) {
        try {
            Files.writeString(Paths.get(path), resultingReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file " + path, e);
        }
    }
}
