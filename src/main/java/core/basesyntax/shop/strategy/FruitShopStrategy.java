package core.basesyntax.shop.strategy;

import java.lang.reflect.Method;

public interface FruitShopStrategy {
    static final String BALANCE = "b";
    static final String SUPPLY = "s";
    static final String RETURN_BACK = "r";
    static final String PURCHASE = "p";

    public Method chooseStrategy(String type) throws NoSuchMethodException;
}
