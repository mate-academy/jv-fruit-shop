package core.basesyntax.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(List<String> content, String filePath) {
        try {
            Files.write(Path.of(filePath), content);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write file by path " + filePath);
        }
    }
}
