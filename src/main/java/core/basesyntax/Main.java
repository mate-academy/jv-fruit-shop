package core.basesyntax;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.quantity.BalanceCounterHandler;
import core.basesyntax.service.quantity.CounterHandler;
import core.basesyntax.service.quantity.PurchaseCounterHandler;
import core.basesyntax.service.quantity.ReturnCounterHandler;
import core.basesyntax.service.quantity.SupplyCounterHandler;
import core.basesyntax.strategy.CounterStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, CounterHandler> counterHandlerMap = new HashMap<>();
        counterHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceCounterHandler());
        counterHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseCounterHandler());
        counterHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyCounterHandler());
        counterHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnCounterHandler());

        String fromFilePath = "src/main/resources/input.csv";
        String toFilePath = "src/main/resources/report.csv";
        CsvFileReaderService readerService = new CsvFileReaderServiceImpl();
        List<String[]> readData = readerService.readFromFile(fromFilePath);
        FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
        ShopService service = new ShopServiceImpl(fruitTransactionDao,
                new CounterStrategyImpl(counterHandlerMap));
        service.processTheData(readData);
        service.getStatistic();
        String report = service.makeReport();
        CsvFileWriterService writerService = new CsvFileWriterServiceImpl();
        writerService.writeToFile(report, toFilePath);
    }
}
