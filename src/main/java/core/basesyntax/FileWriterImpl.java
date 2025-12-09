package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {

    @Override
    public void output(String content, String path) {
        try {
            Files.writeString(Paths.get(path), content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file:" + path + e);
        }
    }
}
