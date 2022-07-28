package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DailyReportMaker;
import core.basesyntax.service.DailyReportWriter;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.Reader;
import core.basesyntax.service.impl.BalanceOperationHandler;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.DailyReportMakerImpl;
import core.basesyntax.service.impl.DailyReportWriterImpl;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.PurchaseOperationHandler;
import core.basesyntax.service.impl.ReturnOperationHandler;
import core.basesyntax.service.impl.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FROM_FILE = "src/main/resources/database.csv";
    private static final String TO_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(storageDao));

        Reader databaseReader = new CsvFileReader();
        List<String[]> fileInfo = databaseReader.read(FROM_FILE);

        DataParser dataParser = new DataParserImpl();
        List<FruitTransaction> fruitTransactions = dataParser.parseFruitTransactions(fileInfo);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitTransactionService fruitTransactionService
                = new FruitTransactionServiceImpl(operationStrategy);
        fruitTransactionService.process(fruitTransactions);

        DailyReportMaker reportMaker = new DailyReportMakerImpl(storageDao);
        String report = reportMaker.makeReport();

        DailyReportWriter writer = new DailyReportWriterImpl();
        writer.write(report, TO_FILE);
    }
}
