package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderServiceCsvImpl implements FileReaderService {
    private static final String FILE_FORMAT = ".csv";
    private final String pathFile;

    public FileReaderServiceCsvImpl(String filePath) {
        this.pathFile = filePath;
    }

    @Override
    public List<String> readFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile))) {
            if (pathFile.endsWith(FILE_FORMAT)) {
                return bufferedReader.lines().collect(Collectors.toList());
            }
            throw new RuntimeException("Wrong extension of file: "
                    + pathFile + ", must be '" + FILE_FORMAT + "' file");
        } catch (IOException e) {
            throw new RuntimeException("Can't read file by path: " + pathFile, e);
        }
    }
}
