package service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class DataConverterImpl implements service.DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> csv) {
        return csv.stream().map(line -> {
            String[] parts = line.split(",");
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(Arrays.stream(FruitTransaction.Operation.values())
                    .filter(op -> op.getCode().equals(parts[0]))
                    .findFirst()
                    .orElseThrow());
            transaction.setFruit(parts[1]);
            transaction.setQuantity(Integer.parseInt(parts[2]));
            return transaction;
        }).collect(Collectors.toList());
    }
}
