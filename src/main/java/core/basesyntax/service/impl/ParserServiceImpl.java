package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int INDEX_OF_FIRST_LINE = 0;
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String[]> dataFromFile) {
        dataFromFile.remove(INDEX_OF_FIRST_LINE);
        List<FruitTransaction> listOfTransactions = new ArrayList<>();
        for (String[] transaction : dataFromFile) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
                if (operation.getCode().equals(transaction[INDEX_OF_OPERATION])) {
                    fruitTransaction.setOperation(operation);
                }
            }
            fruitTransaction.setFruit(transaction[INDEX_OF_FRUIT]);
            fruitTransaction.setQuantity(Integer.parseInt(transaction[INDEX_OF_QUANTITY]));
            listOfTransactions.add(fruitTransaction);
        }
        return listOfTransactions;
    }
}
