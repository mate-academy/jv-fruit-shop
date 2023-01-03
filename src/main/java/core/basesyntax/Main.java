package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.CsvWriteServiceImpl;
import core.basesyntax.service.impl.FruitStorageCheckServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionsListServiceImpl;
import core.basesyntax.strategy.CountStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceServiceStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseServiceStrategyImpl;
import core.basesyntax.strategy.impl.ReturnServiceStrategyImpl;
import core.basesyntax.strategy.impl.SupplyServiceStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_FROM_FILE = "src/main/resources/file.csv";
    private static final String PATH_TO_FILE = "src/main/resources/report.csv";
    private static final ReaderServiceImpl readerService = new ReaderServiceImpl();
    private static final TransactionsListServiceImpl processService
            = new TransactionsListServiceImpl();
    private static final ReportServiceImpl reportService = new ReportServiceImpl();
    private static final CsvWriteServiceImpl writeService = new CsvWriteServiceImpl();
    private static final Storage storage = new Storage();
    private static final Map<FruitTransaction.Operation, CountStrategy> countStrategyMap
            = new HashMap<>();
    private static final OperationStrategy operationStrategy
            = new OperationStrategy(countStrategyMap);
    private static final FruitStorageCheckServiceImpl fruitStorageCheckService
            = new FruitStorageCheckServiceImpl(operationStrategy);
    private static Map<String, Integer> resultMap = new HashMap<>();

    static {
        countStrategyMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceServiceStrategyImpl());
        countStrategyMap.put(
                FruitTransaction.Operation.SUPPLY, new SupplyServiceStrategyImpl());
        countStrategyMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseServiceStrategyImpl());
        countStrategyMap.put(
                FruitTransaction.Operation.RETURN, new ReturnServiceStrategyImpl());
    }

    public static void main(String[] args) {
        String lines = readerService.readFromFile(PATH_FROM_FILE);
        List<FruitTransaction> transactionsList
                = processService.getTransactionsList(lines, storage.getFruitMap());
        resultMap = fruitStorageCheckService.checkStorage(transactionsList);
        String report = reportService.getReport(resultMap);
        writeService.writeReport(PATH_TO_FILE, report);
    }
}
