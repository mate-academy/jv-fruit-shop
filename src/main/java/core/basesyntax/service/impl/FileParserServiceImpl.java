package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileParserService;

import java.util.ArrayList;
import java.util.List;

public class FileParserServiceImpl implements FileParserService {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int AMOUNT_INDEX = 2;
    public static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String string : data) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] splitted = string.split(SEPARATOR);
            String operationCode = splitted[OPERATION_INDEX];
            FruitTransaction.Operation operation = FruitTransaction
                    .Operation.getCode(operationCode);
            fruitTransaction.setOperation(operation);
            fruitTransaction.setFruit(splitted[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(splitted[AMOUNT_INDEX]));
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
