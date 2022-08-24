package core.basesyntax;

import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;

public class Main {
    private static ShopService shopService = new ShopServiceImpl();

    public static void main(String[] args) {
        shopService.servicing();
    }
}
