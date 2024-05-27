package core.basesyntax.service.strategy;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.operation.handler.impl.BalanceOperationImpl;
import core.basesyntax.handler.operation.handler.impl.PurchaseOperationImpl;
import core.basesyntax.handler.operation.handler.impl.ReturnOperationImpl;
import core.basesyntax.handler.operation.handler.impl.SupplyOperationImpl;
import core.basesyntax.model.OperationModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<OperationModel.Operation, OperationHandler> operationHandlerMap
            = new HashMap<>();

    public TransactionStrategyImpl() {
        operationHandlerMap.put(OperationModel.Operation.BALANCE, new BalanceOperationImpl());
        operationHandlerMap.put(OperationModel.Operation.RETURN, new ReturnOperationImpl());
        operationHandlerMap.put(OperationModel.Operation.SUPPLY, new SupplyOperationImpl());
        operationHandlerMap.put(OperationModel.Operation.PURCHASE, new PurchaseOperationImpl());
    }

    @Override
    public void transactionOperator(List<OperationModel> operationList) {
        for (OperationModel model : operationList) {
            OperationHandler handler = operationHandlerMap.get(model.getOperation());
            if (handler != null) {
                handler.operationType(model.getFruit(), model.getAmount());
            } else {
                throw new RuntimeException("Not valid transaction");
            }
        }
    }
}
