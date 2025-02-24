package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class FileWriterImpl implements FileWriter {
    public void write(String content, String filePath) throws IOException {
        Files.write(Paths.get(filePath), content.getBytes());
    }
}

