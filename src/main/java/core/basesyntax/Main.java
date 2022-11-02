package core.basesyntax;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.impl.FruitShopDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvReportGeneratorImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.impl.BalanceOperationHandler;
import core.basesyntax.service.operations.impl.PurchaseOperationHandler;
import core.basesyntax.service.operations.impl.SupplyOprationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOprationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new SupplyOprationHandler());
        //
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        CsvFileReader csvFileReader = new CsvFileReaderImpl();
        List<FruitTransaction> fruitTransactions = csvFileReader
                .readFile(Path.of("src/main/resources/data.csv"));
        fruitShopService.transaction(fruitTransactions);
        //generate report
        FruitShopDao fruitStorage = new FruitShopDaoImpl();
        ReportGenerator reportGenerator = new CsvReportGeneratorImpl();
        reportGenerator.generateCsvReport(fruitStorage.getAll());
    }
}
