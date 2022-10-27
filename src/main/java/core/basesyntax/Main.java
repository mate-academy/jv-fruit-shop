package core.basesyntax;

import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.impl.FruitShopServiceImpl;

public class Main {
    public static void main(String[] args) {
        FruitShopService fruitShopService = new FruitShopServiceImpl();
        System.out.println(fruitShopService.getReportAfterWorkingDay());
        fruitShopService.writeReportInFile();
    }
}
