package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new RuntimeException("Input report can't be null or empty");
        }
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new RuntimeException("Invalid report line: " + line);
            }
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation.getByCode(parts[0].trim()));
            fruitTransaction.setFruit(parts[1].trim());
            fruitTransaction.setQuantity(Integer.parseInt(parts[2].trim()));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
