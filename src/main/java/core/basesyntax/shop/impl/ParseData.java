package core.basesyntax.shop.impl;

import core.basesyntax.shop.ReadFromFile;
import core.basesyntax.shop.ShopService;
import java.util.Map;

public class ParseData {
    protected Map<String, Integer> parse(String filename, ReadFromFile readFromFile) {
        String table = readFromFile.read(filename);
        ShopService shopService = new FruitShopService();
        if (!(new Validator().test(table))) {
            throw new RuntimeException("Corrupted file data");
        }
        table = table.replaceAll("type,\\w+,quantity\\n", "");
        String[] csvArr = table.split("\\n");
        for (String line : csvArr) {
            String type = line.replaceAll("((^[bspr]).+)", "$2");
            String item = line.replaceAll("([bspr],(\\w+),\\d+)", "$2");
            int quantity = Integer.parseInt(
                    line.replaceAll("(.+,(\\d+)$)", "$2"));
            switch (type) {
                case "b" :
                    shopService.balance(item, quantity);
                    break;
                case "s" :
                    shopService.supply(item, quantity);
                    break;
                case "r" :
                    shopService.returnBack(item, quantity);
                    break;
                default :
                case "p" :
                    shopService.purchase(item, quantity);
                    break;
            }
        }
        return shopService.getMap();
    }
}
