package strategy;

import java.util.List;
import java.util.Map;
import shop.FruitShopOperation;

public class Strategy {
    private Map<String, TypeHandler> typeHandlers;

    public Strategy(Map<String, TypeHandler> typeHandlers) {
        this.typeHandlers = typeHandlers;
    }

    public void operationHandler(List<FruitShopOperation> operation) {
        for (FruitShopOperation fruitShopOperation : operation) {
            TypeHandler typeHandler = typeHandlers.get(fruitShopOperation.getOperation());
            typeHandler.countAmount(fruitShopOperation);
        }
    }
}
