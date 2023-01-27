package core.basesyntax;

import core.basesyntax.dao.CsvFileReader;
import core.basesyntax.dao.CsvFileReaderImpl;
import core.basesyntax.dao.FileWriteService;
import core.basesyntax.dao.FileWriteServiceImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.FruitTransactionServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String fromFileName = "src/main/resources/fromFile.csv";
    private static final String toFileName = "src/main/resources/toFile.csv";
    private static final File toFile = new File(toFileName);
    private static final CsvFileReader fruitsDao = new CsvFileReaderImpl();
    private static final ReportService reportService = new ReportServiceImpl();
    private static final FileWriteService FILE_WRITE_SERVICE = new FileWriteServiceImpl();

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());

        List<FruitTransaction> fruitTransactions = fruitsDao.readTransactions(fromFileName);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        FruitTransactionService transactionService =
                new FruitTransactionServiceImpl(operationStrategy);
        transactionService.processTransactions(fruitTransactions);

        String reportData = reportService.generateReport(Storage.fruitsMap);

        FILE_WRITE_SERVICE.writeToFile(reportData, toFile);
    }
}
