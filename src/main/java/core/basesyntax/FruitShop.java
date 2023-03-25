package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ParserTransactionsService;
import core.basesyntax.service.ProcessTransactionService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.impl.GenerateGenerateReportServiceImpl;
import core.basesyntax.service.impl.ParserTransactionsServiceImpl;
import core.basesyntax.service.impl.ProcessTransactionServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.RecordingServiceImpl;
import core.basesyntax.service.impl.transactions.BalanceHandlerImpl;
import core.basesyntax.service.impl.transactions.PurchaseHandlerImpl;
import core.basesyntax.service.impl.transactions.ReturnHandlerImpl;
import core.basesyntax.service.impl.transactions.SupplyHandlerImpl;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.TransactionStrategyImpl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FruitShop {
    private static final String READ_PATH_TO_FILE = "src/main/resources/inputdata.csv";
    private static final String WRITE_PATH_TO_FILE = "src/main/resources/database.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerServiceMap
                = new HashMap<>();
        operationHandlerServiceMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceHandlerImpl());
        operationHandlerServiceMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseHandlerImpl());
        operationHandlerServiceMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyHandlerImpl());
        operationHandlerServiceMap.put(FruitTransaction.Operation.RETURN,
                new ReturnHandlerImpl());

        TransactionStrategy transactionStrategy =
                new TransactionStrategyImpl(operationHandlerServiceMap);
        StorageDao storageDao = new StorageDaoImpl();
        ReaderService readerService = new ReaderServiceImpl();
        List<String> list = readerService.readFromFile(READ_PATH_TO_FILE);
        if (list.size() == 0) {
            throw new RuntimeException("The document is empty");
        }
        ParserTransactionsService parse = new ParserTransactionsServiceImpl();
        ProcessTransactionService processTransactions = new ProcessTransactionServiceImpl();
        Set<Fruit> listFruits = new HashSet<>();
        for (String line : list) {
            FruitTransaction fruitTransaction = parse.getDataFromLine(line);
            listFruits.add(processTransactions
                    .addDataIntoStorage(fruitTransaction, storageDao, transactionStrategy));
        }
        List<String> report = new GenerateGenerateReportServiceImpl()
                .getResult(listFruits, storageDao);
        new RecordingServiceImpl().writeIntoFile(report, WRITE_PATH_TO_FILE);
    }
}
