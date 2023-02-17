package service;

import model.FruitTransaction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderService implements FileReaderService {
    private static final String REGEX_TO_SPLIT_STRING = ",";
    private static final int OPERATION_SIGN_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> getTransactionsFromFile(File inputFile) {
        return convertToFruitTransaction(read(inputFile));
    }

    @Override
    public void readFile(File inputFile) {
        List<String> data = read(inputFile);
        data.stream()
            .forEach(System.out::println);
    }

    private List<FruitTransaction> convertToFruitTransaction(List<String> inputData) {
        return inputData.stream()
                .map(s -> s.split(REGEX_TO_SPLIT_STRING))
                .map(a -> new FruitTransaction(a[OPERATION_SIGN_INDEX],
                                                a[FRUIT_NAME_INDEX],
                                                Integer.parseInt(a[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }

    private List<String> read(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can’t read file", e);
        }
    }
}
