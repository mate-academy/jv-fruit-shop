package core.basesyntax;

import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.reporter.CsvReportGenerator;
import core.basesyntax.reporter.ReportGenerator;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.TransactionPerformer;
import core.basesyntax.service.TransactionPerformerImpl;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.FruitMapper;
import core.basesyntax.service.impl.Mapper;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handlers.BalanceOperationHandler;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.PurchaseOperationHandler;
import core.basesyntax.strategy.handlers.ReturnOperationHandler;
import core.basesyntax.strategy.handlers.SupplierOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReaderService fileReader = new CsvFileReader();
        FileWriterService fileWriter = new CsvFileWriter();
        Mapper mapper = new FruitMapper();
        StorageDao storageDao = new FruitStorageDaoImpl();
        ReportGenerator reportGenerator = new CsvReportGenerator();

        OperationHandler balanceOperationHandler = new BalanceOperationHandler(storageDao);
        OperationHandler supplierOperationHandler = new SupplierOperationHandler(storageDao);
        OperationHandler purchaseOperationHandler = new PurchaseOperationHandler(storageDao);
        OperationHandler returnOperationHandler = new ReturnOperationHandler(storageDao);

        OperationStrategy operationStrategy = new OperationStrategyImpl(Map.of(
                FruitTransaction.Operation.BALANCE, balanceOperationHandler,
                FruitTransaction.Operation.SUPPLY, supplierOperationHandler,
                FruitTransaction.Operation.PURCHASE, purchaseOperationHandler,
                FruitTransaction.Operation.RETURN, returnOperationHandler
        ));

        List<String> allLines = fileReader.read("src/main/resources/input_file.csv");
        List<FruitTransaction> transactions = mapper.mapLinesIntoTransaction(allLines);
        TransactionPerformer transactionPerformer = new TransactionPerformerImpl(operationStrategy);
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy.getHandler(transaction);
            operationHandler.handle(transaction);
        }
        String report = reportGenerator.createReport(storageDao);
        fileWriter.write(report, "output_file.csv");
    }
}
