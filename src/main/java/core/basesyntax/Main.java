package core.basesyntax;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.file.FileReader;
import core.basesyntax.file.FileReaderImpl;
import core.basesyntax.file.FileWriter;
import core.basesyntax.file.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StorageServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("src/main/resources/fruit_shop.csv");

        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        StorageService storageService = new StorageServiceImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(storageService));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(storageService));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(storageService));
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(storageService));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy, storageService);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storageService);
        String report = reportGenerator.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, "finalReport.csv");
    }
}
