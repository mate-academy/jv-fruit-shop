package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.impl.BalanceOperationHandler;
import core.basesyntax.service.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.service.strategy.impl.ReturnOperationHandler;
import core.basesyntax.service.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> map = new HashMap<>();
        map.put(Operation.BALANCE, new BalanceOperationHandler());
        map.put(Operation.PURCHASE, new PurchaseOperationHandler());
        map.put(Operation.RETURN, new ReturnOperationHandler());
        map.put(Operation.SUPPLY, new SupplyOperationHandler());
        FruitShopService fruitShopService = new FruitShopServiceImpl(map);
        String fileFrom = "src/main/java/core/basesyntax/resources/fromFile";
        String fileTo = "src/main/java/core/basesyntax/resources/toFile";
        fruitShopService.createDayReport(fileFrom, fileTo);
    }

}
