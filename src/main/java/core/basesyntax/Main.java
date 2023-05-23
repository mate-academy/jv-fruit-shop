package core.basesyntax;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.operations.BalanceOperation;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.Operations;
import core.basesyntax.operations.PurchaseOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.SupplyOperation;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.ReadServiceFromCsvImpl;
import core.basesyntax.service.StoreService;
import core.basesyntax.service.StoreServiceImpl;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.WriteServiceToCscImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH_FROM = "src\\main\\java\\core\\basesyntax\\file.csv";
    private static final String FILE_PATH_TO = "src\\main\\java\\core\\basesyntax\\report.csv";

    public static void main(String[] args) {
        Map<Operations, Operation> operationMap = new HashMap<>();
        operationMap.put(Operations.B, new BalanceOperation());
        operationMap.put(Operations.S, new SupplyOperation());
        operationMap.put(Operations.R, new ReturnOperation());
        operationMap.put(Operations.P, new PurchaseOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        ProductDao productDao = new ProductDaoImpl();
        StoreService storeService = new StoreServiceImpl(operationStrategy, productDao);

        ReadService readService = new ReadServiceFromCsvImpl();
        List<String> data = readService.readFile(FILE_PATH_FROM);
        storeService.addToStorage(data);
        String report = storeService.getTheReportFromTheStorage();
        WriteService writeService = new WriteServiceToCscImpl();
        writeService.writeToFile(report, FILE_PATH_TO);
    }
}
