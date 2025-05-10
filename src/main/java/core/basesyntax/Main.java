package core.basesyntax;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.date.DateConverter;
import core.basesyntax.service.date.DateConverterImpl;
import core.basesyntax.service.date.ReportGenerator;
import core.basesyntax.service.date.ReportGeneratorImpl;
import core.basesyntax.service.db.StorageService;
import core.basesyntax.service.db.StorageServiceImpl;
import core.basesyntax.service.files.FileReaderCsv;
import core.basesyntax.service.files.FileReaderCsvImpl;
import core.basesyntax.service.files.FileWriterCsv;
import core.basesyntax.service.files.FileWriterCsvImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.OperationStrategyImpl;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("You must provide input and output file paths.");
        }

        String inputFile = args[0];

        FileReaderCsv fileReader = new FileReaderCsvImpl();
        List<String> inputReport = fileReader.read(inputFile);

        Map<FruitTransaction.Operation, OperationHandler> operationHandler = new HashMap<>();
        StorageService storageService = new StorageServiceImpl();
        operationHandler.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(storageService));
        operationHandler.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(storageService));
        operationHandler.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(storageService));
        operationHandler.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(storageService));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandler);

        DateConverter dateConverter = new DateConverterImpl();
        List<FruitTransaction> transactions = dateConverter.convertToTransaction(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport();

        String outputFile = args[1];

        FileWriterCsv fileWriter = new FileWriterCsvImpl();
        fileWriter.write(report, outputFile);

    }
}
