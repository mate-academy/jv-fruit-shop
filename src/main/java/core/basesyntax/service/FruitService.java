package core.basesyntax.service;

import core.basesyntax.dto.Transaction;
import java.util.List;

public interface FruitService {
    void applyOperations(List<Transaction> transactionList);
}
