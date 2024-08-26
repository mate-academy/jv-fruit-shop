package core.basesyntax;

import core.basesyntax.dao.CsvStorageDaoImpl;
import core.basesyntax.dao.StorageDao;
import core.basesyntax.handler.BalanceOperationHandler;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.PurchaseOperationHandler;
import core.basesyntax.handler.ReturnOperationHandler;
import core.basesyntax.handler.SupplyOperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.report.CsvReportWriterImpl;
import core.basesyntax.report.ReportBuilder;
import core.basesyntax.report.ReportBuilderImpl;
import core.basesyntax.report.ReportWriter;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.storage.FruitStorage;
import core.basesyntax.storage.FruitStorageImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StorageDao storageDao = new CsvStorageDaoImpl();
        String filePath = "src/main/java/core/basesyntax/file.csv";

        FruitStorage fruitStorage = new FruitStorageImpl();

        OperationHandler balanceHandler = new BalanceOperationHandler(fruitStorage);
        OperationHandler supplyHandler = new SupplyOperationHandler(fruitStorage);
        OperationHandler returnHandler = new ReturnOperationHandler(fruitStorage);
        OperationHandler purchaseHandler = new PurchaseOperationHandler(fruitStorage);

        //Creating Map with Transactions operations as KEY and Handlers as VALUE
        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, balanceHandler);
        handlers.put(FruitTransaction.Operation.SUPPLY, supplyHandler);
        handlers.put(FruitTransaction.Operation.PURCHASE, purchaseHandler);
        handlers.put(FruitTransaction.Operation.RETURN, returnHandler);

        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);

        List<FruitTransaction> transactions = storageDao.readTransactions(filePath);
        ShopService shopService = new ShopServiceImpl(operationStrategy, fruitStorage);
        shopService.processTransactions(transactions);

        ReportBuilder reportBuilder = new ReportBuilderImpl();
        String reportData = reportBuilder.buildReport(fruitStorage);

        String reportPath = "src/main/java/core/basesyntax/report.csv";
        ReportWriter reportWriter = new CsvReportWriterImpl();
        reportWriter.writeReport(reportData, reportPath);
    }
}
