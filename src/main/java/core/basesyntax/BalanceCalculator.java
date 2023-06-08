package core.basesyntax;

import java.util.List;
import java.util.Map;

public interface BalanceCalculator {
    Map<String, Integer> calculateFruitBalance(List<FruitTransaction> transactions);
}
