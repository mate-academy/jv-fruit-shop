package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.utility.ListService;
import core.basesyntax.utility.impl.ListServiceImpl;
import java.util.List;
import java.util.Map;

public class ReturnHandlerImpl implements ReturnHandler {
    @Override
    public Map<String, Integer> getReturnComputedMap(List<FruitTransaction> fruitTransactions) {
        List<FruitTransaction> returnList = fruitTransactions.stream()
                .filter(f -> f.getOperation() == FruitTransaction.Operation.RETURN)
                .toList();
        ListService listService = new ListServiceImpl();
        return listService.getComputedMap(returnList);
    }
}
