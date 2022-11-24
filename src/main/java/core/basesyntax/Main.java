package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CounterService;
import core.basesyntax.service.ParsingService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.imp.CountingServiceImpl;
import core.basesyntax.service.imp.ParsingTransactionsImpl;
import core.basesyntax.service.imp.ReaderServiceImpl;
import core.basesyntax.service.imp.WriteServiceImp;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/core/basesyntax/db/store.csv";
        ReaderService readerService = new ReaderServiceImpl();
        ParsingService parsingService = new ParsingTransactionsImpl();
        CounterService counterService = new CountingServiceImpl();
        WriterService write = new WriteServiceImp();

        List<String> strings = readerService.readFromFile(filePath);
        List<FruitTransaction> fruitTransactions = parsingService.parsingTransactions(strings);
        counterService.countFruits(fruitTransactions);
        write.writeToFile(Storage.getBalanceOfFruit());
    }
}
