package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements FileReader {

    @Override
    public List<Transaction> read(String file) {
        List<String> input;
        try {
            input = Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            throw new RuntimeException("No such filePath " + file, e);
        }
        return input.stream()
                .skip(1)
                .map(this::getData)
                .collect(Collectors.toList());
    }

    private Transaction getData(String data) {
        String[] strings = data.split(",");
        Transaction transaction = new Transaction();
        transaction.setOperationType(Transaction.Operation.fromOperation(strings[0]));
        transaction.setFruit(new Fruit(strings[1]));
        transaction.setAmount(Integer.parseInt(strings[2]));
        return transaction;
    }
}
