package core.basesyntax.service.impl;

import static core.basesyntax.enums.TurnoverType.ADD;
import static core.basesyntax.enums.TurnoverType.SUBTRACT;

import core.basesyntax.enums.TurnoverType;
import core.basesyntax.hadler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitShopService implements ShopService {
    private OperationStrategy operationStrategy = new OperationStrategyImpl();

    @Override
    public Map<String, Integer> getEndBalance(List<FruitTransaction> transactions) {
        List<String> fruits = transactions.stream()
                .map(FruitTransaction::getFruit)
                .distinct()
                .collect(Collectors.toList());
        Map<String, Integer> balances = new HashMap<>();
        for (String fruit : fruits) {
            int balance = getTurnover(ADD, fruit, transactions)
                    - getTurnover(SUBTRACT, fruit, transactions);
            balances.put(fruit, balance);
        }
        return balances;
    }

    private int getTurnover(TurnoverType type, String fruit, List<FruitTransaction> transactions) {
        OperationHandler operationHandler = operationStrategy.getOperationHandler(type);
        return operationHandler.getAmount(fruit, transactions);
    }
}
