package service.impl;

import model.FruitTransaction;
import service.DataConverter;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation.getByCode(parts[0]));
            fruitTransaction.setFruit(parts[1]);
            fruitTransaction.setQuantity((Integer.parseInt(parts[2])));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
