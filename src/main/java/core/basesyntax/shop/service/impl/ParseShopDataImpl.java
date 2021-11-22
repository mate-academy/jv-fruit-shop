package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.service.ParseShopData;
import core.basesyntax.shop.strategy.ShopStrategy;
import java.util.Map;

public class ParseShopDataImpl implements ParseShopData {
    private ShopStrategy fruitShopStrategy;

    protected ParseShopDataImpl() {
        fruitShopStrategy = new ShopStrategy();
    }

    @Override
    public boolean distribute(String table) {
        table = table.replaceAll("type,\\w+,quantity\\n", "");
        String[] csvArr = table.split("\\n");
        for (String line : csvArr) {
            String type = line.replaceAll("((^[bspr]).+)", "$2");
            String item = line.replaceAll("([bspr],(\\w+),\\d+)", "$2");
            int quantity = Integer.parseInt(
                    line.replaceAll("(.+,(\\d+)$)", "$2"));
            fruitShopStrategy.chooseStrategy(type,item,quantity);
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
