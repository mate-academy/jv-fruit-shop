package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverterService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataConverterServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH_TO_READ_FROM = "src/main/resources/reportToRead.csv";
    private static final String FILE_PATH_TO_WRITE = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationsMap = new HashMap<>();
        operationsMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationsMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationsMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        operationsMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationsMap);
        ReaderService readerService = new ReaderServiceImpl();
        DataConverterService dataConverterService = new DataConverterServiceImpl();
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        WriterService writerService = new FileWriterServiceImpl();
        List<String> dataFromFile = readerService.read(FILE_PATH_TO_READ_FROM);
        List<FruitTransaction> convertData = dataConverterService.convert(dataFromFile);
        shopService.process(convertData);
        String report = reportGenerator.getReport(Storage.getAll());
        writerService.write(report, FILE_PATH_TO_WRITE);
    }
}
