package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionConvertor;
import java.util.ArrayList;
import java.util.List;

public class TransactionConvertorImpl implements TransactionConvertor {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<Transaction> convert(List<String> lines) {
        List<Transaction> transactions = new ArrayList<>();
        lines.remove(0);
        for (String line : lines) {
            String[] splittedLine = line.split(",");
            Transaction transaction = new Transaction(Transaction.Operation.getOperation(
                                                splittedLine[OPERATION_INDEX]),
                                                new Fruit(splittedLine[FRUIT_INDEX]),
                                                Integer.valueOf(splittedLine[QUANTITY_INDEX]));
            transactions.add(transaction);
        }
        return transactions;
    }
}
