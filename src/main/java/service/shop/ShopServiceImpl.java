package service.shop;

import java.util.List;
import model.FruitTransaction;
import service.operation.OperationHandler;
import service.operation.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void handleTransactionList(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler =
                    operationStrategy.getOperation(transaction.getOperation());
            operationHandler.handle(transaction);
        }
    }
}
