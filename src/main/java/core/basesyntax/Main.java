package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.interfaces.FruitShopService;

public class Main {
    public static void main(String[] args) {
        FruitShopService fruitShopService = new FruitShopServiceImpl();
        fruitShopService.createReport("src/main/resources/input.csv");
    }
}
