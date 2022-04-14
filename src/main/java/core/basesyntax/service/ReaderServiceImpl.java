package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    private static final Long TOPIC = 1L;

    @Override
    public List<FruitTransaction> read(String fileName) {
        List<String> data;
        try {
            data = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file: " + fileName, e);
        }
        return data.stream()
                .skip(TOPIC)
                .map(this::convertToTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction convertToTransaction(String transaction) {
        String[] splitTransaction = transaction.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getByAbbreviation(splitTransaction[0]));
        fruitTransaction.setFruit(splitTransaction[1]);
        fruitTransaction.setQuantity(Integer.parseInt(splitTransaction[2]));
        return fruitTransaction;
    }
}
