package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import java.util.List;
import java.util.stream.Collectors;

public class TransitionConvertorImpl implements TransitionConvertor {
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<Transaction> convert(List<String> lines) {
        lines.remove(0);
        return lines.stream()
                .map(this::getTransactionFromCsvRow)
                .collect(Collectors.toList());
    }

    private Transaction getTransactionFromCsvRow(String line) {
        String[] splittedLine = line.split(",");
        Transaction transaction = new Transaction();
        transaction.setOperation(Operation.fromLetter(splittedLine[OPERATION_INDEX]));
        transaction.setProduct(new Fruit(splittedLine[PRODUCT_INDEX]));
        transaction.setQuantity(Integer.parseInt(splittedLine[QUANTITY_INDEX]));
        return transaction;
    }
}
