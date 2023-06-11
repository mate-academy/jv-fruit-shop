package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperationHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperationHandler;
import core.basesyntax.operation.ReturnOperationHandler;
import core.basesyntax.operation.SupplyOperationHandler;
import core.basesyntax.service.ParsingService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.ParcingCsvServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final File FROM_FILE_NAME = new File("src/main/java/resources/fromFile.csv");
    private static final File TO_FILE_NAME = new File("src/main/java/resources/toFile.csv");

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        BalanceOperationHandler balanceOperationHandler = new BalanceOperationHandler();
        PurchaseOperationHandler purchaseOperationHandler = new PurchaseOperationHandler();
        ReturnOperationHandler returnOperationHandler = new ReturnOperationHandler();
        SupplyOperationHandler supplyOperationHandler = new SupplyOperationHandler();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, balanceOperationHandler);
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, purchaseOperationHandler);
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, returnOperationHandler);
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, supplyOperationHandler);

        ReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        List<String> transactions = csvFileReaderService.readDataFromTheFile(FROM_FILE_NAME);
        ParsingService parsingService = new ParcingCsvServiceImpl();
        List<FruitTransaction> fruits = parsingService.parsingDataFromListOfStrings(transactions);

        ReportService reportService = new ReportServiceImpl(
                new OperationStrategyImpl(operationHandlerMap));
        reportService.applyTransactionsToStorage(fruits);
        String report = reportService.createFinalReport(Storage.fruits);
        WriterService writerService = new WriterServiceImpl();
        writerService.writeDataToFile(TO_FILE_NAME, report);
    }
}
