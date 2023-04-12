package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private static final String DATE_SEPARATOR = ",";
    private static final int TITLE_LINE = 1;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int OPERATION_INDEX = 0;

    @Override
    public List<FruitTransaction> toTransaction(List<String> input) {
        List<FruitTransaction> transactionList = new ArrayList<>();
        for (int i = TITLE_LINE; i < input.size(); i++) {
            transactionList.add(parseLine(input.get(i)));
        }
        return transactionList;
    }

    private FruitTransaction parseLine(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] strings = line.split(DATE_SEPARATOR);
        fruitTransaction.setFruit(new Fruit(strings[FRUIT_INDEX],
                Integer.parseInt(strings[QUANTITY_INDEX])));
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getByCode(strings[OPERATION_INDEX]));
        return fruitTransaction;
    }
}
