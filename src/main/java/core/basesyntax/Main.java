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
    public static void main(String[] args) {
        FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoIml();
        ReadScvService readScvService = new ReadScvServiceImpl();
        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(fruitTransactionDao);
        Map<FruitTransaction.Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperation(fruitTransactionDao, fruitTransactionService));
        operationMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperation(fruitTransactionDao));
        operationMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperation(fruitTransactionDao));
        operationMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperation(fruitTransactionDao));
        OperationStrategy operationStrategy = new OperationStrategyImp(operationMap);
        FruitTransferImpl fruitTransfer = new FruitTransferImpl(operationStrategy, readScvService);
        fruitTransfer.transfer();
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(fruitTransactionDao.getAllListDb());
        WriteScvService writeScvService = new WriteScvServiceIml();
        writeScvService.writeDataScvFile(report,"report.csv");
    }
}
