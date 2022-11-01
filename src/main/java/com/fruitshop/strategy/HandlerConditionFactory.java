package com.fruitshop.strategy;

import com.fruitshop.servicesimpl.ShopOperations;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HandlerConditionFactory {
    private final Map<String, Handler> operationHandlerMap;

    {
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(ShopOperations.BALANCE.getOperator(), new HandlerBalance());
        operationHandlerMap.put(ShopOperations.SUPPLY.getOperator(), new HandlerSupply());
        operationHandlerMap.put(ShopOperations.PURCHASE.getOperator(), new HandlerPurchase());
        operationHandlerMap.put(ShopOperations.RETURN.getOperator(), new HandlerReturned());
    }

    public Optional<Handler> getHandler(String condition) {
        return Optional.ofNullable(operationHandlerMap.get(condition));
    }
}
