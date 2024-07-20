package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.SupplyHandler;
import core.basesyntax.utility.ListService;
import core.basesyntax.utility.impl.ListServiceImpl;
import java.util.List;
import java.util.Map;

public class SupplyHandlerImpl implements SupplyHandler {
    @Override
    public Map<String, Integer> getSupplyComputedMap(List<FruitTransaction> fruitTransactions) {
        List<FruitTransaction> supplyList = fruitTransactions.stream()
                .filter(f -> f.getOperation() == FruitTransaction.Operation.SUPPLY)
                .toList();
        ListService listService = new ListServiceImpl();
        return listService.getComputedMap(supplyList);
    }
}
