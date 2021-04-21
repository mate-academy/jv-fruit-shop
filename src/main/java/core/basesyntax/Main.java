package core.basesyntax;

import core.basesyntax.operations.BalanceOperation;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.Operations;
import core.basesyntax.operations.PurchaseOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.SupplyOperation;
import core.basesyntax.service.ProductService;
import core.basesyntax.service.ProductServiceImpl;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.WriterServiceImpl;
import core.basesyntax.strategy.OperationsStrategy;
import core.basesyntax.strategy.OperationsStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Operations, Operation> operationMap = new HashMap<>();
        operationMap.put(Operations.B, new BalanceOperation());
        operationMap.put(Operations.S, new SupplyOperation());
        operationMap.put(Operations.P, new PurchaseOperation());
        operationMap.put(Operations.R, new ReturnOperation());

        OperationsStrategy strategy = new OperationsStrategyImpl(operationMap);

        ReaderService readerService = new ReaderServiceImpl();
        List<String> data = readerService.readFromFile("src/main/resources/file.csv");

        ProductService productService = new ProductServiceImpl(strategy);
        productService.addToStorage(data);
        List<String> report = productService.getFromStorage();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, "src/main/resources/report.csv");
    }
}
