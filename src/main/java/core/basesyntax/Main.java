package core.basesyntax;

import core.basesyntax.dao.TransactionsDao;
import core.basesyntax.dao.TransactionsDaoCsvImpl;
import core.basesyntax.dao.WarehouseDao;
import core.basesyntax.dao.WarehouseDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReport;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ParseCsv;
import core.basesyntax.service.ReadCsv;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.WriteReport;
import core.basesyntax.service.impl.CreateReportImpl;
import core.basesyntax.service.impl.ParseCsvImpl;
import core.basesyntax.service.impl.ReadCsvImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.WriteReportImpl;
import core.basesyntax.service.impl.operation.BalanceOperationHandler;
import core.basesyntax.service.impl.operation.PurchaseOperationHandler;
import core.basesyntax.service.impl.operation.ReturnOperationHandler;
import core.basesyntax.service.impl.operation.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationStrategyMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationStrategyMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationStrategyMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        ReadCsv readCsv = new ReadCsvImpl();
        List<String> csvStrings = readCsv.readCsvFile();
        ParseCsv parseCsv = new ParseCsvImpl();
        parseCsv.getTransactions(csvStrings);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationStrategyMap);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        TransactionsDao transactionsDaoCsv = new TransactionsDaoCsvImpl();
        shopService.processTransactions(transactionsDaoCsv.getTransactions());
        CreateReport report = new CreateReportImpl();
        WriteReport writeReport = new WriteReportImpl();
        WarehouseDao warehouseDao = new WarehouseDaoImpl();
        writeReport.writeCsv(report.getReport(warehouseDao.getWarehouse()));
    }
}
