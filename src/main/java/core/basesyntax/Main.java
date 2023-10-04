package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.WorkerWithTransactions;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.service.impl.CsvFileWriterService;
import core.basesyntax.service.impl.FruitTransactionParserServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.impl.WorkerWithFruitsTransactions;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final Path pathFromFile = FileSystems.getDefault()
                .getPath("src/main/resources/data.csv");
        final Path pathToFile = FileSystems.getDefault()
                .getPath("src/main/resources/processedData.csv");
        Map<Operation, OperationHandler> operation = Map.of(
                Operation.BALANCE, new BalanceOperationHandler(),
                Operation.RETURN, new ReturnOperationHandler(),
                Operation.PURCHASE, new PurchaseOperationHandler(),
                Operation.SUPPLY, new SupplyOperationHandler());
        FileReaderService csvFileReader = new CsvFileReaderService();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operation);
        FileWriterService csvFileWriter = new CsvFileWriterService();
        TransactionParserService transactionParserService = new FruitTransactionParserServiceImpl();
        WorkerWithTransactions workerWithTransactions
                = new WorkerWithFruitsTransactions(operationStrategy);
        ReportGeneratorService reportGenerator = new ReportGeneratorServiceImpl();

        String dataFromFile = csvFileReader.readDataFromFile(pathFromFile.toString());
        List<FruitTransaction> transactionList = transactionParserService
                .getListOfTransactions(dataFromFile);
        for (FruitTransaction transaction : transactionList) {
            workerWithTransactions.completeTransaction(transaction);
        }
        String report = reportGenerator.generateReport();
        csvFileWriter.writeDataToFile(report, pathToFile.toString());
    }
}
