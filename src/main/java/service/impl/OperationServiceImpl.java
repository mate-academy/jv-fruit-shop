package service.impl;

import strategy.OperationHandler;
import service.OperationService;
import strategy.OperationType;
import strategy.impl.BalanceHandler;
import strategy.impl.PurchaseHandler;
import strategy.impl.ReturnHandler;
import strategy.impl.SupplyHandler;

import java.util.HashMap;
import java.util.Map;

public class OperationServiceImpl implements OperationService {
    private static Map<String , OperationHandler> operationMap;

    @Override
    public OperationHandler createOperation(String operationSymbol) {
        return getOperationMap().get(operationSymbol);
    }

    private Map<String , OperationHandler> getOperationMap() {
        operationMap = new HashMap<>();
        operationMap.put(OperationType.BALANCE.getCode(), new BalanceHandler());
        operationMap.put(OperationType.SUPPLY.getCode(), new SupplyHandler());
        operationMap.put(OperationType.PURCHASE.getCode(), new PurchaseHandler());
        operationMap.put(OperationType.RETURN.getCode(), new ReturnHandler());
        return operationMap;
    }
}
