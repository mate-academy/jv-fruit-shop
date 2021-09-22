package core.basesyntax.dataservices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String fromFileName) {
        try {
            return Files.lines(Path.of(fromFileName))
                        .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fromFileName, e);
        }
    }
}
