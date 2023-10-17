package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.amount.ActivityHandler;
import core.basesyntax.service.amount.BalanceActivityHandler;
import core.basesyntax.service.amount.PurchaseActivityHandler;
import core.basesyntax.service.amount.ReturnActivityHandler;
import core.basesyntax.service.amount.SupplyActivityHandler;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.TypeActivityStrategy;
import core.basesyntax.strategy.TypeActivityStrategyImpl;
import java.util.HashMap;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String FILE = "file.CSV";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, ActivityHandler>
                amountOfFruitsHandlersMap = new HashMap<>();

        amountOfFruitsHandlersMap
                .put(FruitTransaction.Operation.RETURN,
                    new ReturnActivityHandler());

        amountOfFruitsHandlersMap
                .put(FruitTransaction.Operation.BALANCE,
                    new BalanceActivityHandler());

        amountOfFruitsHandlersMap
                .put(FruitTransaction.Operation.PURCHASE,
                    new PurchaseActivityHandler());

        amountOfFruitsHandlersMap
                .put(FruitTransaction.Operation.SUPPLY,
                    new SupplyActivityHandler());

        TypeActivityStrategy typeActivityStrategy =
                new TypeActivityStrategyImpl(amountOfFruitsHandlersMap);

        FruitService fruitService =
                new FruitServiceImpl(new ReaderServiceImpl(),
                        new WriterServiceImpl(), typeActivityStrategy);
        fruitService.writeReport(FILE);
    }
}
