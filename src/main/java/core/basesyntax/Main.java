package core.basesyntax;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.impl.FruitTransactionDaoIml;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReadScvService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteScvService;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.FruitTransferImpl;
import core.basesyntax.service.impl.ReadScvServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteScvServiceIml;
import core.basesyntax.service.operation.BalanceOperation;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperation;
import core.basesyntax.service.operation.ReturnOperation;
import core.basesyntax.service.operation.SupplyOperation;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImp;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static FruitTransactionDao fruitTransactionDao;
    private static ReadScvService readScvService;
    private static FruitTransactionService fruitTransactionService;
    private static OperationStrategy operationStrategy;
    private static FruitTransferImpl fruitTransfer;
    private static ReportService reportService;
    private static String report;
    private static WriteScvService writeScvService;
    private static String fileReportName = "report.csv";

    public static void main(String[] args) {
        fruitTransactionDao = new FruitTransactionDaoIml();
        readScvService = new ReadScvServiceImpl();
        fruitTransactionService = new FruitTransactionServiceImpl(fruitTransactionDao);
        Map<FruitTransaction.Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperation(fruitTransactionDao, fruitTransactionService));
        operationMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperation(fruitTransactionDao));
        operationMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperation(fruitTransactionDao));
        operationMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperation(fruitTransactionDao));
        operationStrategy = new OperationStrategyImp(operationMap);
        fruitTransfer = new FruitTransferImpl(operationStrategy, readScvService);
        fruitTransfer.transfer();
        reportService = new ReportServiceImpl();
        report = reportService.createReport(fruitTransactionDao.getAllListDb());
        writeScvService = new WriteScvServiceIml();
        writeScvService.writeDataScvFile(report, fileReportName);
    }
}
