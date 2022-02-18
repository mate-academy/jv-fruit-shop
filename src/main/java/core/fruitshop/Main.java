package core.fruitshop;

import core.fruitshop.model.FruitTransaction.Operation;
import core.fruitshop.service.FruitShopService;
import core.fruitshop.service.impl.FruitShopServiceImpl;
import core.fruitshop.service.strategy.OperationHandler;
import core.fruitshop.service.strategy.impl.BalanceOperationHandler;
import core.fruitshop.service.strategy.impl.PurchaseOperationHandler;
import core.fruitshop.service.strategy.impl.ReturnOperationHandler;
import core.fruitshop.service.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Operation, OperationHandler> map = new HashMap<>();
        map.put(Operation.BALANCE, new BalanceOperationHandler());
        map.put(Operation.PURCHASE, new PurchaseOperationHandler());
        map.put(Operation.RETURN, new ReturnOperationHandler());
        map.put(Operation.SUPPLY, new SupplyOperationHandler());
        FruitShopService fruitShopService = new FruitShopServiceImpl(map);
        String fileFrom = "src/main/java/core/fruitshop/resources/fromFile";
        String fileTo = "src/main/java/core/fruitshop/resources/toFile";
        fruitShopService.createDayReport(fileFrom, fileTo);
    }

}
