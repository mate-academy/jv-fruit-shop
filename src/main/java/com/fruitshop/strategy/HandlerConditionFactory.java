package com.fruitshop.strategy;

import com.fruitshop.servicesimpl.ShopOperations;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HandlerConditionFactory {
    private final Map<String, OperationHandler> operationHandlerMap;

    {
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(ShopOperations.BALANCE.getOperator(),
                new OperationHandlerBalance());
        operationHandlerMap.put(ShopOperations.SUPPLY.getOperator(),
                new OperationHandlerSupply());
        operationHandlerMap.put(ShopOperations.PURCHASE.getOperator(),
                new OperationHandlerPurchase());
        operationHandlerMap.put(ShopOperations.RETURN.getOperator(),
                new OperationHandlerReturned());
    }

    public Optional<OperationHandler> getHandler(String condition) {
        return Optional.ofNullable(operationHandlerMap.get(condition));
    }
}
