package core.basesyntax.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriterFileImpl implements FileWriter {

    @Override
    public void write(List<String> resultList, String filePath) {
        try {
            Files.write(Path.of(filePath), resultList, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to " + filePath);
        }
    }
}
