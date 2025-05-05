package fruitshop.service.impl;

import fruitshop.model.FruitTransaction;
import fruitshop.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String HEADER = "type,fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransactions(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            if (line.equals(HEADER)) {
                continue;
            }
            String[] parts = line.split(SEPARATOR);
            if (parts.length != 3) {
                throw new RuntimeException("Invalid line: " + line);
            }

            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(FruitTransaction.Operation.fromCode(parts[0]));
            transaction.setFruit(parts[1]);
            transaction.setQuantity(Integer.parseInt(parts[2]));

            transactions.add(transaction);
        }
        return transactions;
    }
}
