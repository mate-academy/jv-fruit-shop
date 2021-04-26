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
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WarehouseService;
import core.basesyntax.service.WarehouseServiceImpl;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.OperationsStrategy;
import core.basesyntax.strategy.OperationsStrategyImpl;
import java.util.HashMap;
import java.util.List;
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
        WarehouseService warehouseService = new WarehouseServiceImpl(operationsStrategy,
                productDao);

        ReaderService readerService = new CsvReaderServiceImpl();
        List<String> data = readerService.readFromFile(FILE_PATH_FROM);
        warehouseService.addToStorage(data);
        String report = warehouseService.getReportFromStorage();
        WriterService writerService = new CsvWriterServiceImpl();
        writerService.writeToFile(report, FILE_PATH_TO);
    }
}
