package com.fruitshop.strategy;

import com.fruitshop.servicesimpl.ShopOperations;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HandlerConditionFactory {

    private final Map<String, Handler> conditions = new HashMap<>();

    public HandlerConditionFactory() {
        conditions.put(ShopOperations.BALANCE.getOperator(), new HandlerBalance());
        conditions.put(ShopOperations.SUPPLY.getOperator(), new HandlerSupply());
        conditions.put(ShopOperations.PURCHASE.getOperator(), new HandlerPurchase());
        conditions.put(ShopOperations.RETURN.getOperator(), new HandlerReturned());
    }

    public Optional<Handler> getHandler(String condition) {
        return Optional.ofNullable(conditions.get(condition));
    }
}
