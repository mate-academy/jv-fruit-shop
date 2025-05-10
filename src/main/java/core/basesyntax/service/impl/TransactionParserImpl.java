package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final String SPLITERATOR = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUITS_QUANTITY_INDEX = 2;
    private static final int OFFSET = 1;

    @Override
    public List<FruitTransaction> parseData(List<String> dataFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = OFFSET; i < dataFromFile.size(); i++) {
            FruitTransaction transaction = new FruitTransaction();
            String[] splitedData = dataFromFile.get(i).split(SPLITERATOR);
            Operation operation = Operation.getOperationFromCode(splitedData[OPERATION_TYPE_INDEX]);
            transaction.setOperation(operation);
            transaction.setFruit(splitedData[FRUIT_TYPE_INDEX]);
            fruitTransactions.add(transaction);
        }
        return fruitTransactions;
    }
}
