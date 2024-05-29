package core.basesyntax;

import core.basesyntax.dao.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String fileName) throws IOException {
        Files.write(Paths.get(fileName), data.getBytes());
    }
}
