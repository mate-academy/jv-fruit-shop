package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int OPERATION_KEY_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> toTransactions(String dataFromFile) {
        List<FruitTransaction> transactions = new ArrayList<>();
        String[] dataFromLines = dataFromFile.split(System.lineSeparator());
        for (int i = 1; i < dataFromLines.length; i++) {
            transactions.add(parseTransaction(dataFromLines[i]));
        }
        return transactions;
    }

    public FruitTransaction parseTransaction(String line) {
        String[] splitLine = line.split(",");
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(FruitTransaction.Operation
                .getOperationFromKey(splitLine[OPERATION_KEY_INDEX]));
        transaction.setFruit(splitLine[FRUIT_INDEX]);
        transaction.setQuantity(Integer.parseInt(splitLine[FRUIT_QUANTITY_INDEX]));
        return transaction;
    }
}
