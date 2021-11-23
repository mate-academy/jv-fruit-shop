package core.basesyntax.shop.strategy;

import java.lang.reflect.Method;

public interface FruitShopStrategy {

    public Method chooseStrategy(String type) throws NoSuchMethodException;
}
