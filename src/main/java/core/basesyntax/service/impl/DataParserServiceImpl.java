package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import core.basesyntax.utility.Operation;
import java.util.ArrayList;
import java.util.List;

public class DataParserServiceImpl implements DataParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseData(List<String> retrievedLines) {
        List<FruitTransaction> transactionList = new ArrayList<>();
        for (String line : retrievedLines) {
            String[] split = line.split(SEPARATOR);

            FruitTransaction fruitTransaction = new FruitTransaction();
            Operation currentOperation = Operation.getByValue(split[OPERATION_INDEX]);
            fruitTransaction.setOperation(currentOperation);
            fruitTransaction.setFruit(split[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(split[QUANTITY_INDEX]));

            transactionList.add(fruitTransaction);
        }
        return transactionList;
    }
}
