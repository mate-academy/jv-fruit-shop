package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConversionService;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.ConversionServiceImpl;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());

        Storage storage = new StorageImpl();

        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        ConversionService conversionService = new ConversionServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReportService reportService = new ReportServiceImpl();
        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();

        List<FruitTransaction> fruitTransactions = conversionService
                .convert(csvFileReaderService
                        .readFromFile("src\\main\\resources\\products.csv"));

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationHandler operationHandler = operationStrategy.get(fruitTransaction.operation());
            operationHandler.process(fruitTransaction, storage);
        }

        String report = reportService.createReport(storage);
        csvFileWriterService.writeToFile(report);
    }
}
