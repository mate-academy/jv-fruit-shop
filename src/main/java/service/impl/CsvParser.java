package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.Parser;

public class CsvParser implements Parser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parse(List<String> rowsList) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < rowsList.size(); i++) {
            String[] values = rowsList.get(i).split(SEPARATOR);
            Operation operation = Operation.getByCode(values[OPERATION_INDEX]);
            String fruit = values[FRUIT_INDEX];
            int amount = Integer.parseInt(values[AMOUNT_INDEX]);

            fruitTransactions.add(new FruitTransaction(operation, fruit, amount));
        }

        return fruitTransactions;
    }
}
