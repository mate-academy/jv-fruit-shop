package core.basesyntax.service.impl;

import core.basesyntax.model.OperationWithFruit;
import core.basesyntax.model.TransactionInfo;
import core.basesyntax.service.FruitShop;
import core.basesyntax.service.Operation;
import java.util.List;

public class FruitShopImpl implements FruitShop {
    private final Operation operationService;

    public FruitShopImpl(Operation operationService) {
        this.operationService = operationService;
    }

    @Override
    public void process(List<TransactionInfo> transferFruitList) {
        for (TransactionInfo item : transferFruitList) {
            OperationWithFruit type = item.getOperationType();
            operationService.getOperationHandler(type).handle(item);
        }
    }
}
