package strategy;

import dto.ShopOperation;
import java.util.List;
import java.util.Map;

public class Strategy {
    public void performOperation(List<ShopOperation> shopOperationList,
                                 Map<String, OperationHandler> handlers) {
        for (ShopOperation shopOperation : shopOperationList) {
            OperationHandler handler = handlers.get(shopOperation.getOperation());
            handler.apply(shopOperation);
        }
    }
}
