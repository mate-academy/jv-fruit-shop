package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProcessService {
    List<FruitTransaction> getTransactions(List<String> list);
}
