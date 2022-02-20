import dao.FileHandler;
import dao.impl.FileHandlerImpl;
import db.Storage;
import model.FruitRecord;
import model.Operator;
import services.FruitDaoService;
import services.OperationsHandler;
import services.ParseCSVService;
import services.handlers.BalanceOperationHandler;
import services.handlers.PurchaseOperationHandler;
import services.handlers.ReturnOperationHandler;
import services.handlers.SupplyOperationHandler;
import services.impl.FruitDaoServiceImp;
import services.impl.ParseCSVServiceImpl;

import java.util.List;
import java.util.Map;

public class MainApp {
    private static final String destFile = "src/main/java/resources/storage.csv";
    private static final String sourceFile = "src/main/java/resources/data.csv";

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandlerImpl();
        String dataFromFile = fileHandler.readData(sourceFile);
        Operator operator = new Operator();
        operatorInitialization(operator);
        ParseCSVService parseCSVService = new ParseCSVServiceImpl();
        List<FruitRecord> fruitRecords = parseCSVService.parseFromCsv(dataFromFile);
        FruitDaoService fruitDaoService = new FruitDaoServiceImp(new Storage());
        operator.doAllOperation(fruitRecords, fruitDaoService);
        String dataToWrite = parseCSVService.parseIntoCsv(fruitDaoService.get());
        fileHandler.writeData(dataToWrite, destFile);

    }

    private static Operator operatorInitialization(Operator operator) {
        Map<Character, OperationsHandler> typesOfOperations = operator.getTypesOfOperations();
        typesOfOperations.put('b', new BalanceOperationHandler());
        typesOfOperations.put('p', new PurchaseOperationHandler());
        typesOfOperations.put('r', new ReturnOperationHandler());
        typesOfOperations.put('s', new SupplyOperationHandler());
        return operator;
    }
}
