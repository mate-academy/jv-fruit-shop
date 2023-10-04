package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ProcessTransaction;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ProcessTransactionImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.transactions.BalanceHandlerImpl;
import core.basesyntax.service.impl.transactions.PurchaseHandlerImpl;
import core.basesyntax.service.impl.transactions.ReturnHandlerImpl;
import core.basesyntax.service.impl.transactions.SupplyHandlerImpl;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.TransactionStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        FileReader fileReader = new FileReaderImpl();
        List<String> list = fileReader.readFromFile(READ_PATH_TO_FILE);
        if (list.size() == 0) {
            throw new RuntimeException("The document is empty");
        }
        TransactionParser parse = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactionList = parse.getDataFromLine(list);
        ProcessTransaction processTransactions =
                new ProcessTransactionImpl(storageDao, transactionStrategy);
        processTransactions.addDataIntoStorage(fruitTransactionList);
        List<String> report = new ReportGeneratorImpl().generateReport(storageDao);
        new FileWriterImpl().writeIntoFile(report, WRITE_PATH_TO_FILE);
    }
}
