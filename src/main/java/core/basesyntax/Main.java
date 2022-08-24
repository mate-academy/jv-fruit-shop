package core.basesyntax;

import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;

public class Main {
    private static ShopService shopService;

    public static void setShopService(ShopService shopService) {
        Main.shopService = shopService;
    }

    public static void main(String[] args) {
        setShopService(new ShopServiceImpl());
        shopService.servicing("dataOfFruitShop.csv");
    }

}
