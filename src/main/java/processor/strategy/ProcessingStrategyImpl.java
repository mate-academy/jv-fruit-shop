package processor.strategy;

import java.util.HashMap;
import java.util.Map;
import model.Operation;
import processor.strategy.operation.Balance;
import processor.strategy.operation.Purchase;
import processor.strategy.operation.Return;
import processor.strategy.operation.Supply;
import processor.strategy.operation.Transaction;

public class ProcessingStrategyImpl implements ProcessingStrategy {
    private final Map<Operation, Transaction> transactionMap = new HashMap<>();

    public ProcessingStrategyImpl() {
        transactionMap.put(Operation.BALANCE, new Balance());
        transactionMap.put(Operation.SUPPLY, new Supply());
        transactionMap.put(Operation.PURCHASE, new Purchase());
        transactionMap.put(Operation.RETURN, new Return());
    }

    @Override
    public void makeTransaction(Operation operation) {
        transactionMap.get(operation).handleOperation();
    }

}
