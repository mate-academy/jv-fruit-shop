package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.impl.FileReaderSvcImpl;
import core.basesyntax.service.impl.FileWriterSvcImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportGeneratorSvcImpl;
import core.basesyntax.service.impl.TransactionParserSvcImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";
    private final static StorageDao storageDao = new StorageDaoImpl();

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy strategyMap = new OperationStrategyImpl(operationHandlerMap);

        List<String> data = new FileReaderSvcImpl(Path.of(INPUT_FILE_PATH)).readFile();
        List<FruitTransaction> transactionsList = new TransactionParserSvcImpl().parse(data);
        new TransactionServiceImpl(strategyMap, storageDao).applyTransactions(transactionsList);
        new FileWriterSvcImpl(Path.of(OUTPUT_FILE_PATH))
                .writeToFile(new ReportGeneratorSvcImpl(storageDao).generateReport());
        ;
    }
}
