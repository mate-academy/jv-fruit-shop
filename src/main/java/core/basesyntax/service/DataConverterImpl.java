package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line: data) {
            String[] elements = line.split(",");
            FruitTransaction fruitTransaction =
                    new FruitTransaction(FruitTransaction.Operation.fromCode(elements[0]),
                            elements[1], Integer.parseInt(elements[2]));
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
