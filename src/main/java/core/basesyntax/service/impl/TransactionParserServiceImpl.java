package core.basesyntax.service.impl;

import core.basesyntax.service.TransactionParserService;
import core.basesyntax.transaction.FruitTransaction;
import core.basesyntax.transaction.Operation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final String COMA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> getTransactions(List<String> linesFormFile) {
        linesFormFile = skipFirstLine(linesFormFile);
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String line : linesFormFile) {
            FruitTransaction fruitTransaction = parseTransaction(line);
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }

    private FruitTransaction parseTransaction(String line) {
        String[] splitedLine = line.split(COMA_SEPARATOR);
        Operation operation = Operation.getOperation(splitedLine[OPERATION_INDEX]);
        String fruit = splitedLine[FRUIT_INDEX];
        int quantity = Integer.parseInt(splitedLine[QUANTITY_INDEX]);
        return new FruitTransaction(operation, fruit, quantity);
    }

    private List<String> skipFirstLine(List<String> linesFromFile) {
        return linesFromFile.stream()
                .skip(FRUIT_INDEX)
                .collect(Collectors.toList());
    }
}
