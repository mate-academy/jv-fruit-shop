package core.basesyntax.service;

import java.util.List;

public interface TransactionService {
    List<FruitTransaction> creatListTransaction(List<String> dataFromFile);
}
