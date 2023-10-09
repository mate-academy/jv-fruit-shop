package fruit.shop.service.operation;

import fruit.shop.service.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public String getOperation(FruitTransaction.Operation code) {
        return FruitTransaction.Operation.BALANCE.getCode();
    }
}
