package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import model.Operation;
import service.TransactionParser;

public class TransactionParseImpl implements TransactionParser {
    public static final int INDEX_OF_OPERATION = 0;
    public static final int INDEX_OF_NAME = 1;
    public static final int INDEX_OF_AMONG = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(this::getFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFruitTransaction(String line) {
        String[] string = line.split(",");
        return new FruitTransaction(Operation.getByCode((string[INDEX_OF_OPERATION])),
                string[INDEX_OF_NAME],
                Integer.parseInt(string[INDEX_OF_AMONG]));
    }
}
