import dao.WokWithStorageImpl;
import dao.WorkWithStorageDB;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.convert.ConvertData;
import service.convert.ConvertDataImpl;
import service.filework.AddDataToFile;
import service.filework.AddDataToFileImpl;
import service.filework.GetDataFromFile;
import service.filework.GetDataFromFileImpl;
import strategy.HandlersStore;
import strategy.StrategyImplementation;
import strategy.StrategyImplementationImpl;
import strategy.handler.BalancesHandlerImpl;
import strategy.handler.Handler;
import strategy.handler.PurchaseHandlerImpl;
import strategy.handler.ReturnHandlerImpl;
import strategy.handler.SupplyHandlerImpl;

public class FruitMain {
    private static final String PATH_TO_DATA = "src/main/resources/fileFuringDay.csv";
    private static final String PATH_TO_REPORT = "src/main/resources/fileReport.csv";

    public static void main(String[] args) {
        GetDataFromFile getDataService = new GetDataFromFileImpl();
        List<String> data = getDataService.getFromStorage(PATH_TO_DATA);
        ConvertData convertData = new ConvertDataImpl();
        List<FruitTransaction> dataConvert = convertData.convert(data);
        StrategyImplementation implementStrategy =
                new StrategyImplementationImpl(new HandlersStore(addPatternHandler()));
        implementStrategy.strategy(dataConvert);
        WorkWithStorageDB storageService = new WokWithStorageImpl();
        AddDataToFile addDataService = new AddDataToFileImpl();
        addDataService.addInStorage(storageService.getAllFromStorage(),PATH_TO_REPORT);
    }

    public static Map<FruitTransaction.Operation, Handler> addPatternHandler() {
        Map<FruitTransaction.Operation,Handler> temporaryMap = new HashMap<>();
        temporaryMap.put(FruitTransaction.Operation.BALANCE,new BalancesHandlerImpl());
        temporaryMap.put(FruitTransaction.Operation.PURCHASE,new PurchaseHandlerImpl());
        temporaryMap.put(FruitTransaction.Operation.SUPPLY,new SupplyHandlerImpl());
        temporaryMap.put(FruitTransaction.Operation.RETURN,new ReturnHandlerImpl());
        return temporaryMap;
    }
}

