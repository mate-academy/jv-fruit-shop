package strategy;

import dto.ShopOperation;
import java.util.List;
import java.util.Map;

public class Strategy {
    private final Map<String, OperationHandler> handlers;

    public Strategy(Map<String, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public void performOperation(List<ShopOperation> shopOperationList) {
        for (ShopOperation shopOperation : shopOperationList) {
            OperationHandler handler = handlers.get(shopOperation.getOperation());
            handler.apply(shopOperation);
        }
    }
}
