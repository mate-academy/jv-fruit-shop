package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String filePath) throws IOException {
        Files.write(Paths.get(filePath), data.getBytes());
    }
}
