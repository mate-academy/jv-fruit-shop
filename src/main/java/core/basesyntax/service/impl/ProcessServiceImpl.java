package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.ProcessService;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.List;
import java.util.Map;

public class ProcessServiceImpl implements ProcessService {
    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactionList) {
        Map<OperationType, Operation> strategyMap = getStrategyMap();
        fruitTransactionList.forEach(f -> strategyMap
                .get(f.getOperationType()).performOperation(f));
    }

    private static Map<OperationType, Operation> getStrategyMap() {
        Map<OperationType, Operation> strategyMap = Map.of(
                OperationType.BALANCE, new BalanceOperation(),
                OperationType.PURCHASE, new PurchaseOperation(),
                OperationType.SUPPLY, new SupplyOperation(),
                OperationType.RETURN, new ReturnOperation()
        );
        return strategyMap;
    }
}
