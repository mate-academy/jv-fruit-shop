package core.basesyntax.service.impl;

import core.basesyntax.exception.AcceptedDataInvalidExeption;
import core.basesyntax.service.CsvFileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    private static final int VALID_ROWS_COUNT = 3;
    private static final int HEADER_LINES_COUNT = 1;
    private static final String COMA_SEPARATOR = ",";

    @Override
    public List<String> readLines(String source) {
        File file = new File(source);
        if (!file.exists()) {
            throw new RuntimeException("File does not exist");
        }
        try {
            List<String> linesFromFile = Files.readAllLines(file.toPath()).stream()
                    .skip(HEADER_LINES_COUNT)
                    .collect(Collectors.toList());
            validateData(file.getName(), linesFromFile);
            return linesFromFile;
        } catch (IOException e) {
            throw new RuntimeException("can`t read data from file: " + file.getName(), e);
        }
    }

    private void validateData(String fileName, List<String> linesFromFile) {
        long amountOfInvalidTransaction = linesFromFile.stream()
                .map(s -> s.split(COMA_SEPARATOR))
                .filter(s -> s.length % VALID_ROWS_COUNT != 0)
                .count();

        if (amountOfInvalidTransaction > 0) {
            throw new AcceptedDataInvalidExeption("The data is not filled in correctly"
                    + "in file with name: "
                    + fileName);
        }
    }
}
