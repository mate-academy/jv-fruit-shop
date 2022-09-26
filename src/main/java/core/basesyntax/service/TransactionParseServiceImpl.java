package core.basesyntax.service;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionParseServiceImpl implements TransactionParseService {
    private static final int OPERATOR_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int COUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> dailyTransactionList) {
        return dailyTransactionList.stream()
                .skip(1)
                .map(this::parsingLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction parsingLine(String line) {
        String[] splitLines = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(fruitTransaction
                .convertOperation(splitLines[OPERATOR_INDEX]));
        fruitTransaction.setFruit(splitLines[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(splitLines[COUNT_INDEX]));
        return fruitTransaction;
    }
}
