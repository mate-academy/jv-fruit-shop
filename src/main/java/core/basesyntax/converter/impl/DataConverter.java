package core.basesyntax.converter.impl;

import core.basesyntax.converter.Convertor;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverter {
    private final Convertor<FruitTransaction.Operation> typeConverter = new TypeConverter();
    private final Convertor<Integer> quantityConverter = new QuantityConverter();

    public List<FruitTransaction> convertToTransaction(List<List<String>> report) {
        List<FruitTransaction> list = new ArrayList<>();
        for (List<String> s : report) {
            String type = s.get(0);
            String fruit = s.get(1);
            String quantity = s.get(2);

            FruitTransaction.Operation typeOfOperation = typeConverter.parseMethod(type.trim());
            Integer quantityOfFruit = quantityConverter.parseMethod(quantity);

            if (typeOfOperation != null && fruit != null && quantityOfFruit != null) {
                list.add(new FruitTransaction(typeOfOperation, fruit, quantityOfFruit));
            }
        }
        return list;
    }
}
