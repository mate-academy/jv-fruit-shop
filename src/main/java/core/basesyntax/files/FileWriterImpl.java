package core.basesyntax.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String toFileName, List<String> lines) {
        try {
            Path path = Paths.get(toFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            for (String line : lines) {
                Files.writeString(path, line + "\n", StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file " + toFileName, e);
        }
    }
}
