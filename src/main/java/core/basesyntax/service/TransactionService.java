package core.basesyntax.service;

import core.basesyntax.models.FruitTransaction;
import java.util.List;

public interface TransactionService {
    List<FruitTransaction> createTransactionsList(List<String> inputData);
}
