package core.basesyntax;

import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Application {
    private static final String FILE_NAME_FROM = "src/main/resources/database.csv";
    private static final String FILE_NAME_TO = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> strategies = new HashMap<>();
        strategies.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        strategies.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        strategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        strategies.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        FruitShopService fruitService = new FruitShopServiceImpl(strategies);
        fruitService.createReport(FILE_NAME_FROM, FILE_NAME_TO);
    }
}
