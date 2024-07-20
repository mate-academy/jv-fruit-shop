package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.utility.ListService;
import core.basesyntax.utility.impl.ListServiceImpl;
import java.util.List;
import java.util.Map;

public class PurchaseHandlerImpl implements PurchaseHandler {
    @Override
    public Map<String, Integer> getPurchaseComputedMap(List<FruitTransaction> fruitTransactions) {
        List<FruitTransaction> purchaseList = fruitTransactions.stream()
                .filter(f -> f.getOperation() == FruitTransaction.Operation.PURCHASE)
                .toList();
        ListService listService = new ListServiceImpl();
        return listService.getComputedMap(purchaseList);
    }
}
