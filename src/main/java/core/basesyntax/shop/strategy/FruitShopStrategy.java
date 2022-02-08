package core.basesyntax.shop.strategy;

import core.basesyntax.shop.service.FruitShopService;

public interface FruitShopStrategy {
    Class<? extends FruitShopService> chooseStrategy(String type);
}
