import db.FruitStorage;
import model.Fruit;
import model.FruitTransactionDto;
import model.Operation;
import service.FruitShopService;
import service.Implementation.CsvDataReaderImpl;
import service.Implementation.CsvDataWriterImpl;
import service.Implementation.FruitShopServiceImpl;
import strategy.AdditionStrategy;
import strategy.OperationStrategy;
import strategy.ReductionStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());


        CsvDataReaderImpl reader = new CsvDataReaderImpl();
        List<FruitTransactionDto> fruitTransactions = reader
                .readFromFile("input_fruits.csv");
        FruitShopService service = new FruitShopServiceImpl(operationStrategyMap);
        service.applyOperationsOnFruitsDto(fruitTransactions);

        CsvDataWriterImpl writer = new CsvDataWriterImpl();
        writer.writeToFile("output_fruits.csv");

        for (Map.Entry<Fruit, Integer> entry : FruitStorage.fruitStorage.entrySet() ) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue());
        }
    }
}
