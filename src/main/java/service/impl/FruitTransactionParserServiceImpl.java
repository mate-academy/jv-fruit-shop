package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FruitTransactionParserService;

public class FruitTransactionParserServiceImpl implements FruitTransactionParserService {
    private static final String SEPARATOR = ",";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int SKIP_TITLE_INDEX = 1;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        lines.stream()
                .skip(SKIP_TITLE_INDEX)
                .map(this::getDateFromFile)
                .collect(Collectors.toList());
        return fruitTransactions;
    }

    public FruitTransaction getDateFromFile(String date) {
        String[] fruitInfo = date.split(SEPARATOR);
        String operation = fruitInfo[TYPE_INDEX];
        String fruitName = fruitInfo[FRUIT_INDEX];
        int amount = Integer.parseInt(fruitInfo[QUANTITY_INDEX]);
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(FruitTransaction
                .Operation.getOperationType(operation));
        transaction.setFruit(fruitName);
        transaction.setQuantity(amount);
        return transaction;
    }
}
