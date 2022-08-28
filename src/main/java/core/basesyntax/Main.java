package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.impl.OperationBalanceImpl;
import core.basesyntax.operations.impl.OperationPurchaseImpl;
import core.basesyntax.operations.impl.OperationReturnImpl;
import core.basesyntax.operations.impl.OperationSupplyImpl;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FROM_FILE_PATH = "src/main/resources/productsInput.csv";
    private static final String WRITE_TO_FILE_PATH = "src/main/resources/productsReport.csv";
    private static final StorageDao storage = new StorageDaoImpl();
    private static final ReaderService readerService = new ReaderServiceImpl();
    private static final WriterService writerService = new WriteServiceImpl();
    private static final ParseService PARSE_SERVICE = new ParseServiceImpl();
    private static final ReportService reportService = new ReportServiceImpl();

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, Operation> operationHandler = new HashMap<>();
        operationHandler.put(FruitTransaction.Operation.BALANCE,
                new OperationBalanceImpl(storage));
        operationHandler.put(FruitTransaction.Operation.PURCHASE,
                new OperationPurchaseImpl(storage));
        operationHandler.put(FruitTransaction.Operation.RETURN,
                new OperationReturnImpl(storage));
        operationHandler.put(FruitTransaction.Operation.SUPPLY,
                new OperationSupplyImpl(storage));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandler);

        List<String> products = readerService.readFromFile(READ_FROM_FILE_PATH);
        List<FruitTransaction> parsedDate = PARSE_SERVICE.parse(products);

        for (FruitTransaction data : parsedDate) {
            operationStrategy.get(data.getOperation())
                    .executeOperation(data);
            System.out.println(storage.getData());
        }

        String report = reportService.createReport(storage.getData());
        writerService.writeToFile(WRITE_TO_FILE_PATH, report);
    }
}
