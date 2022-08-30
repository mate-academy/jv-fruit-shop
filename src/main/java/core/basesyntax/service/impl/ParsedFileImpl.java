package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParsedFile;

import java.util.List;
import java.util.stream.Collectors;

public class ParsedFileImpl implements ParsedFile {

    @Override
    public List<Transaction> parsedList(List<String> listFromParsed) {
        listFromParsed.remove(0);
        return listFromParsed.stream()
                .map(l -> l.split(","))
                .map(this::build)
                .collect(Collectors.toList());
    }

    private Transaction build(String[] list) {
        Transaction transaction = new Transaction();
        for (Transaction.Operation operation : Transaction.Operation.values()) {
            if (operation.getOperation()
                    .equals(list[0])) {
                transaction.setOperation(operation);
            }
        }
        Fruit fruit = new Fruit(list[1]);
        return new Transaction(transaction.getOperation(), fruit, Integer.parseInt(list[2]));
    }
}

