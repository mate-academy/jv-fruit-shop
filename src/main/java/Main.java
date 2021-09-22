import dao.FruitsDao;
import dao.FruitsDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Fruit;
import service.operation.AddOperation;
import service.operation.Calculator;
import service.operation.SubtractionOperation;
import service.read.FileReadImpl;
import service.read.FileReader;
import service.storage.StoreService;
import service.storage.StoreServiceImpl;
import service.validator.ValidatorProcess;
import service.write.FileWriteService;
import service.write.FileWriteServiceImpl;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReadImpl();
        List<String> fruitRecords = fileReader.read(INPUT_FILE_NAME);
        ValidatorProcess validatorProcess = new ValidatorProcess();
        validatorProcess.checkAllList(fruitRecords);

        Map<Fruit.OperationType, Calculator> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Fruit.OperationType.BALANCE, new AddOperation());
        operationHandlerMap.put(Fruit.OperationType.PURCHASE, new SubtractionOperation());
        operationHandlerMap.put(Fruit.OperationType.SUPPLY, new AddOperation());
        operationHandlerMap.put(Fruit.OperationType.RETURN, new AddOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitsDao fruitsDao = new FruitsDaoImpl();
        StoreService storeService = new StoreServiceImpl(operationStrategy, fruitsDao);
        storeService.applyToDb(fruitRecords);
        String report = storeService.getDbReport();
        FileWriteService writeService = new FileWriteServiceImpl();
        writeService.fileWriter(report, OUTPUT_FILE_NAME);
    }
}
