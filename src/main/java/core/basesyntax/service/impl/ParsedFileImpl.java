package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParsedFile;
import java.util.List;
import java.util.stream.Collectors;

public class ParsedFileImpl implements ParsedFile {
    private static final String SEPARATOR = ",";
    private static final int INDEX_FIRST = 0;
    private static final int INDEX_SECOND = 1;

    @Override
    public List<Transaction> parsedList(List<String> listFromParsed) {
        listFromParsed.remove(INDEX_FIRST);
        return listFromParsed.stream()
                .map(l -> l.split(SEPARATOR))
                .map(this::build)
                .collect(Collectors.toList());
    }

    private Transaction build(String[] list) {
        Transaction transaction = new Transaction();
        for (Transaction.Operation operation : Transaction.Operation.values()) {
            if (operation.getOperation()
                    .equals(list[INDEX_FIRST])) {
                transaction.setOperation(operation);
            }
        }
        Fruit fruit = new Fruit(list[INDEX_SECOND]);
        return new Transaction(transaction.getOperation(), fruit, Integer.parseInt(list[2]));
    }
}

