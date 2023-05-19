package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ListToTransactionConverter {
    List<FruitTransaction> getTransactions(List<String> linesFormFile);
}
