package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Product;
import core.basesyntax.model.Transaction;
import java.util.List;
import java.util.stream.Collectors;

public class TransitionServiceImpl implements TransitionService {
    private final static int OPERATION_COLUMN = 0;
    private final static int PRODUCT_COLUMN = 1;
    private final static int QUANTITY_COLUMN = 2;

    @Override
    public List<Transaction> getTransactionsList(List<String> fileLines) {
        return fileLines.stream()
                .filter(line -> Operation.fromLetter(line.split(",")[OPERATION_COLUMN]) != null)
                .map(this::getTransactionFromCsvRow)
                .collect(Collectors.toList());
    }

    private Transaction getTransactionFromCsvRow(String line) {
        String[] fields = line.split(",");
        Transaction transaction = new Transaction();
        transaction.setOperation(Operation.fromLetter(fields[OPERATION_COLUMN]));
        transaction.setProduct(new Product(fields[PRODUCT_COLUMN]));
        transaction.setQuantity(Integer.parseInt(fields[QUANTITY_COLUMN]));
        return transaction;
    }
}
