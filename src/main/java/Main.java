import static db.Storage.fruitsQuantity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitOperation;
import service.FruitOperationValidator;
import service.MapperImpl;
import service.ReadServiceImpl;
import service.WriterServiceImpl;
import service.handler.BalanceHandler;
import service.handler.PurchaseHandler;
import service.handler.ReturnHandler;
import service.handler.SupplyHandler;
import service.inter.Mapper;
import service.inter.Operation;
import service.inter.ReadService;
import service.inter.Validator;
import service.inter.WriteService;

public class Main {
    public static void main(String[] args) {
        ReadService readService = new ReadServiceImpl();
        List<String> dataFromFile = readService.readFromFile("src/main/resources/input.csv");

        List<FruitOperation> fruitOperations = new ArrayList<>();
        Mapper<String, FruitOperation> mapper = new MapperImpl();
        Validator<String> validator = new FruitOperationValidator();
        for (String data: dataFromFile) {
            validator.validate(data);
            fruitOperations.add(mapper.map(data));
        }

        Map<String, Operation> operationsHandlers = new HashMap<>();
        operationsHandlers.put("b", new BalanceHandler());
        operationsHandlers.put("p", new PurchaseHandler());
        operationsHandlers.put("r", new ReturnHandler());
        operationsHandlers.put("s", new SupplyHandler());

        fruitOperations.forEach(fruitOperation -> {
            Operation operation = operationsHandlers.get(fruitOperation.getType());
            operation.apply(fruitOperation);
        });

        WriteService writeService = new WriterServiceImpl();
        writeService.writeToFile("src/main/resources/output.csv", fruitsQuantity);
    }
}
