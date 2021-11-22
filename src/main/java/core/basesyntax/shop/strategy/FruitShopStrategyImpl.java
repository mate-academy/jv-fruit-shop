package core.basesyntax.shop.strategy;

import core.basesyntax.shop.service.FruitShopService;
import core.basesyntax.shop.service.impl.FruitShopServiceImpl;
import java.lang.reflect.Method;

public class FruitShopStrategyImpl implements FruitShopStrategy {
    private FruitShopService fruitShopService;

    public FruitShopStrategyImpl() {
        fruitShopService = new FruitShopServiceImpl();
    }

    @Override
    public Method chooseStrategy(String type) throws NoSuchMethodException {
        switch (type) {
            case BALANCE :
                return fruitShopService.getClass()
                        .getMethod("balance", String.class, Integer.class);
            case SUPPLY :
                return fruitShopService.getClass()
                        .getMethod("supply", String.class, Integer.class);
            case RETURN_BACK :
                return fruitShopService.getClass()
                        .getMethod("returnBack", String.class, Integer.class);
            default :
            case PURCHASE :
                return fruitShopService.getClass()
                        .getMethod("purchase", String.class, Integer.class);
        }
    }
}
