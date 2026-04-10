package core.basesyntax.service;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> input) {
        List<FruitTransaction> result = new ArrayList<>();

        for (String line : input) {
            String[] p = line.split(",");

            FruitTransaction tx = new FruitTransaction();
            tx.setOperation(FruitTransaction.Operation.fromCode(p[0].trim()));
            tx.setFruit(p[1].trim());
            tx.setQuantity(Integer.parseInt(p[2].trim()));

            result.add(tx);
        }

        return result;
    }
}
