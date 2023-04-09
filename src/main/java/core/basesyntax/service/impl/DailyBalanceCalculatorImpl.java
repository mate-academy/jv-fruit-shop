package core.basesyntax.service.impl;

import core.basesyntax.function.impl.CompleteTransaction;
import core.basesyntax.model.FruitQuantity;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DailyBalanceCalculator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DailyBalanceCalculatorImpl implements DailyBalanceCalculator {
    @Override
    public Map<String, Integer> calculateBalance(List<FruitTransaction> fruitTransactionFromDb) {
        CompleteTransaction completeTransaction = new CompleteTransaction();
        return fruitTransactionFromDb
                .stream()
                .map(completeTransaction)
                .collect(Collectors.toMap(
                        FruitQuantity::getFruit,
                        FruitQuantity::getQuantity,
                        Integer::sum
                ));
    }
}
