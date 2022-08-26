package services.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import services.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final String SPLIT_SEPARATOR = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String> transactions) {
        return transactions.stream()
                .skip(1)
                .map(this::getFruitTransaction)
                .collect(Collectors.toList());
    }

    public FruitTransaction getFruitTransaction(String line) {
        String[] transactions = line.split(SPLIT_SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(
                FruitTransaction.Operation.getTypeOperation(transactions[INDEX_OPERATION]));
        fruitTransaction.setFruit(transactions[INDEX_FRUIT]);
        fruitTransaction.setQuantity(Integer.parseInt(transactions[INDEX_QUANTITY]));
        return fruitTransaction;
    }
}
