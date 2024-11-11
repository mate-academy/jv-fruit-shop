package core.basesyntax.converter.impl;

import core.basesyntax.converter.Convertor;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverter {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private final Convertor<FruitTransaction.Operation> typeConverter = new TypeConverter();
    private final Convertor<Integer> quantityConverter = new QuantityConverter();

    public List<FruitTransaction> convertToTransaction(List<List<String>> report) {
        List<FruitTransaction> list = new ArrayList<>();
        for (List<String> data : report) {
            String type = data.get(ZERO);
            String fruit = data.get(ONE);
            String quantity = data.get(TWO);

            FruitTransaction.Operation typeOfOperation = typeConverter.convertor(type.trim());
            Integer quantityOfFruit = quantityConverter.convertor(quantity);
            if (typeOfOperation != null && fruit != null && quantityOfFruit != null) {
                list.add(new FruitTransaction(typeOfOperation, fruit, quantityOfFruit));
            }
        }
        return list;
    }
}
