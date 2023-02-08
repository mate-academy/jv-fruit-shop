package core.basesyntax.service.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class InputParsingFormatterCsvImpl implements InputParsingFormatterCsv {
    @Override
    public List<String> parsingFilesCsv(String pathFromRepository) {
        try {
            return Files.readAllLines(Path.of(pathFromRepository)).stream()
                    .filter(t -> t.trim().matches("\\w{1},[a-z]*,\\d*"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("is not correct file " + e);
        }
    }
}
