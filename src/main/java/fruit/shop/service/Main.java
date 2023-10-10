package fruit.shop.service;

import fruit.shop.db.Storage;
import fruit.shop.model.Fruits;
import fruit.shop.service.impl.OperationStrategyImpl;
import fruit.shop.service.impl.ReaderImpl;
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
    private static final String FILE_NAME = "src/main/resources/fruitshop.csv";


    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        Parser parser = new ParserImpl();
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        operationHandlerMap.put("b", new BalanceOperation());
        operationHandlerMap.put("s", new SupplyOperation());
        operationHandlerMap.put("p", new PurchaseOperation());
        operationHandlerMap.put("r", new ReturnOperation());
        List<String> data = reader.readFromFile(FILE_NAME);
        for (Fruits.Operation operation : Fruits.Operation.values()) {
            List<String> data1 = parser.getOperationData(data, operation.getCode());
            operationStrategy.get(operation.getCode()).calculateOperation(data1);
        }
        Writer writer = new WriterImpl();
        writer.writeToFile(Storage.resultRemainder);
        System.out.println(Storage.resultRemainder);
    }
}
