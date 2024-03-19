package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileDataParser;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.CsvFileDataParser;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationStrategy;
import core.basesyntax.strategy.impl.PurchaseOperationStrategy;
import core.basesyntax.strategy.impl.ReturnOperationStrategy;
import core.basesyntax.strategy.impl.SupplyOperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitShopRunner {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.csv";
        String outputFilePath = "src/main/resources/output.csv";
        runner(inputFilePath, outputFilePath);
    }

    private static void runner(String inputFilePath, String outputFilePath) {
        StorageDao storageDao = new StorageDaoImpl();
        OperationHandler operationHandler = new OperationHandler();
        Map<FruitTransaction.Operation, OperationStrategy> strategyMap =
                operationHandler.getStrategyMap();
        strategyMap.put(
                FruitTransaction.Operation.BALANCE,
                new BalanceOperationStrategy(storageDao)
        );
        strategyMap.put(
                FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationStrategy(storageDao)
        );
        strategyMap.put(
                FruitTransaction.Operation.RETURN,
                new ReturnOperationStrategy(storageDao)
        );
        strategyMap.put(
                FruitTransaction.Operation.SUPPLY,
                new SupplyOperationStrategy(storageDao)
        );

        FileReader fileReader = new CsvFileReader();
        List<String> inputData = fileReader.readData(inputFilePath);

        FileDataParser fileDataParser = new CsvFileDataParser();
        List<FruitTransaction> fruitTransactionList = fileDataParser.parseData(inputData);

        TransactionProcessor transactionProcessor = new TransactionProcessorImpl();
        transactionProcessor.processTransactionList(fruitTransactionList, operationHandler);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.generateReport(storageDao.getStorage());

        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.writeData(outputFilePath, report);
    }
}
