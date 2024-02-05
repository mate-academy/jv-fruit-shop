package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransactionRow;
import core.basesyntax.service.strategy.impl.BalanceStrategy;
import core.basesyntax.service.strategy.impl.PurchaseStrategy;
import core.basesyntax.service.strategy.impl.ReturnStrategy;
import core.basesyntax.service.strategy.impl.SupplyStrategy;
import java.util.List;
import java.util.Map;

public class StrategyService {
    private static final Map<Operation, OperationStrategy> strategyMap = Map.of(
            Operation.BALANCE, new BalanceStrategy(),
            Operation.SUPPLY, new SupplyStrategy(),
            Operation.PURCHASE, new PurchaseStrategy(),
            Operation.RETURN, new ReturnStrategy()
    );

    public int getFinalQuantityOfFruit(List<FruitTransactionRow> transactionsOfCertainFruit) {
        int finalQuantityOfFruit = 0;
        for (FruitTransactionRow transactionRow : transactionsOfCertainFruit) {
            finalQuantityOfFruit = strategyMap
                    .get(transactionRow.getOperation())
                    .execute(finalQuantityOfFruit, transactionRow.getQuantity());
        }
        return finalQuantityOfFruit;
    }
}
