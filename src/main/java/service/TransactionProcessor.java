package service;

import core.basesyntax.FruitInventory;
import core.basesyntax.FruitTransaction;
import db.DataBase;
import handlers.BalanceHandler;
import handlers.PurchaseHandler;
import handlers.ReturnHandler;
import handlers.SupplyHandler;
import handlers.TransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionProcessor {
    private final Map<FruitTransaction.Operation, TransactionHandler> handlers;
    private final DataBase dataBase;

    public TransactionProcessor(DataBase dataBase) {
        handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        this.dataBase = dataBase;
    }

    public void processTransactions(List<FruitTransaction> transactions) {
        FruitInventory inventory = dataBase.getOrCreateInventory();

        for (FruitTransaction transaction : transactions) {
            FruitTransaction.Operation operation = transaction.getOperation();
            TransactionHandler handler = handlers.get(operation);

            if (handler != null) {
                handler.handleTransaction(inventory, transaction);
                String fruit = transaction.getFruit();
                dataBase.updateInventory(fruit, inventory);
            } else {
                throw new RuntimeException("Unknown operation: " + operation);
            }

        }
    }
}
