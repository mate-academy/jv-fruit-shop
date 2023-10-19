package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class ParseServiceImpl implements ParseService {
    private static final String SEPARATOR = ",";
    private static final int HEADER_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> fruits) {
        ArrayList<FruitTransaction> fruitTransactions = new ArrayList<>();
        fruits.remove(HEADER_INDEX);
        for (String fruit : fruits) {
            String[] parsedFruit = fruit.split(SEPARATOR);
            fruitTransactions.add(new FruitTransaction(parsedFruit[FRUIT_INDEX],
                    Integer.parseInt(parsedFruit[AMOUNT_INDEX]),
                    FruitTransaction.Operation.getByCode(parsedFruit[OPERATION_INDEX])));
        }
        return fruitTransactions;
    }
}
