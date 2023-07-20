package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.FruitTransactionServiceImpl;

public class Main {
    public static void main(String[] args) {
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        System.out.println(fruitTransactionService.getReport("data.csv"));
    }
}
