import db.FruitStorage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Fruit;
import model.FruitTransactionDto;
import model.Operation;
import service.DataReader;
import service.FruitShopService;
import service.implementation.CsvDataReaderImpl;
import service.implementation.CsvDataWriterImpl;
import service.implementation.FruitShopServiceImpl;
import strategy.OperationStrategy;
import strategy.implementation.AdditionStrategy;
import strategy.implementation.ReductionStrategy;

public class Application {
    public static final String FILE_PATH = "src/main/resources/";

    public static void main(String[] args) {

        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());

        DataReader reader = new CsvDataReaderImpl();
        List<FruitTransactionDto> fruitTransactions = reader
                .readFromFile(FILE_PATH + "valid_input.csv");
        FruitShopService service = new FruitShopServiceImpl(operationStrategyMap);
        service.applyOperationsOnFruitsDto(fruitTransactions);

        Map<Fruit, Integer> fruitReport = service.getFruitReport();
        CsvDataWriterImpl writer = new CsvDataWriterImpl();
        writer.writeToFile(fruitReport, FILE_PATH + "incorrect_output.csv");

        for (Map.Entry<Fruit, Integer> entry : FruitStorage.fruitStorage.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue());
        }
        FruitStorage.fruitStorage.clear();
    }
}
