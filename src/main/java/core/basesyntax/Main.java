package core.basesyntax;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.date.DateConverter;
import core.basesyntax.service.date.DateConverterImpl;
import core.basesyntax.service.date.ReportGenerator;
import core.basesyntax.service.date.ReportGeneratorImpl;
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
        FileReaderCsv fileReader = new FileReaderCsvImpl();
        List<String> inputReport = fileReader.read("fileToRead.csv");

        Map<FruitTransaction.Operation, OperationHandler> operationHandler = new HashMap<>();
        operationHandler.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandler.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandler.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandler.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandler);

        DateConverter dateConverter = new DateConverterImpl();
        List<FruitTransaction> transactions = dateConverter.convertToTransaction(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        Map<String, Integer> storage = new HashMap<>();

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport(storage);

        FileWriterCsv fileWriter = new FileWriterCsvImpl();
        fileWriter.write(report, "fileToRead.csv");

    }
}
