package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convert(List<String> transactions) {
        List<FruitTransaction> transactionList = new ArrayList<>();
        for (String transaction : transactions) {
            String[] parts = transaction.split(",");
            if (parts.length > 0 && parts.length < 3) {
                throw new ArrayIndexOutOfBoundsException("Invalid data entered");
            }
            Operation operation = new OperationStrategyImpl().getOperationFromCode(parts[0]);
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            transactionList.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactionList;
    }
}
