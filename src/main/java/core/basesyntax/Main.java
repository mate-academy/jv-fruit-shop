package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.FruitStorageDao;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.handlers.TransactionHandler;
import core.basesyntax.handlers.impl.BalanceTransactionHandler;
import core.basesyntax.handlers.impl.PurchaseTransactionHandler;
import core.basesyntax.handlers.impl.ReturnTransactionHandler;
import core.basesyntax.handlers.impl.SupplyTransactionHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.impl.TransactionStrategyImpl;
import core.basesyntax.utils.ListUtil;
import core.basesyntax.utils.ReportUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FRUITS_CSV_FILEPATH = "src/main/resources/fruits.csv";
    private static final String REPORT_CSV_FILEPATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        final FruitStorage storage = new FruitStorage();
        final List<String> fileContent = new ReaderServiceImpl().readFromFile(FRUITS_CSV_FILEPATH);
        final TransactionStrategy strategy = new TransactionStrategyImpl(initStrategyMap(storage));

        new ListUtil().processList(fileContent, strategy);
        List<String> reportList = new ReportUtil().generateReport(storage);
        new WriterServiceImpl().writeToFile(reportList, REPORT_CSV_FILEPATH);
    }

    private static Map<FruitTransaction.Operation,
            TransactionHandler> initStrategyMap(FruitStorage storage) {
        Map<FruitTransaction.Operation, TransactionHandler> strategyMap = new HashMap<>();
        StorageDao storageDao = new FruitStorageDao(storage);

        TransactionHandler supplyHandler = new SupplyTransactionHandler(storageDao);
        TransactionHandler purchaseHandler = new PurchaseTransactionHandler(storageDao);
        TransactionHandler balanceHandler = new BalanceTransactionHandler(storageDao);
        TransactionHandler returnHandler = new ReturnTransactionHandler(storageDao);

        strategyMap.put(FruitTransaction.Operation.BALANCE, balanceHandler);
        strategyMap.put(FruitTransaction.Operation.RETURN, returnHandler);
        strategyMap.put(FruitTransaction.Operation.PURCHASE, purchaseHandler);
        strategyMap.put(FruitTransaction.Operation.SUPPLY, supplyHandler);
        return strategyMap;
    }
}
