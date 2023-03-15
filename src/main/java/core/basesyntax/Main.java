package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.implementation.FileReaderServiceImpl;
import core.basesyntax.service.implementation.FileWriterServiceImpl;
import core.basesyntax.service.implementation.FruitShopServiceImpl;
import core.basesyntax.service.implementation.ParserServiceImpl;
import core.basesyntax.service.implementation.ReportServiceImpl;
import core.basesyntax.strategy.Balance;
import core.basesyntax.strategy.FactoryStrategy;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.Purchase;
import core.basesyntax.strategy.Return;
import core.basesyntax.strategy.Supply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE_PATH = "src/main/resources/FruitStorageOperation.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/Report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> strategyType = new HashMap<>();
        strategyType.put(FruitTransaction.Operation.BALANCE, new Balance());
        strategyType.put(FruitTransaction.Operation.PURCHASE, new Purchase());
        strategyType.put(FruitTransaction.Operation.SUPPLY, new Supply());
        strategyType.put(FruitTransaction.Operation.RETURN, new Return());

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> stringFromFile = fileReaderService.readFromFile(SOURCE_FILE_PATH);

        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactionList
                = parserService.parseFruitTransactions(stringFromFile);

        FruitShopService fruitShopService
                = new FruitShopServiceImpl(new FactoryStrategy(strategyType));
        fruitShopService.processFruitTransactions(fruitTransactionList);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.generateReport(Storage.fruits);

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(REPORT_FILE_PATH, report);
    }
}
