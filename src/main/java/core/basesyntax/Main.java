package core.basesyntax;

import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.amount.ActivityHandler;
import core.basesyntax.service.amount.BalanceActivityHandler;
import core.basesyntax.service.amount.PurchaseActivityHandler;
import core.basesyntax.service.amount.ReturnActivityHandler;
import core.basesyntax.service.amount.SupplyActivityHandler;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
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
        Map<Operation, ActivityHandler>
                amountOfFruitsHandlersMap = new HashMap<>();

        amountOfFruitsHandlersMap
                .put(Operation.RETURN,
                    new ReturnActivityHandler(new FruitTransactionDaoImpl()));

        amountOfFruitsHandlersMap
                .put(Operation.BALANCE,
                    new BalanceActivityHandler(new FruitTransactionDaoImpl()));

        amountOfFruitsHandlersMap
                .put(Operation.PURCHASE,
                    new PurchaseActivityHandler(new FruitTransactionDaoImpl()));

        amountOfFruitsHandlersMap
                .put(Operation.SUPPLY,
                    new SupplyActivityHandler(new FruitTransactionDaoImpl()));

        TypeActivityStrategy typeActivityStrategy =
                new TypeActivityStrategyImpl(amountOfFruitsHandlersMap);

        FruitService fruitService =
                new FruitServiceImpl(new ReaderServiceImpl(new ParserServiceImpl()),
                        new WriterServiceImpl(), typeActivityStrategy);
        fruitService.writeReport(FILE);
    }
}
