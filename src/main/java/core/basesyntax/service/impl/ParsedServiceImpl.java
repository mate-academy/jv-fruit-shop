package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParsedService;
import java.util.List;
import java.util.stream.Collectors;

public class ParsedServiceImpl implements ParsedService {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<Transaction> parse(List<String> data) {
        data.remove(OPERATION_INDEX);
        return data.stream()
                .map(this::parseTransactionFromLine)
                .collect(Collectors.toList());
    }

    private Transaction parseTransactionFromLine(String line) {
        String [] array = line.split(COMMA);
        Transaction transaction = new Transaction();
        for (Transaction.Operation operation : Transaction.Operation.values()) {
            if (operation.getOperation()
                    .equals(array[OPERATION_INDEX])) {
                transaction.setOperation(operation);
            }
        }
        Fruit fruit = new Fruit(array[FRUIT_INDEX]);
        return new Transaction(transaction.getOperation(),
                fruit, Integer.parseInt(array[AMOUNT_INDEX]));
    }
}
