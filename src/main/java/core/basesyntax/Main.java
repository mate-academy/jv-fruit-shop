package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FileReaderService;
import core.basesyntax.services.FileWriterService;
import core.basesyntax.services.ReportGeneratorService;
import core.basesyntax.services.TransactionProcessorService;
import core.basesyntax.services.impl.DataConverter;
import core.basesyntax.services.impl.FileReaderServiceImpl;
import core.basesyntax.services.impl.FileWriterServiceImpl;
import core.basesyntax.services.impl.ReportGeneratorServiceImpl;
import core.basesyntax.services.impl.TransactionProcessorServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String resourсePath = "src/main/resources";
        final String finalReportPath = "src/main/resources";

        Storage storage = new Storage();

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(storage));
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(storage));
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(storage));
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler(storage));

        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);

        FileReaderService readerService = new FileReaderServiceImpl();
        FileWriterService writerService = new FileWriterServiceImpl();
        ReportGeneratorService reportService = new ReportGeneratorServiceImpl(storage);
        TransactionProcessorService transactionService
                = new TransactionProcessorServiceImpl(operationStrategy);

        List<String> inputData = readerService.read(resourсePath);
        
        DataConverter dataConverter = new DataConverter();
        List<FruitTransaction> transactions = dataConverter.parseTransactions(inputData);
        transactionService.processTransactions(transactions);

        String report = reportService.generateReport();
        writerService.write(finalReportPath, report);
    }
}
