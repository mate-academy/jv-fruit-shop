package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final String NAME_INPUT_FILE = "src/main/resources/inputData.csv";
    private static final int NUMBER_OF_FIRST_LINE = 1;

    @Override
    public List<String> get() {
        List<String> transactions;
        try {
            transactions = Files.readAllLines(Path.of(NAME_INPUT_FILE));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + NAME_INPUT_FILE, e);
        }
        return transactions.stream()
                .skip(NUMBER_OF_FIRST_LINE).collect(Collectors.toList());
    }
}
