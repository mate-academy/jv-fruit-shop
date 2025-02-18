package service;

import core.basesyntax.strategy.OperationHandler;
import exception.OperationException;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public class FruitShopService {
    private final InventoryService inventoryService;
    private final Map<FruitTransaction.OperationType, OperationHandler> operationStrategy;

    public FruitShopService(InventoryService inventoryService,
                            Map<FruitTransaction.OperationType,
                                    OperationHandler> operationStrategy) {
        this.inventoryService = inventoryService;
        this.operationStrategy = operationStrategy;
    }

    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            if (handler == null) {
                throw new OperationException("Unknown operation type: "
                        + transaction.getOperation());
            }
            handler.apply(inventoryService.getInventory(), transaction.getFruit(),
                    transaction.getQuantity());
        }
    }

    public Map<String, Integer> getInventory() {
        return inventoryService.getInventory();
    }
}
