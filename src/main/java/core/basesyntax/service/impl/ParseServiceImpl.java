package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.List;

public class ParseServiceImpl implements ParseService {
    private static final int INDEX_OF_QUANTITY = 2;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_OPERATION = 0;
    private static final String LINE_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parse(String data) {
        List<FruitTransaction> fruitTransactionsList = new ArrayList<>();
        List<String> convertedData = new ArrayList<>(List.of(data.split(System.lineSeparator())));
        convertedData.remove(0);
        for (String s : convertedData) {
            String[] splittedString = s.split(LINE_SEPARATOR);
            int quantity = Integer.parseInt(splittedString[INDEX_OF_QUANTITY]);
            String fruit = splittedString[INDEX_OF_FRUIT];
            String operation = splittedString[INDEX_OF_OPERATION];
            fruitTransactionsList.add(new FruitTransaction(quantity,
                    FruitTransaction.Operation.getOperation(operation), fruit));
        }
        return fruitTransactionsList;
    }
}
