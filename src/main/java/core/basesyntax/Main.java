package core.basesyntax;

import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;

public class Main {
    private static final String PATH = "src/main/java/core/basesyntax/db/data.csv";
    private static final String REPORT = "src/main/java/core/basesyntax/db/report.csv";

    public static void main(String[] args) {
        FileWriterService writer = new FileWriterServiceImpl();
        FruitShopService transactions = new FruitShopServiceImpl();
        writer.writeToFile(transactions.fruitTransaction(PATH), REPORT);
    }
}
