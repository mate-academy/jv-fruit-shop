package core.basesyntax;

import core.basesyntax.dao.FruitOperationDao;
import core.basesyntax.dao.FruitOperationDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.processTransactionService.FruitTransactionService;
import core.basesyntax.processTransactionService.FruitTransactionServiceImpl;
import core.basesyntax.processTransactionService.ReportListFruitService;
import core.basesyntax.processTransactionService.ReportListFruitServiceImpl;
import core.basesyntax.readFileService.ReaderService;
import core.basesyntax.readFileService.ReaderServiceImpl;
import core.basesyntax.serviceImpl.*;
import core.basesyntax.serviceOperate.OperationHandlerService;
import core.basesyntax.serviceOperate.OperationStrategy;
import core.basesyntax.writeToFileService.WriteService;
import core.basesyntax.writeToFileService.WriteServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";
    private static final Storage FRUIT_STOCK = new Storage();
    private static final FruitOperationDao FRUIT_STOCK_DAO = new FruitOperationDaoImpl(FRUIT_STOCK);

    public static void main(String[] args) {
        Map<Operation, OperationHandlerService> operationHandlerServiceMap = new HashMap<>();
        operationHandlerServiceMap.put(Operation.BALANCE, new BalanceOperationServiceImpl(FRUIT_STOCK_DAO));
        operationHandlerServiceMap.put(Operation.RETURN, new ReturnOperationServiceImpl(FRUIT_STOCK_DAO));
        operationHandlerServiceMap.put(Operation.SUPPLY, new SupplyOperationServiceImpl(FRUIT_STOCK_DAO));
        operationHandlerServiceMap.put(Operation.PURCHASE, new PurchaseOperationServiceImpl(FRUIT_STOCK_DAO));

        ReaderService readerService = new ReaderServiceImpl();
        List<FruitTransaction> transactionList = readerService.readFile(INPUT_FILE);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerServiceMap);
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl(operationStrategy);
        fruitTransactionService.processTransaction(transactionList);

        ReportListFruitService reportListFruitService = new ReportListFruitServiceImpl(FRUIT_STOCK);
        String output = reportListFruitService.createReport();

        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(output, OUTPUT_FILE);
    }
}
