package core.basesyntax;

import core.basesyntax.lib.Injector;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;

public class Main {
    public static void main(String[] args) {
        Injector injector = new Injector().getInjector();
        ShopService shopService = (ShopService) injector.getInstance(ShopServiceImpl.class);
        shopService.servicing("dataOfFruitShop.csv", "reportOfFruitShop.csv");
    }

}
