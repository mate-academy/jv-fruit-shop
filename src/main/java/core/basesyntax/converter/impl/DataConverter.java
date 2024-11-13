package core.basesyntax.converter.impl;

import static core.basesyntax.model.FruitTransaction.Operation.convertor;

import core.basesyntax.converter.Convertor;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverter implements Convertor {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int OPERATION_NAME_INDEX = 1;
    private static final int REMOVE_REDUNDANT_FIRST_ROW = 1;
    private static final int START_FROM_INDEX = 1;
    private static final int OPERATION_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> report) {
        List<FruitTransaction> list =
                new ArrayList<>(report.size() - REMOVE_REDUNDANT_FIRST_ROW);

        for (int i = START_FROM_INDEX; i < report.size(); i++) {
            String[] split = String.valueOf(report.get(i))
                    .replace("[", "")
                    .replace("]", "")
                    .split(",");

            String type = split[OPERATION_TYPE_INDEX];
            String fruit = split[OPERATION_NAME_INDEX];
            String quantity = split[OPERATION_QUANTITY_INDEX];

            FruitTransaction.Operation fruitTransaction = convertor(type);
            int quantityOfFruit = Integer.parseInt(quantity);

            if (fruit != null) {
                list.add(new FruitTransaction(fruitTransaction, fruit, quantityOfFruit));
            }
        }
        return list;
    }
}

