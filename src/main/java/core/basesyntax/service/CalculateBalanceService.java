package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface CalculateBalanceService {
    Map<String,Integer> calculate(List<FruitTransaction> transactionList);
}
