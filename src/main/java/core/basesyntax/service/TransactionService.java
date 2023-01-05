package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionService {
    public List<FruitTransaction> getlistOfFruitTransaction(List<String> dataFromFile);
}
