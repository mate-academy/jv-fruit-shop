package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileParse;
import java.util.List;
import java.util.stream.Collectors;

public class FileParsedImpl implements FileParse {
    private static final String REGEX = ",";
    private static final int SIZE = 3;

    @Override
    public List<Transaction> parse(List<String> lines) {
        lines.remove(0);
        return lines.stream()
                .map(line -> line.split(REGEX))
                .filter(lineArray -> lineArray.length == SIZE)
                .map(this::buildTransaction)
                .collect(Collectors.toList());
    }

    private Transaction buildTransaction(String[] lineArray) {
        Transaction transaction = new Transaction();
        for (Transaction.Operation operation : Transaction.Operation.values()) {
            if (operation.getOperation()
                    .equals(lineArray[0])) {
                transaction.setOperation(operation);
            }
        }
        Fruit fruit = new Fruit(lineArray[1]);
        return new Transaction(transaction.getOperation(),
                fruit, Integer.parseInt(lineArray[2]));
    }
}
