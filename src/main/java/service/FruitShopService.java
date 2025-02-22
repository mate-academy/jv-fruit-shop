package service;

import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategyProvider;
import java.util.List;
import model.FruitTransaction;

public class FruitShopService {
    private final InventoryService inventoryService;
    private final OperationStrategyProvider strategyProvider;

    public FruitShopService(InventoryService inventoryService,
                            OperationStrategyProvider strategyProvider) {
        this.inventoryService = inventoryService;
        this.strategyProvider = strategyProvider;
    }

    public void processTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = strategyProvider
                    .getHandler(transaction.getOperation());
            handler.apply(inventoryService.getInventory(), transaction.getFruit(),
                    transaction.getQuantity());
        }
    }

}
