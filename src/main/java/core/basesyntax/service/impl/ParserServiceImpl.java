package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String REGEX = ",";
    private static final int SIZE = 3;
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final int THIRD_INDEX = 2;

    @Override
    public List<Transaction> parse(List<String> lines) {
        lines.remove(FIRST_INDEX);
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
                    .equals(lineArray[FIRST_INDEX])) {
                transaction.setOperation(operation);
            }
        }
        Fruit fruit = new Fruit(lineArray[SECOND_INDEX]);
        return new Transaction(transaction.getOperation(),
                fruit, Integer.parseInt(lineArray[THIRD_INDEX]));
    }
}
