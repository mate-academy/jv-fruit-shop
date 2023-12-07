package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/output.csv";
    private static final Map<FruitTransaction.Operation, OperationHandler>
            operationHandlers = new HashMap<>();
    private static final FruitStorageDao FRUIT_STORAGE_DAO = new FruitStorageDaoImpl();

    public static void main(String[] args) {
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(FRUIT_STORAGE_DAO));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(FRUIT_STORAGE_DAO));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(FRUIT_STORAGE_DAO));
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(FRUIT_STORAGE_DAO));

        FileService fileService = new FileServiceImpl();
        List<String> lines = fileService.readFile(INPUT_PATH);

        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactions = transactionParser.parse(lines);

        TransactionService transactionService = new TransactionServiceImpl(operationHandlers);
        transactionService.executeTransactions(fruitTransactions);

        ReportGenerator reportService = new ReportGeneratorImpl(FRUIT_STORAGE_DAO);
        String report = reportService.generateReport();

        fileService.writeFile(OUTPUT_PATH, report);
    }
}
