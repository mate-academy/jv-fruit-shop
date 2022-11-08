package strategy.operationmap;

import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import strategy.transactionhandlers.BalanceTransactionHandlerImpl;
import strategy.transactionhandlers.PurchaseTransactionHandlerImpl;
import strategy.transactionhandlers.ReturnTransactionHandlerImpl;
import strategy.transactionhandlers.SupplyTransactionHandlerImpl;
import strategy.transactionhandlers.TransactionHandler;

public class OperationMapImpl implements OperationMap {
    private Map<FruitTransaction.Operation, TransactionHandler> map;

    public OperationMapImpl() {
        this.map = new HashMap<>();
    }

    @Override
    public Map<FruitTransaction.Operation, TransactionHandler> getOperationMap() {
        TransactionHandler balance = new BalanceTransactionHandlerImpl();
        addOperationToMap(FruitTransaction.Operation.BALANCE,balance);
        TransactionHandler supply = new SupplyTransactionHandlerImpl();
        addOperationToMap(FruitTransaction.Operation.SUPPLY,supply);
        TransactionHandler retur = new ReturnTransactionHandlerImpl();
        addOperationToMap(FruitTransaction.Operation.RETURN,retur);
        TransactionHandler purchase = new PurchaseTransactionHandlerImpl();
        addOperationToMap(FruitTransaction.Operation.PURCHASE,purchase);
        return map;
    }

    @Override
    public void addOperationToMap(FruitTransaction.Operation operation,
                                  TransactionHandler handler) {
        map.put(operation, handler);
    }
}
