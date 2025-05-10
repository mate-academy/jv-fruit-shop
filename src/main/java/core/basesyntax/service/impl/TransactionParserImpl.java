package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final String SEPARATOR = ",";
    private static final int HEADER_INDEX = 0;
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUITS_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> dataFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        dataFromFile.remove(HEADER_INDEX);
        for (String data : dataFromFile) {
            FruitTransaction transaction = new FruitTransaction();
            String[] splitData = data.split(SEPARATOR);
            Operation operation = Operation
                    .getOperationFromCode(splitData[OPERATION_TYPE_INDEX].trim());
            transaction.setOperation(operation);
            transaction.setFruit(splitData[FRUIT_TYPE_INDEX]);
            transaction.setQuantity(Integer.parseInt(splitData[FRUITS_QUANTITY_INDEX]));
            fruitTransactions.add(transaction);
        }

        return fruitTransactions;
    }
}
