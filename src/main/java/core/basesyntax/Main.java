package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ChangerDbAfterDayService;
import core.basesyntax.service.GetterFruitTransaction;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ChangerDbAfterDayServiceImpl;
import core.basesyntax.service.impl.GetterFruitTransactionImpl;
import core.basesyntax.service.impl.ReaderFromCsvService;
import core.basesyntax.service.impl.WriterToCsvService;
import core.basesyntax.service.impl.operation.service.BalanceService;
import core.basesyntax.service.impl.operation.service.PurchaserServices;
import core.basesyntax.service.impl.operation.service.ReturnerService;
import core.basesyntax.service.impl.operation.service.SupplierService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String OUT_PUT_FILE_NAME = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationService> operationServiceMap = new HashMap<>();
        operationServiceMap.put(FruitTransaction.Operation.BALANCE, new BalanceService());
        operationServiceMap.put(FruitTransaction.Operation.PURCHASE, new PurchaserServices());
        operationServiceMap.put(FruitTransaction.Operation.RETURN, new ReturnerService());
        operationServiceMap.put(FruitTransaction.Operation.SUPPLY, new SupplierService());
        ReaderService readerService = new ReaderFromCsvService();
        OperationStrategy operationStrategy = new OperationStrategy(operationServiceMap);
        GetterFruitTransaction getterFruitTransaction = new GetterFruitTransactionImpl();
        FruitsDao fruitsDao = new FruitDaoImpl();
        ChangerDbAfterDayService changerDbAfterDayService
                = new ChangerDbAfterDayServiceImpl(readerService, operationStrategy,
                getterFruitTransaction, fruitsDao);
        WriterService writerService = new WriterToCsvService(fruitsDao);
        changerDbAfterDayService.changeDb(INPUT_FILE_NAME);
        writerService.createReportAfterDay(OUT_PUT_FILE_NAME);
    }
}
