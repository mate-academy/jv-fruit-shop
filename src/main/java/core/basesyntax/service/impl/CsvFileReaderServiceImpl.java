package core.basesyntax.service.impl;

import core.basesyntax.exception.AcceptedDataInvalidExeption;
import core.basesyntax.service.CsvFileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    private static final int VALID_NUMBERS_OF_INFORMATION = 3;
    private static final int HEADER_LINES_COUNT = 0;
    private static final String COMA_SEPARATOR = ",";
    private List<String> dataFromFile;

    @Override
    public List<String> readLines(String source) {
        File file = new File(source);
        if (!file.exists()) {
            throw new RuntimeException("File does not exist");
        }
        try {
            dataFromFile = Files.readAllLines(file.toPath());
            validateData(file.getName());
            dataFromFile.remove(HEADER_LINES_COUNT);
            return dataFromFile;
        } catch (IOException e) {
            throw new RuntimeException("can`t read data from file: " + file.getName(), e);
        }
    }

    private void validateData(String fileName) {
        long amountOfInvalidTransaction = dataFromFile.stream()
                .skip(1)
                .map(s -> s.split(COMA_SEPARATOR))
                .filter(s -> s.length % VALID_NUMBERS_OF_INFORMATION != 0)
                .count();

        if (amountOfInvalidTransaction > 0) {
            throw new AcceptedDataInvalidExeption("The data is not filled in correctly"
                    + "in file with name: "
                    + fileName);
        }
    }
}
