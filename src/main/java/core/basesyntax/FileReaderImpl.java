package core.basesyntax;

import core.basesyntax.dao.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }
}

