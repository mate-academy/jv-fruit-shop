package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.service.FruitShopService;
import core.basesyntax.shop.service.ShopDataParser;
import core.basesyntax.shop.strategy.FruitShopStrategyImpl;
import java.util.Map;

public class ShopDataParserImpl implements ShopDataParser {
    private FruitShopStrategyImpl fruitShopStrategy;
    private FruitShopService fruitShopService;

    protected ShopDataParserImpl() {
        fruitShopStrategy = new FruitShopStrategyImpl();
        fruitShopService = new FruitShopServiceImpl();
    }

    @Override
    public boolean distribute(String table) {
        table = table.toLowerCase().replaceAll("type,\\w+,quantity\\n", "");
        String[] csvArr = table.split("\\n");
        for (String line : csvArr) {
            String type = line.replaceAll("((^[bspr]).+)", "$2");
            String item = line.replaceAll("([bspr],(\\w+),\\d+)", "$2");
            int quantity = Integer.parseInt(
                    line.replaceAll("(.+,(\\d+)$)", "$2"));
            try {
                fruitShopStrategy.chooseStrategy(type).invoke(fruitShopService, item, quantity);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Can't return appropriate method", e);
            }
        }
        return true;
    }

    @Override
    public String collect(Map<String, Integer> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
