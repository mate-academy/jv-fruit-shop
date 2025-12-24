package service;

import core.basesyntax.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] split = line.split(",");
            String operationCode = split[0];
            FruitTransaction.Operation op = FruitTransaction.Operation.fromCode(operationCode);
            String fruitName = split[1];
            int amount = Integer.parseInt(split[2]);

            transactions.add(new FruitTransaction(op, fruitName, amount));
        }
        return transactions;
    }
}
