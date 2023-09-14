package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.ShopOperationHandler;
import core.basesyntax.handler.impl.BalanceOperationHandler;
import core.basesyntax.handler.impl.PurchaseOperationHandler;
import core.basesyntax.handler.impl.ReturnOperationHandler;
import core.basesyntax.handler.impl.SupplyOperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.DataProcessorService;
import core.basesyntax.service.DataReaderService;
import core.basesyntax.service.DataWriterService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.CsvReaderService;
import core.basesyntax.service.impl.CsvWriterService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FruitShopDataProcessorService;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.strategy.ShopOperationStrategy;
import core.basesyntax.strategy.ShopOperationStrategyImpl;
import core.basesyntax.utility.FruitQuantityChecker;
import core.basesyntax.utility.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_CSV = "src/main/resources/input.csv";
    private static final String REPORT_CSV = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, ShopOperationHandler> shopOperationHandlerMap = new HashMap<>();
        shopOperationHandlerMap.put(Operation.BALANCE,
                new BalanceOperationHandler());
        shopOperationHandlerMap.put(Operation.RETURN,
                new ReturnOperationHandler());
        shopOperationHandlerMap.put(Operation.SUPPLY,
                new SupplyOperationHandler());
        shopOperationHandlerMap.put(Operation.PURCHASE,
                new PurchaseOperationHandler());
        DataReaderService dataReaderService = new CsvReaderService();
        List<String> retrievedDataLines = dataReaderService.readData(INPUT_CSV);

        DataParserService dataParserService = new DataParserServiceImpl();
        List<FruitTransaction> transactionList = dataParserService.parseData(retrievedDataLines);

        ShopOperationStrategy operationStrategy =
                new ShopOperationStrategyImpl(shopOperationHandlerMap);
        DataProcessorService dataProcessorService =
                new FruitShopDataProcessorService(operationStrategy);
        dataProcessorService.processData(transactionList);

        new FruitQuantityChecker().checkFruitQuantity(Storage.fruitStorage);

        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        String reportData = reportCreatorService.createReport();

        DataWriterService csvWriter = new CsvWriterService();
        csvWriter.writeData(reportData, REPORT_CSV);
    }
}
