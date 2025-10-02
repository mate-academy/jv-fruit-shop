package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransactions(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) { // пропускаем header
            String[] parts = lines.get(i).split(",");
            FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(parts[0]);
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
