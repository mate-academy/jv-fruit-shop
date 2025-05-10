package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final String SPLIT_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QTY_INDEX = 2;

    @Override
    public List<FruitTransaction> process(List<String> transactions) {
        return transactions.stream().skip(1).map(transaction -> getFruitTransaction(transaction))
                .collect(Collectors.toList());
    }

    private FruitTransaction getFruitTransaction(String transaction) {
        String[] fields = transaction.split(SPLIT_SEPARATOR);
        FruitTransaction fruitTransaction = new FruitTransaction(
                FruitTransaction.Operation.getByCode(fields[OPERATION_INDEX]),
                fields[FRUIT_INDEX],
                Integer.parseInt(fields[QTY_INDEX]));
        return fruitTransaction;
    }
}
