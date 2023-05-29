package core.basesyntax.service.impl;

import core.basesyntax.exception.InvalidValueExeption;
import core.basesyntax.service.CsvFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements CsvFileReader {
    private static final int FIRST_LINE = 1;

    private String fileSource;

    public FileReaderImpl(String fileSource) {
        this.fileSource = fileSource;
    }

    public String getFileSource() {
        return fileSource;
    }

    @Override
    public List<String> readFile() {
        Path filePath = Paths.get(fileSource);
        if (!Files.exists(filePath)) {
            throw new RuntimeException("File not found: " + fileSource);
        }
        try {
            return Files.lines(filePath)
                    .skip(FIRST_LINE)
                    .peek(this::checkData)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file: " + getFileSource(), e);
        }
    }

    private void checkData(String line) {
        if (!isValidFormat(line)) {
            throw new InvalidValueExeption("Data from " + getFileSource()
                    + "is in an incorrect format");
        }
    }

    private boolean isValidFormat(String line) {
        String regex = "^[bpsr],\\w+,[0-9]+$";
        return line.matches(regex);
    }
}
