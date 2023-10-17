package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceActivityStrategyImpl;
import core.basesyntax.strategy.PurchaseActivityStrategyImpl;
import core.basesyntax.strategy.ReturnActivityStrategyImpl;
import core.basesyntax.strategy.SupplyActivityStrategyImpl;
import core.basesyntax.strategy.TypeActivityStrategy;
import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, TypeActivityStrategy>
                amountOfFruitsHandlersMap = new HashMap<>();

        amountOfFruitsHandlersMap.put(FruitTransaction.Operation.RETURN,
                new ReturnActivityStrategyImpl());
        amountOfFruitsHandlersMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceActivityStrategyImpl());
        amountOfFruitsHandlersMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseActivityStrategyImpl());
        amountOfFruitsHandlersMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyActivityStrategyImpl());

        FruitService fruitService = new FruitServiceImpl(amountOfFruitsHandlersMap,
                new ReaderServiceImpl(), new WriterServiceImpl());
        fruitService.writeReport("file.CSV");
    }
}
