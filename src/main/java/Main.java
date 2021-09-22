import dao.FruitsDao;
import dao.FruitsDaoImpl;
import exception.ValidationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Fruit;
import service.operation.AddOperation;
import service.operation.Calculator;
import service.operation.SubtractionOperation;
import service.read.FileReader;
import service.read.FileReaderImpl;
import service.storage.StoreService;
import service.storage.StoreServiceImpl;
import service.validator.DataValidator;
import service.validator.DataValidatorImpl;
import service.write.FileWriter;
import service.write.FileWriterImpl;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> fruitRecords = fileReader.read(INPUT_FILE_NAME);
        DataValidator<String> dataValidator = new DataValidatorImpl();
        for (String temp : fruitRecords) {
            try {
                dataValidator.validate(temp);
            } catch (ValidationException e) {
                throw new RuntimeException("Data is not valid" + temp, e);
            }
        }

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
        FileWriter writeService = new FileWriterImpl();
        writeService.write(report, OUTPUT_FILE_NAME);
    }
}
