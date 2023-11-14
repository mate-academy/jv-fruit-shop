package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParserService;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseFruitTransactions(List<String> lines) {
        return lines.stream()
                .map(this::getTransactionFromLine)
                .toList();
    }

    public FruitTransaction getTransactionFromLine(String line) {
        String[] parsedTransactionData = line.split(COMMA);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(Operation
                .getOperationByCode(parsedTransactionData[OPERATION_INDEX]));
        fruitTransaction.setFruit(parsedTransactionData[FRUIT_INDEX]);
        fruitTransaction.setAmount(Integer.parseInt(parsedTransactionData[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
