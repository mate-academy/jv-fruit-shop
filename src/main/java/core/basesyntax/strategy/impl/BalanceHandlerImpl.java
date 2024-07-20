package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.utility.ListService;
import core.basesyntax.utility.impl.ListServiceImpl;
import java.util.List;
import java.util.Map;

public class BalanceHandlerImpl implements BalanceHandler {
    @Override
    public Map<String, Integer> getBalanceComputedMap(List<FruitTransaction> fruitTransactions) {
        List<FruitTransaction> balanceList = fruitTransactions.stream()
                .filter(f -> f.getOperation() == FruitTransaction.Operation.BALANCE)
                .toList();
        ListService listService = new ListServiceImpl();
        return listService.getComputedMap(balanceList);
    }
}
