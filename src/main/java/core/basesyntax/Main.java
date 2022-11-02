package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.handlers.TransactionHandler;
import core.basesyntax.handlers.impl.RemoveTransactionHandler;
import core.basesyntax.handlers.impl.SaveTransactionHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.parser.TextLineParser;
import core.basesyntax.parser.impl.CsvTextLineParser;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.impl.TransactionStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FRUITS_CSV_FILEPATH = "src/main/resources/fruits.csv";
    private static final String REPORT_CSV_FILEPATH = "src/main/resources/report.csv";
    private static final int HEADER_INDEX = 0;

    public static void main(String[] args) {
        List<String> fileContents = new ReaderServiceImpl().readFromFile(FRUITS_CSV_FILEPATH);
        TextLineParser lineParser = new CsvTextLineParser();
        FruitStorage storage = new FruitStorage();
        Map<FruitTransaction.Operation, TransactionHandler> strategyMap = initStrategyMap(storage);
        TransactionStrategy strategy = new TransactionStrategyImpl(strategyMap);

        fileContents.remove(HEADER_INDEX);
        for (String line : fileContents) {
            FruitTransaction transaction = lineParser.extractTransaction(line);
            if (transaction != null) {
                TransactionHandler transactionHandler = strategy.get(transaction.getOperation());
                transactionHandler.process(transaction);
            }
        }

        List<String> reportList = new ReportServiceImpl().generateReport(storage);
        new WriterServiceImpl().writeToFile(reportList, REPORT_CSV_FILEPATH);
    }

    private static Map<FruitTransaction.Operation,
            TransactionHandler> initStrategyMap(FruitStorage storage) {
        Map<FruitTransaction.Operation, TransactionHandler> strategyMap = new HashMap<>();

        StorageDao storageDao = new StorageDaoImpl(storage);
        TransactionHandler saveHandler = new SaveTransactionHandler(storageDao);
        TransactionHandler removeHandler = new RemoveTransactionHandler(storageDao);

        strategyMap.put(FruitTransaction.Operation.BALANCE, saveHandler);
        strategyMap.put(FruitTransaction.Operation.RETURN, saveHandler);
        strategyMap.put(FruitTransaction.Operation.PURCHASE, removeHandler);
        strategyMap.put(FruitTransaction.Operation.SUPPLY, saveHandler);
        return strategyMap;
    }
}
