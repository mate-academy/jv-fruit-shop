package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;

public interface TransactionParser {
    Transaction.Operation getOperation(String line);

    Fruit getFruit(String line);

    Integer getQuantity(String line);
}
