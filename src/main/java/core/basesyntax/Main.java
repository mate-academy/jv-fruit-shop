package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.interfaces.FruitShopService;
import core.basesyntax.service.interfaces.strategy.TransactionStrategy;
import core.basesyntax.service.transactions.TransactionStrategyImpl;

public class Main {
    public static void main(String[] args) {
        FruitShopService fruitShopService = new FruitShopServiceImpl();
        fruitShopService.createReport("src/main/resources/input.csv");
        System.out.println(Storage.fruitsStorage);
    }
}
