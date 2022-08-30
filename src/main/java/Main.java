import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.TransactionParserService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParserServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import core.basesyntax.strategy.handler.BalanceHandlerImpl;
import core.basesyntax.strategy.handler.PurchaseHandlerImpl;
import core.basesyntax.strategy.handler.ReturnHandlerImpl;
import core.basesyntax.strategy.handler.SupplyHandlerImpl;
import core.basesyntax.strategy.handler.TransactionHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_DATA_FILE = "src/main/resources/input_data.csv";
    private static final String OUTPUT_DATA_FILE = "src/main/resources/output_data.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();

        Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap = new HashMap<>();
        transactionHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceHandlerImpl(storageDao));
        transactionHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseHandlerImpl(storageDao));
        transactionHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyHandlerImpl(storageDao));
        transactionHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnHandlerImpl(storageDao));

        FileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        TransactionParserService transactionParserService
                = new FruitTransactionParserServiceImpl();

        List<String> dataFromFile = csvFileReaderService.readFile(INPUT_DATA_FILE);
        List<FruitTransaction> fruitTransactions
                = transactionParserService.parseDataFromList(dataFromFile);

        Strategy strategy
                = new StrategyImpl(transactionHandlerMap);

        for (FruitTransaction transaction : fruitTransactions) {
            strategy.get(transaction.getOperation()).makeTransaction(transaction);
        }

        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl(storageDao);
        String dayReport = reportCreatorService.createReport();

        FileWriterService fileWriterService = new CsvFileWriterServiceImpl();
        fileWriterService.writeToFile(OUTPUT_DATA_FILE, dayReport);
    }
}
