package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvFileReaderImpl implements CsvFileReader {
    private static final String CSV_SEPARATOR = ",";
    private String fileName;

    public CsvFileReaderImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String[]> getDataFromFile() {
        Stream<String> streamFromFile;
        try {
            streamFromFile = Files.lines(Path.of("src", "main", "resources", fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file: " + fileName);
        }
        return streamFromFile
                .skip(1)
                .map(String::trim)
                .map(s -> s.split(CSV_SEPARATOR))
                .collect(Collectors.toList());
    }
}
