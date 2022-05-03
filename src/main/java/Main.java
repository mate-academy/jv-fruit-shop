import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.OperationHandlerStrategy;
import service.OperationService;
import service.ParseService;
import service.ReadFileService;
import service.ReportService;
import service.impl.OperationHandlerStrategyImpl;
import service.impl.OperationServiceImpl;
import service.impl.ParseServiceImpl;
import service.impl.ReadFileServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriteFileServiceImpl;
import service.strategy.BalanceOperationHandler;
import service.strategy.OperationHandler;
import service.strategy.PurchaseOperationHandler;
import service.strategy.ReturnOperationHandler;
import service.strategy.SupplyOperationHandler;

public class Main {
    private static final String FROM_FILE = "src/main/resources/input.csv";
    private static final String TO_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReadFileService readService = new ReadFileServiceImpl();
        List<String> readFile = readService.read(FROM_FILE);
        ParseService parseService = new ParseServiceImpl();
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> map = new HashMap<>();
        map.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(storageDao));
        map.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(storageDao));
        map.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(storageDao));
        map.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler(storageDao));
        OperationHandlerStrategy operationHandlerStrategy = new OperationHandlerStrategyImpl(map);
        OperationService operationService = new OperationServiceImpl(operationHandlerStrategy);
        List<FruitTransaction> infoFromFile = parseService.getInfo(readFile);
        operationService.calculate(infoFromFile);
        ReportService reportService = new ReportServiceImpl(storageDao);
        String reportedInformation = reportService.createReport();
        new WriteFileServiceImpl().write(reportedInformation, TO_FILE);
    }
}
