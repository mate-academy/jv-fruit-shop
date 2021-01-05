package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruits;
import core.basesyntax.model.Operations;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationWithFruits;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private Map<Operations, OperationWithFruits> operationMap;

    public FruitServiceImpl(Map<Operations, OperationWithFruits> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public void chooseStrategy(List<Transaction> transaction) {
        for (Transaction oneAction : transaction) {
            operationMap.get(oneAction.getOperation()).apply(oneAction);
        }
    }

    @Override
    public Map<Fruits, Integer> storage() {
        return Storage.storage;
    }
}
