package core.basesyntax;

import static core.basesyntax.model.Operation.BALANCE;
import static core.basesyntax.model.Operation.PURCHASE;
import static core.basesyntax.model.Operation.RETURN;
import static core.basesyntax.model.Operation.SUPPLY;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.ReadDataParser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.CsvDataParser;
import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvReportGenerator;
import core.basesyntax.service.impl.CsvReportWriter;
import core.basesyntax.service.impl.OperationProcessorImpl;
import core.basesyntax.strategy.HandlerStrategy;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.handlers.BalanceHandler;
import core.basesyntax.strategy.handlers.PurchaseHandler;
import core.basesyntax.strategy.handlers.ReturnHandler;
import core.basesyntax.strategy.handlers.SupplyHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/Input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/Output.csv";

    public static void main(String[] args) {
        final StorageDao storageDao = new StorageDaoImpl();
        HandlerStrategy strategy = new HandlerStrategy();
        Map<Operation, OperationHandler> strategyMap = strategy.getStrategyMap();
        strategyMap.put(BALANCE, new BalanceHandler(storageDao));
        strategyMap.put(PURCHASE, new PurchaseHandler(storageDao));
        strategyMap.put(RETURN, new ReturnHandler(storageDao));
        strategyMap.put(SUPPLY, new SupplyHandler(storageDao));

        DataReader dataReader = new CsvReader();
        List<String> readData = dataReader.read(INPUT_FILE);

        ReadDataParser parser = new CsvDataParser();
        List<FruitTransaction> transactionList = parser.parseToTransactionList(readData);

        TransactionProcessor transactionProcessor = new OperationProcessorImpl();
        transactionProcessor.processTransactionList(transactionList, strategy);

        ReportGenerator reportGenerator = new CsvReportGenerator();
        String report = reportGenerator.generateReport(storageDao.getStorageState());

        DataWriter writer = new CsvReportWriter();
        writer.writeReportToTheFile(report, OUTPUT_FILE);
    }
}
