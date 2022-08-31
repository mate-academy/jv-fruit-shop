package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.TransactionHandle;
import core.basesyntax.operations.impl.BalanceTransactionHandleImpl;
import core.basesyntax.operations.impl.PurchaseTransactionHandleImpl;
import core.basesyntax.operations.impl.ReturnTransactionHandleImpl;
import core.basesyntax.operations.impl.SupplyTransactionHandleImpl;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReporterService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReporterServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FROM_FILE = "src/main/resources/productsInput.csv";
    private static final String WRITE_TO_FILE = "src/main/resources/productsReport.csv";
    private static FileReaderService readerService = new CsvReaderServiceImpl();
    private static WriterService writerService = new WriterServiceImpl();
    private static ReporterService reporterService = new ReporterServiceImpl();
    private static ParserService parseService = new ParserServiceImpl();
    private static StorageDao storage = new StorageDaoImpl();

    public static void main(String[] args) {
        List<String> data = readerService.readFromFile(READ_FROM_FILE);

        Map<FruitTransaction.Operation, TransactionHandle> operationHandler = new HashMap<>();
        operationHandler.put(FruitTransaction.Operation.BALANCE,
                new BalanceTransactionHandleImpl(storage));
        operationHandler.put(FruitTransaction.Operation.SUPPLY,
                new SupplyTransactionHandleImpl(storage));
        operationHandler.put(FruitTransaction.Operation.RETURN,
                new ReturnTransactionHandleImpl(storage));
        operationHandler.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseTransactionHandleImpl(storage));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandler);
        List<FruitTransaction> parsedData = parseService.parse(data);

        parsedData.forEach(value -> operationStrategy.getByOperation(value.getOperation())
                .executeTransaction(value));

        String report = reporterService.createReport(storage.getEntries());
        writerService.writeToFile(WRITE_TO_FILE, report);
    }

}
