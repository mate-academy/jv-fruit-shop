package core.basesyntax.service;

import core.basesyntax.model.Transaction;

import java.util.List;
import java.util.function.Supplier;

public interface TransactionsSupplier extends Supplier<List<Transaction>> {
}
