import dao.FruitsDao;
import dao.FruitsDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Fruit;
import service.handler.AdditionHandler;
import service.handler.OperationHandler;
import service.handler.SubtractionHandler;
import service.read.FileReadService;
import service.read.FileReadServiceImpl;
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
        FileReadService fileReader = new FileReadServiceImpl();
        List<String> doneFileReading = fileReader.fileReader(INPUT_FILE_NAME);
        ValidatorProcess validatorProcess = new ValidatorProcess();
        validatorProcess.checkAllList(doneFileReading);

        Map<Fruit.TypeOperation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Fruit.TypeOperation.BALANCE, new AdditionHandler());
        operationHandlerMap.put(Fruit.TypeOperation.PURCHASE, new SubtractionHandler());
        operationHandlerMap.put(Fruit.TypeOperation.SUPPLY, new AdditionHandler());
        operationHandlerMap.put(Fruit.TypeOperation.RETURN, new AdditionHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitsDao fruitsDao = new FruitsDaoImpl();
        StoreService storeService = new StoreServiceImpl(operationStrategy, fruitsDao);
        storeService.addToMap(doneFileReading);
        String report = storeService.getReportFromStorage();
        FileWriteService writeService = new FileWriteServiceImpl();
        writeService.fileWriter(report, OUTPUT_FILE_NAME);
    }
}
