package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.FactoryStrategy;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private static final String SOURCE_FILE_PATH = "src/main/resources/Input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/Report.csv";

    public static void main(String[] args) {
        Map<FruitOperation, OperationHandler> strategyType = Map.of(
                FruitOperation.BALANCE, new BalanceOperation(),
                FruitOperation.SUPPLY, new SupplyOperation(),
                FruitOperation.PURCHASE, new PurchaseOperation(),
                FruitOperation.RETURN, new ReturnOperation()
        );

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
        FruitShopService fruitShopService
                = new FruitShopServiceImpl(new FactoryStrategy(strategyType));
        ReportService reportService = new ReportServiceImpl(Storage.fruits);
        FileWriterService fileWriterService = new FileWriterServiceImpl();

        List<String> stringFromFile = fileReaderService.readFromFile(SOURCE_FILE_PATH);
        List<FruitTransaction> fruitTransactionList
                = fruitTransactionParser.parse(stringFromFile);
        fruitShopService.process(fruitTransactionList);
        String report = reportService.generateReport();
        fileWriterService.writeToFile(REPORT_FILE_PATH, report);
    }
}
