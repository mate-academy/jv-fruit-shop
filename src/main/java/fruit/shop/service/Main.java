package fruit.shop.service;

import fruit.shop.db.Storage;
import fruit.shop.model.Operation;
import fruit.shop.service.impl.OperationStrategyImpl;
import fruit.shop.service.impl.ParserImpl;
import fruit.shop.service.impl.ReaderImpl;
import fruit.shop.service.impl.ReportCreatorImpl;
import fruit.shop.service.impl.WriterImpl;
import fruit.shop.strategy.BalanceOperation;
import fruit.shop.strategy.OperationHandler;
import fruit.shop.strategy.OperationStrategy;
import fruit.shop.strategy.PurchaseOperation;
import fruit.shop.strategy.ReturnOperation;
import fruit.shop.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_NAME_READ = "src/main/resources/fruitshop.csv";
    private static final String FILE_NAME_WRITE = "src/main/resources/balance.csv";
    private static final Reader reader = new ReaderImpl();
    private static final Parser parser = new ParserImpl();
    private static final Writer writer = new WriterImpl();
    private static final ReportCreator creator = new ReportCreatorImpl();

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        operationHandlerMap.put("b", new BalanceOperation());
        operationHandlerMap.put("s", new SupplyOperation());
        operationHandlerMap.put("p", new PurchaseOperation());
        operationHandlerMap.put("r", new ReturnOperation());
        List<String> dataFromFile = reader.readFromFile(FILE_NAME_READ);
        for (Operation operation : Operation.values()) {
            List<String> dataType = parser.getOperationData(dataFromFile, operation.getCode());
            operationStrategy.get(operation.getCode()).calculateOperation(dataType);
        }
        String stringResult = creator.createString(Storage.resultDB);
        writer.writeToFile(FILE_NAME_WRITE, stringResult);
    }
}
