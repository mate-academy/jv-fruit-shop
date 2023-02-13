package core.basesyntax;

import core.basesyntax.dao.WarehouseDao;
import core.basesyntax.dao.WarehouseDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
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
        WarehouseDao warehouseDao = new WarehouseDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(warehouseDao));
        operationStrategyMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(warehouseDao));
        operationStrategyMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(warehouseDao));
        operationStrategyMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(warehouseDao));
        FileReader readCsv = new FileReaderImpl();
        List<String> csvStrings = readCsv.read(INPUT_FILE_NAME);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationStrategyMap);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> transactions = transactionParser.getTransactions(csvStrings);
        shopService.processTransactions(transactions);
        ReportCreator reportCreator = new ReportCreatorImpl(warehouseDao);
        String report = reportCreator.getReport(warehouseDao.getLeftovers());
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, REPORT_FILE_NAME);
    }
}
