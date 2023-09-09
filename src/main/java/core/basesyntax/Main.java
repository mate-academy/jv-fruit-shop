package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.impl.OperationStrategyImpl;
import core.basesyntax.impl.ParserReaderImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.impl.ShopServiceImpl;
import core.basesyntax.impl.StorageDaoImpl;
import core.basesyntax.impl.WriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandler;
import core.basesyntax.service.operation.ReturnHandler;
import core.basesyntax.service.operation.SupplyHandler;
import core.basesyntax.service.util.ParserReader;
import core.basesyntax.service.util.ReaderService;
import core.basesyntax.service.util.Writer;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Read data from file
        ReaderService fileDao = new ReaderServiceImpl();
        String fileFrom = "src/main/resources/fileFrom.csv";
        List<String> listFromFile = fileDao.readFromFileToList(fileFrom);
        // Convert data to Java object
        ParserReader parser = new ParserReaderImpl();
        final List<FruitTransaction> fruitTransactions = parser
                .parsedToFruitTransaction(listFromFile);
        // Data operation Strategy
        StorageDao storageDao = new StorageDaoImpl();
        HashMap<FruitTransaction.Operation, OperationHandler> operationHashMap = new HashMap<>();
        operationHashMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(storageDao));
        operationHashMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(storageDao));
        operationHashMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler(storageDao));
        operationHashMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(storageDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHashMap);
        // Data processing
        ShopServiceImpl shopService = new ShopServiceImpl(operationStrategy);
        shopService.processTransactions(fruitTransactions);
        //Create report
        ReportService reportService = new ReportServiceImpl(storageDao);
        List<String> report = reportService.getReport();
        // Write report to file
        String fileTo = "src/main/resources/fileTo.csv";
        Writer writeFile = new WriterImpl();
        writeFile.writeToFile(report, fileTo);
    }
}
