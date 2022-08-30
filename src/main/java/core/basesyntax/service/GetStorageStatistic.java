package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;
import java.util.Map;

public interface GetStorageStatistic {
    Map<String,Integer> getStorageStatistic(List<Transaction> list);
}
