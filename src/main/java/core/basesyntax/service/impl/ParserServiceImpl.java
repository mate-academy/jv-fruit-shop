package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int INDEX_OF_OPERATION_CODE = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY_VALUE = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        if (dataFromFile.isEmpty()) {
            throw new IllegalArgumentException("The start data file is empty.");
        }
        List<FruitTransaction> listOfTransactions = new ArrayList<>();
        for (String transactions : dataFromFile) {
            String[] transactionArray = transactions
                    .split(SEPARATOR);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction
                    .getOperationByCode(transactionArray[INDEX_OF_OPERATION_CODE]));
            fruitTransaction
                    .setFruit(transactionArray[INDEX_OF_FRUIT_NAME]);
            try {
                fruitTransaction.setQuantity(Integer
                        .parseInt(transactionArray[INDEX_OF_QUANTITY_VALUE]));
            } catch (NumberFormatException e) {
                System.err.println("The quantity value is not a number.");
            }
            listOfTransactions
                    .add(fruitTransaction);
        }
        return listOfTransactions;
    }
}
