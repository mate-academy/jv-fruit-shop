package core.basesyntax.shop.impl;

import core.basesyntax.shop.ReadFromFile;
import core.basesyntax.shop.ShopService;
import java.util.Map;

public class ParseData {
    public static final String BALANCE = "b";
    public static final String SUPPLY = "s";
    public static final String RETURN_BACK = "r";
    public static final String PURCHASE = "p";

    protected Map<String, Integer> parse(String filename, ReadFromFile readFromFile) {
        String table = readFromFile.read(filename).toLowerCase();
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
                case BALANCE :
                    shopService.balance(item, quantity);
                    break;
                case SUPPLY :
                    shopService.supply(item, quantity);
                    break;
                case RETURN_BACK :
                    shopService.returnBack(item, quantity);
                    break;
                default :
                case PURCHASE :
                    shopService.purchase(item, quantity);
                    break;
            }
        }
        return shopService.getMap();
    }
}
