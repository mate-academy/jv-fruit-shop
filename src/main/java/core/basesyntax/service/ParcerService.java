package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParcerService {
    List<FruitTransaction> parseTransactions(List<String> transactions);
}
