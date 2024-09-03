package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.fileservice.DataConverter;
import core.basesyntax.service.fileservice.DataConverterImpl;
import core.basesyntax.service.fileservice.FileReaderService;
import core.basesyntax.service.fileservice.FileReaderServiceImpl;
import core.basesyntax.service.fileservice.FileWriterService;
import core.basesyntax.service.fileservice.FileWriterServiceImpl;
import core.basesyntax.service.reportservice.ReportGeneratorService;
import core.basesyntax.service.reportservice.ReportGeneratorServiceImpl;
import core.basesyntax.service.shopservice.ShopService;
import core.basesyntax.service.shopservice.ShopServiceImpl;
import core.basesyntax.service.strategy.BalanceOperation;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import core.basesyntax.service.strategy.PurchaseOperation;
import core.basesyntax.service.strategy.ReturnOperation;
import core.basesyntax.service.strategy.SupplyOperation;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    private static final String FILE_TO_READ = "src/main/report/reportToRead.csv";
    private static final String FILE_TO_WRITE = "src/main/report/finalReport.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> inputReport = fileReaderService.readFromFile(FILE_TO_READ);

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

        Map<Operation, OperationHandler> operationHandlers = Map.of(
                Operation.PURCHASE, new PurchaseOperation(fruitStorageDao),
                Operation.BALANCE, new BalanceOperation(fruitStorageDao),
                Operation.RETURN, new ReturnOperation(fruitStorageDao),
                Operation.SUPPLY, new SupplyOperation(fruitStorageDao)
        );

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGeneratorService reportGenerator = new ReportGeneratorServiceImpl(fruitStorageDao);
        String finalReport = reportGenerator.createReportFromDb();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeReportToFile(finalReport, FILE_TO_WRITE);
    }
}
