package core.basesyntax;

import core.basesyntax.dao.TransactionDaoImpl;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.filereader.FileParserImpl;
import core.basesyntax.service.filereader.FileReaderImpl;
import core.basesyntax.service.filewriter.FileWriterImpl;
import core.basesyntax.service.interfaces.FruitShopService;
import core.basesyntax.service.transactions.TransactionStrategyImpl;

public class Main {
    public static void main(String[] args) {
        FruitShopService fruitShopService = new FruitShopServiceImpl(new TransactionDaoImpl(),
                new FileReaderImpl(), new FileParserImpl(),
                new FileWriterImpl(), new TransactionStrategyImpl());
        fruitShopService.createReport("src/main/resources/input.csv");
    }
}
