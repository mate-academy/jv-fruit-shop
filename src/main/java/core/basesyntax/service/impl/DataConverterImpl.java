package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> result = new ArrayList<>();

        for (String line : data) {
            String[] parts = line.split(",");

            FruitTransaction tx = new FruitTransaction();
            tx.setOperation(FruitTransaction.Operation.fromCode(parts[0]));
            tx.setFruit(parts[1]);
            tx.setQuantity(Integer.parseInt(parts[2]));

            result.add(tx);
        }

        return result;
    }
}
