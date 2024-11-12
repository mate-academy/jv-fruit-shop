package core.basesyntax.utils.fileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader implements IFileReader {
    @Override
    public List<String> readCSVFile(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.skip(1).collect(Collectors.toList());
        } catch (IOException exception) {
            throw new RuntimeException("Error while reading file: ", exception);
        }
    }
}
