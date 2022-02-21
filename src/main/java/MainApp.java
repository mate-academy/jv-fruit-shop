import dao.FileHandler;
import dao.impl.FileHandlerImpl;
import db.Storage;
import java.util.List;
import java.util.Map;
import model.FruitRecord;
import services.FruitDaoService;
import services.ParseService;
import services.impl.FruitDaoServiceImp;
import services.impl.ParseServiceImpl;
import services.strategy.OperationsHandler;
import services.strategy.OperatorHandlerStrategy;
import services.strategy.handlers.BalanceOperationHandler;
import services.strategy.handlers.PurchaseOperationHandler;
import services.strategy.handlers.ReturnOperationHandler;
import services.strategy.handlers.SupplyOperationHandler;

public class MainApp {
    private static final String destFile = "src/main/java/resources/storage.csv";
    private static final String sourceFile = "src/main/java/resources/data.csv";

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandlerImpl();
        String dataFromFile = fileHandler.readData(sourceFile);
        OperatorHandlerStrategy operator = new OperatorHandlerStrategy();
        operatorInitialization(operator);
        ParseService parseService = new ParseServiceImpl();
        List<FruitRecord> fruitRecords = parseService.parseFromCsv(dataFromFile);
        FruitDaoService fruitDaoService = new FruitDaoServiceImp(new Storage());
        operator.doAllOperation(fruitRecords, fruitDaoService);
        String dataToWrite = parseService.parseToString(fruitDaoService.get());
        fileHandler.writeData(dataToWrite, destFile);

    }

    private static OperatorHandlerStrategy operatorInitialization(
            OperatorHandlerStrategy operator) {
        Map<Character, OperationsHandler> typesOfOperations = operator.getTypesOfOperations();
        typesOfOperations.put('b', new BalanceOperationHandler());
        typesOfOperations.put('p', new PurchaseOperationHandler());
        typesOfOperations.put('r', new ReturnOperationHandler());
        typesOfOperations.put('s', new SupplyOperationHandler());
        return operator;
    }
}
