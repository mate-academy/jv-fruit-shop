package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convert(List<String> converted) {
        if (converted == null || converted.isEmpty()) {
            throw new IllegalArgumentException("File name can not be null or empty");
        }
        try {
            List<String> firstLineOff = converted.subList(1, converted.size());
            return firstLineOff.stream()
                    .map(line -> line.split(","))
                    .map(parts -> {
                        String code = parts[0];
                        String fruit = parts[1];
                        int quantity = Integer.parseInt(parts[2]);
                        FruitTransaction transaction = new FruitTransaction();
                        transaction.setOperation(Operation.fromCode(code));
                        transaction.setFruit(fruit);
                        transaction.setQuantity(quantity);
                        return transaction;
                    })
                    .toList();

        } catch (Exception e) {
            throw new RuntimeException("Can not convert the file: " + converted, e);
        }
    }
}
