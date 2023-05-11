package core.basesyntax.service.impl;

import core.basesyntax.exception.AcceptedDataInvalidExeption;
import core.basesyntax.service.CsvFileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    private static final int INDEX_OF_UNUSED_DATA = 0;
    private List<String> dataFromFile;

    @Override
    public List<String> readDataFromSource(String source) {
        File file = new File(source);
        if (!file.exists()) {
            throw new RuntimeException("File does not exist");
        }
        try {
            dataFromFile = Files.readAllLines(file.toPath());
            isValidData(file.getName());
            dataFromFile.remove(INDEX_OF_UNUSED_DATA);
            return dataFromFile;
        } catch (IOException e) {
            throw new RuntimeException("can`t read data from file: " + file.getName(), e);
        }
    }

    private void isValidData(String fileName) {
        long amountOfInvalidTransaction = dataFromFile.stream()
                .map(s -> s.split(","))
                .filter(s -> s.length % 3 != 0)
                .count();
        if (amountOfInvalidTransaction > 0) {
            throw new AcceptedDataInvalidExeption("The data is not filled in correctly"
                    + "in file with name: "
                    + fileName);
        }
    }
}
