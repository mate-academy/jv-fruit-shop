package core.basesyntax.service.impl;

import core.basesyntax.function.impl.CalculateTransaction;
import core.basesyntax.model.FruitQuantity;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculateBalanceService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateBalanceServiceImpl implements CalculateBalanceService {
    @Override
    public Map<String,Integer> calculate(List<FruitTransaction> transactionList) {
        CalculateTransaction calculateTransaction = new CalculateTransaction();
        return transactionList
                .stream()
                .map(calculateTransaction)
                .collect(Collectors.toMap(
                        FruitQuantity::getFruit,
                        FruitQuantity::getQuantity,
                        Integer::sum
                ));
    }
}
