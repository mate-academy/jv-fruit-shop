package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.StringListProcessor;
import java.util.ArrayList;
import java.util.List;

public class StringListProcessorImpl implements StringListProcessor {
    @Override
    public List<Transaction> stringListToFruitIntegerMap(List<String> fileContent) {
        List<Transaction> transactionList = new ArrayList<>();
        for (String line : fileContent) {
            String[] values = line.split(",");
            Transaction transaction = new Transaction(Transaction.Operation.getOperation(values[0]),
                                                        new Fruit(values[1]),
                                                        Integer.valueOf(values[2]));
            transactionList.add(transaction);
        }
        return transactionList;
    }
}
