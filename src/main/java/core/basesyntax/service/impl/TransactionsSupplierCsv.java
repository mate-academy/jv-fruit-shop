package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.model.TransactionType;
import core.basesyntax.service.TransactionsSupplier;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionsSupplierCsv implements TransactionsSupplier {
    private final String filePath;

    public TransactionsSupplierCsv(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Transaction> getTransactionsList() {
        return FileUtils.readFile(filePath).stream()
                .skip(1)
                .map(this::csvRowToTransaction)
                .collect(Collectors.toList());
    }

    private Transaction csvRowToTransaction(String csvRow) {
        String[] tokens = csvRow.split(FileUtils.COMMA_SEPARATOR);
        TransactionType transactionType = TransactionType.of(tokens[0]);
        String fruitName = tokens[1];
        int amount = Integer.parseInt(tokens[2]);
        return new Transaction(transactionType, fruitName, amount);
    }
}
