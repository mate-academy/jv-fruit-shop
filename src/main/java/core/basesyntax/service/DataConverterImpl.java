package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] split = line.split(",");

            String operationValue = split[0].trim();
            String fruit = split[1].trim();
            int amount = Integer.parseInt(split[2].trim());

            FruitTransaction.Operation operation =  MapToOperation(operationValue);
            FruitTransaction transaction = new FruitTransaction(operation, fruit, amount);

            transactions.add(transaction);
        }
        return transactions;
    }
    private FruitTransaction.Operation MapToOperation(String operationToCheck) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(operationToCheck)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Unknown type of operation incoming : " + operationToCheck);
    }
}
