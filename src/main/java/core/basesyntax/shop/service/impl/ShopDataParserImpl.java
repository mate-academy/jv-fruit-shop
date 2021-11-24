package core.basesyntax.shop.service.impl;

import static core.basesyntax.shop.service.Operations.operationsString;

import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.service.FruitShopService;
import core.basesyntax.shop.service.ShopDataParser;
import core.basesyntax.shop.strategy.FruitShopStrategy;
import core.basesyntax.shop.strategy.FruitShopStrategyImpl;
import java.util.Map;

public class ShopDataParserImpl implements ShopDataParser {
    private FruitShopStrategy fruitShopStrategy;
    private FruitShopService fruitShopService;

    public ShopDataParserImpl(FruitShopService fruitShopService) {
        this.fruitShopService = fruitShopService;
        this.fruitShopStrategy = new FruitShopStrategyImpl(fruitShopService);
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
            try {
                fruitShopStrategy.chooseStrategy(type).invoke(fruitShopService,
                        new Fruit(name), quantity);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Can't return appropriate method", e);
            }
        }
        return true;
    }

    @Override
    public String collect() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity");
        for (Map.Entry<Fruit, Integer> entry : fruitShopService.getMap().entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
