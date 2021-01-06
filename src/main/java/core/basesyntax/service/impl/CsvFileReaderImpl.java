package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderImpl implements CsvFileReader {
    private static final String COMMA = ",";

    @Override
    public List<TransactionDto> readFromFile(String filePath) {
        List<String> readFromFile = new ArrayList<>();
        String value;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((value = reader.readLine()) != null) {
                readFromFile.add(value);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file by path: " + filePath, e);
        }

        List<String[]> type = readFromFile.stream()
                .filter(s -> !s.startsWith("type"))
                .map(s -> s.split(COMMA))
                .collect(Collectors.toList());

        List<TransactionDto> transactionDtos = new ArrayList<>();

        for (String[] strings : type) {
            Operation operation = Operation.fromString(strings[0]);
            Fruit fruit = new Fruit(strings[1]);
            int quantity = Integer.parseInt(strings[2]);
            if (quantity < 0) {
                throw new RuntimeException("File is wrong");
            }
            transactionDtos.add(new TransactionDto(operation, fruit, quantity));
        }
        return transactionDtos;
    }
}

