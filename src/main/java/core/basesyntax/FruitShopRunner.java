package core.basesyntax;

import static core.basesyntax.model.FruitTransaction.Operation;

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
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class FruitShopRunner {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        runApplication();
    }

    private static void runApplication() {
        StorageDao storageDao = new StorageDaoImpl();

        Map<Operation, OperationHandler> strategyMap = Map.of(
                Operation.BALANCE, new BalanceOperationHandler(storageDao),
                Operation.PURCHASE, new PurchaseOperationHandler(storageDao),
                Operation.RETURN, new ReturnOperationHandler(storageDao),
                Operation.SUPPLY, new SupplyOperationHandler(storageDao)
        );
        OperationStrategy operationStrategy = new OperationStrategy(strategyMap);

        FileReader fileReader = new CsvFileReader();
        List<String> inputData = fileReader.readData(INPUT_FILE_PATH);

        FileDataParser fileDataParser = new CsvFileDataParser();
        List<FruitTransaction> fruitTransactionList = fileDataParser.parseData(inputData);

        TransactionProcessor transactionProcessor = new TransactionProcessorImpl(operationStrategy);
        transactionProcessor.processTransactionList(fruitTransactionList);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storageDao);
        String report = reportGenerator.generateReport();

        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.writeData(OUTPUT_FILE_PATH, report);
    }
}
