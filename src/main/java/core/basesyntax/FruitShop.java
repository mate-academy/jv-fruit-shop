package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.Balance;
import core.basesyntax.strategy.impl.FactoryStrategy;
import core.basesyntax.strategy.impl.Purchase;
import core.basesyntax.strategy.impl.Return;
import core.basesyntax.strategy.impl.Supply;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private static final String SOURCE_FILE_PATH = "src/main/resources/Input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/Report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> strategyType = Map.of(
                FruitTransaction.Operation.BALANCE, new Balance(),
                FruitTransaction.Operation.SUPPLY, new Supply(),
                FruitTransaction.Operation.PURCHASE, new Purchase(),
                FruitTransaction.Operation.RETURN, new Return()
        );

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
