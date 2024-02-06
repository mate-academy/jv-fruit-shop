package core.basesyntax.converter;

import core.basesyntax.model.Transaction;

import java.util.List;

public interface StringTransactionConverter {
    List<Transaction> convert(List<String> StringTransactions);
}
