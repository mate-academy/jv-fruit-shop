package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileParser;
import java.util.List;
import java.util.stream.Collectors;

public class FileParserImpl implements FileParser {
    private static final int HEADER_COLUMN_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<Transaction> parseTransactionList(List<String> transactionList) {
        transactionList.remove(HEADER_COLUMN_INDEX);
        return transactionList.stream()
                .map(this::getTransaction)
                .collect(Collectors.toList());
    }

    private Transaction getTransaction(String line) {
        String[] splitArray = line.trim().split(",");
        return new Transaction(detectOperation(splitArray[OPERATION_INDEX]),
                new Fruit(splitArray[FRUIT_INDEX]),
                Integer.parseInt(splitArray[QUANTITY_INDEX]));
    }
    private Transaction.Operation detectOperation(String name) {
        for (Transaction.Operation operation : Transaction.Operation.values()){
            if (operation.getFirstLetter().equals(name)) {
                return operation;
            }
        }
        throw new RuntimeException("No such element found");
    }
}
