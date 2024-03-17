package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.ReadDataParser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.CsvDataParser;
import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvReportGenerator;
import core.basesyntax.service.impl.CsvReportWriter;
import core.basesyntax.service.impl.OperationProcessorImpl;
import core.basesyntax.strategy.HandlerStrategy;
import core.basesyntax.strategy.handlers.BalanceHandler;
import core.basesyntax.strategy.handlers.PurchaseHandler;
import core.basesyntax.strategy.handlers.ReturnHandler;
import core.basesyntax.strategy.handlers.SupplyHandler;
import java.util.List;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/Input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/Output.csv";

    public static void main(String[] args) {
        final StorageDao storageDao = new StorageDaoImpl();
        HandlerStrategy handlerStrategy = new HandlerStrategy();
        var strategyMap =handlerStrategy.getStrategyMap();
        strategyMap.put(Operation.BALANCE, new BalanceHandler(storageDao));
        strategyMap.put(Operation.PURCHASE, new PurchaseHandler(storageDao));
        strategyMap.put(Operation.RETURN, new ReturnHandler(storageDao));
        strategyMap.put(Operation.SUPPLY, new SupplyHandler(storageDao));

        DataReader dataReader = new CsvReader();
        List<String> readData = dataReader.read(INPUT_FILE);

        ReadDataParser parser = new CsvDataParser();
        List<FruitTransaction> transactionList = parser.parseToTransactionList(readData);

        TransactionProcessor transactionProcessor = new OperationProcessorImpl();
        for (FruitTransaction transaction : transactionList) {
            transactionProcessor.processTransaction(transaction, handlerStrategy);
        }

        ReportGenerator reportGenerator = new CsvReportGenerator();
        String report = reportGenerator.generateReport(storageDao.getStorageState());

        DataWriter writer = new CsvReportWriter();
        writer.writeReportToTheFile(report, OUTPUT_FILE);
    }
}
