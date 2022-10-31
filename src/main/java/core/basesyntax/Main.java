package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FruitStorage fruitStorage = new FruitStorage();
        List<String> fromFile = new ReaderServiceImpl().readFromFile("text.txt");
    }
}
