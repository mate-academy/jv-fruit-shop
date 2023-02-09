package core.basesyntax;

import core.basesyntax.dao.WarehouseDao;
import core.basesyntax.dao.WarehouseDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportCreate;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportCreateImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
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
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

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
        FileReader readCsv = new FileReaderImpl();
        List<String> csvStrings = readCsv.read(INPUT_FILE_NAME);
        TransactionParser transactionParser = new TransactionParserImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationStrategyMap);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.processTransactions(transactionParser.getTransactions(csvStrings));
        ReportCreate report = new ReportCreateImpl();
        FileWriter fileWriter = new FileWriterImpl();
        WarehouseDao warehouseDao = new WarehouseDaoImpl();
        fileWriter.write(report.getReport(warehouseDao.getWarehouse()), REPORT_FILE_NAME);
    }
}
