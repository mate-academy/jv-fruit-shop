package app;

import app.service.FileReadService;
import app.service.FileWriterService;
import app.service.Operation;
import app.service.impl.FileReadServiceImplements;
import app.service.impl.FileWriterServiceImplements;
import app.service.impl.OperationBuy;
import app.service.impl.OperationReturn;
import app.service.impl.OperationSupply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApp {
    public static void main(String[] args) {
        getStart();
    }

    public static void fillMapOfOperators(Map<String, Operation> fruitOperations) {
        fruitOperations.put("s",new OperationSupply());
        fruitOperations.put("b", new OperationBuy());
        fruitOperations.put("r", new OperationReturn());
    }

    public static void getStart() {
        Map<String, Operation> fruitOperations = new HashMap<>();
        fillMapOfOperators(fruitOperations);
        FruitOperationStrategy fruitOperationStrategy = new FruitOperationStrategy(fruitOperations);
        FileReadService fileReadService = new FileReadServiceImplements();
        List<List<String>> allData = fileReadService.readFile("src\\test\\java\\resources\\testOpen.csv");
        for (List<String> line : allData) {
            Operation operation = fruitOperationStrategy.getOperation(line);
            operation.doOperation(line);
        }
        FileWriterService fileWriterServiceImplements = new FileWriterServiceImplements();
        fileWriterServiceImplements.writeData(FruitStorage.fruits);
    }
}
