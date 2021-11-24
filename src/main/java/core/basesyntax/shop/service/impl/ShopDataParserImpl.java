package core.basesyntax.shop.service.impl;

import static core.basesyntax.shop.service.Operations.operationsString;

import core.basesyntax.shop.dao.FruitShopDao;
import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.service.FruitShopService;
import core.basesyntax.shop.service.ShopDataParser;
import core.basesyntax.shop.strategy.FruitShopStrategy;

public class ShopDataParserImpl implements ShopDataParser {
    private FruitShopStrategy fruitShopStrategy;
    private FruitShopDao fruitShopDao;

    public ShopDataParserImpl(FruitShopStrategy fruitShopStrategy, FruitShopDao fruitShopDao) {
        this.fruitShopStrategy = fruitShopStrategy;
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public boolean distribute(String table) {
        table = table.toLowerCase().replaceAll("type,\\w+,quantity\\n", "");
        String[] csvArr = table.split("\\n");
        for (String line : csvArr) {
            String type = line.replaceAll("((^["
                    + operationsString() + "]).+)", "$2");
            String name = line.replaceAll("(["
                    + operationsString() + "],(\\w+),\\d+)", "$2");
            int quantity = Integer.parseInt(
                    line.replaceAll("(.+,(\\d+)$)", "$2"));
            FruitShopService operationHandler = null;
            try {
                operationHandler = fruitShopStrategy.chooseStrategy(type)
                        .getConstructor(FruitShopDao.class).newInstance(fruitShopDao);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Can't create FruitShopService implementation", e);
            }
            operationHandler.apply(new Fruit(name), quantity);
        }
        return true;
    }
}
