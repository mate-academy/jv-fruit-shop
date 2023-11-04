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
import core.basesyntax.strategy.handlers.PurchaseOperationHandler;
import core.basesyntax.strategy.handlers.ReturnOperationHandler;
import core.basesyntax.strategy.handlers.SupplierOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input_file.csv";
    private static final String OUTPUT_FILE_PATH = "output_file.csv";

    public static void main(String[] args) {
        FileReaderService fileReader = new CsvFileReader();
        FileWriterService fileWriter = new CsvFileWriter();
        Mapper mapper = new FruitMapper();
        StorageDao storageDao = new FruitStorageDaoImpl();
        ReportGenerator reportGenerator = new CsvReportGenerator();

        OperationStrategy operationStrategy = new OperationStrategyImpl(Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(storageDao),
                FruitTransaction.Operation.SUPPLY, new SupplierOperationHandler(storageDao),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(storageDao),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler(storageDao)
        ));

        List<String> allLines = fileReader.read(INPUT_FILE_PATH);
        List<FruitTransaction> transactions = mapper.mapLinesIntoTransaction(allLines);
        TransactionPerformer transactionPerformer = new TransactionPerformerImpl(operationStrategy);
        transactionPerformer.performTransactions(transactions);
        String report = reportGenerator.createReport(storageDao);
        fileWriter.write(report, OUTPUT_FILE_PATH);
    }
}
