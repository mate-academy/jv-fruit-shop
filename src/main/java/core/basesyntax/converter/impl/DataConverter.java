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
        List<FruitTransaction> list = new ArrayList<>(report.size());
        var counter = 0;
        for (List<String> data : report) {
            String[] split = String.valueOf(data).replace("[", "")
                    .replace("]", "")
                    .split(",");
            if (counter >= 1) {
                String type = split[ZERO];
                String fruit = split[ONE];
                String quantity = split[TWO];

                FruitTransaction.Operation typeOfOperation = typeConverter.convertor(type.trim());
                Integer quantityOfFruit = quantityConverter.convertor(quantity);

                if (typeOfOperation != null && fruit != null && quantityOfFruit != null) {
                    list.add(new FruitTransaction(typeOfOperation, fruit, quantityOfFruit));
                }
            }
            counter++;
        }
        return list;
    }

}
