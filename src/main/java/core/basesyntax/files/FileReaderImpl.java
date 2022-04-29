package core.basesyntax.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String fromFileName) {
        try {
            File file = new File(fromFileName);
            return new ArrayList<>(Files.readAllLines(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file " + fromFileName, e);
        }
    }
}
