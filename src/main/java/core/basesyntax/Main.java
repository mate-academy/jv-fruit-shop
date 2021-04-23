package core.basesyntax;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.operations.BalanceOperation;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.Operations;
import core.basesyntax.operations.PurchaseOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.SupplyOperation;
import core.basesyntax.service.CsvReaderServiceImpl;
import core.basesyntax.service.CsvWriterServiceImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.OperationsStrategy;
import core.basesyntax.strategy.OperationsStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String FILE_PATH_FROM = "src/main/resources/file.csv";
    private static final String FILE_PATH_TO = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operations, Operation> operationMap = new HashMap<>();
        operationMap.put(Operations.B, new BalanceOperation());
        operationMap.put(Operations.S, new SupplyOperation());
        operationMap.put(Operations.P, new PurchaseOperation());
        operationMap.put(Operations.R, new ReturnOperation());

        OperationsStrategy operationsStrategy = new OperationsStrategyImpl(operationMap);
        ProductDao productDao = new ProductDaoImpl();
        ReaderService readerService = new CsvReaderServiceImpl();
        WriterService writerService = new CsvWriterServiceImpl();

        FruitShopService fruitShopService = new FruitShopServiceImpl(productDao,
                operationsStrategy, readerService, writerService);
        fruitShopService.createReport(FILE_PATH_FROM, FILE_PATH_TO);
    }
}
