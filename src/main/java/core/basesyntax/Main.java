package core.basesyntax;

import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;

public class Main {

    public static void main(String[] args) {

        FruitShopService fruitShopService = new FruitShopServiceImpl();
        fruitShopService.makeReport();
    }
}


