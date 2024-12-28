package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final String csvSeparator = ",";
    private SkipHeader skipHeader = new SkipHeaderImpl();

    @Override
    public List<String> read(String fileName) {
        List<String> file;
        try {
            file = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName);
        }
        skipHeader.skip(file);
        return file;
    }
}
