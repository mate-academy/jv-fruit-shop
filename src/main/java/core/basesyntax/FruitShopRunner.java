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
        execute();
    }

    private static void execute() {
        StorageDao storageDao = new StorageDaoImpl();
        Map<Operation, OperationHandler> strategyMap = Map.of(
                Operation.BALANCE, new BalanceOperationHandler(storageDao),
                Operation.PURCHASE, new PurchaseOperationHandler(storageDao),
                Operation.RETURN, new ReturnOperationHandler(storageDao),
                Operation.SUPPLY, new SupplyOperationHandler(storageDao)
        );
        FileReader fileReader = new CsvFileReader();
        FileDataParser fileDataParser = new CsvFileDataParser();
        FileWriter fileWriter = new CsvFileWriter();
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storageDao);
        OperationStrategy operationStrategy = new OperationStrategy(strategyMap);
        TransactionProcessor transactionProcessor = new TransactionProcessorImpl(operationStrategy);

        List<String> inputData = fileReader.readData(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactionList = fileDataParser.parseData(inputData);
        transactionProcessor.processTransactionList(fruitTransactionList);
        String report = reportGenerator.generateReport();
        fileWriter.writeData(OUTPUT_FILE_PATH, report);
    }
}
