package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionsActivitiesService {
    void activityOfTransaction(List<FruitTransaction> transactions);
}
