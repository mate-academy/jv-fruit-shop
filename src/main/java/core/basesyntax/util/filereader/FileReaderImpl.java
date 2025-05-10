package core.basesyntax.util.filereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fromFileName) {
        try (InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream(fromFileName)) {

            if (inputStream == null) {
                throw new RuntimeException("File not found: " + fromFileName);
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                return reader.lines().collect(Collectors.toList());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from a file named: " + fromFileName, e);
        }
    }
}
