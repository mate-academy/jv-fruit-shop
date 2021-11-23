package core.basesyntax.shop.strategy;

import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.service.FruitShopService;
import core.basesyntax.shop.service.Operations;
import java.lang.reflect.Method;

public class FruitShopStrategyImpl implements FruitShopStrategy {
    private static final String BALANCE = Operations.B.name().toLowerCase();
    private static final String SUPPLY = Operations.S.name().toLowerCase();
    private static final String RETURN_BACK = Operations.R.name().toLowerCase();
    private static final String PURCHASE = Operations.P.name().toLowerCase();
    private FruitShopService fruitShopService;

    public FruitShopStrategyImpl(FruitShopService fruitShopService) {
        this.fruitShopService = fruitShopService;
    }

    @Override
    public Method chooseStrategy(String type) throws NoSuchMethodException {
        if (type.equals(BALANCE)) {
            return fruitShopService.getClass()
                    .getMethod("balance", Fruit.class, Integer.class);
        } else if (type.equals(SUPPLY)) {
            return fruitShopService.getClass()
                    .getMethod("supply", Fruit.class, Integer.class);
        } else if (type.equals(RETURN_BACK)) {
            return fruitShopService.getClass()
                    .getMethod("returnBack", Fruit.class, Integer.class);
        } else if (type.equals(PURCHASE)) {
            return fruitShopService.getClass()
                    .getMethod("purchase", Fruit.class, Integer.class);
        }
        throw new RuntimeException("Unsupported operation :" + type);
    }
}
