import dao.FruitDao;
import dao.FruitDaoImpl;
import database.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Fruit;
import service.ConvertData;
import service.FruitService;
import service.OperationStrategy;
import service.ReadFromFile;
import service.WriteToFile;
import service.impl.ConvertDataImpl;
import service.impl.FruitServiceImpl;
import service.impl.OperationStrategyImpl;
import service.impl.ReadFromFileImpl;
import service.impl.WriteToFileImpl;
import service.operation.BalanceOperation;
import service.operation.OperationHandler;
import service.operation.PurchaseOperation;
import service.operation.ReturnOperation;
import service.operation.SupplyOperation;

public class Main {
    public static void main(String[] args) {
        ReadFromFile readFromFile = new ReadFromFileImpl();
        ConvertData convertData = new ConvertDataImpl();
        FruitService fruitService = new FruitServiceImpl();
        FruitDao fruitDao = new FruitDaoImpl(fruitService);

        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperation(fruitDao));
        operationHandlerMap.put("s", new SupplyOperation(fruitDao));
        operationHandlerMap.put("p", new PurchaseOperation(fruitDao));
        operationHandlerMap.put("r", new ReturnOperation(fruitDao));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        WriteToFile writeToFile = new WriteToFileImpl();

        List<String> inputInfo = readFromFile.fileInfo();
        List<Fruit> fruitList = convertData.fruitList(inputInfo);
        for (Fruit fruit : fruitList) {
            operationStrategy.update(fruit).operate(fruit);
        }
        writeToFile.writeReport(Storage.fruits);
    }
}

