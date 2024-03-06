import service.UserService;
import service.WriterService;
import service.impl.UserServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.impl.FruitStrategy;
import strategy.OperationService;
import strategy.impl.PurchaseOperationService;
import strategy.impl.ReturnOperationService;
import strategy.impl.SupplyOperationService;
import dao.FruitDao;
import dao.FruitDaoImpl;
import model.FruitTransaction;
import model.Operation;
import service.ParserService;
import service.ReaderService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.impl.ParserServiceImpl;
import service.impl.ReaderServiceImpl;

public class Main {
    private static final String fromFile = "src/main/resources/fruits.csv";
    private static final String toFile = "src/main/resources/report.csv";
    private static final Map<Operation, OperationService> operationServiceMap = new HashMap<>();
    private static final FruitDao fruitDao = new FruitDaoImpl();
    private static final UserService userService = new UserServiceImpl(fruitDao);

    public static void main(String[] args) {
        operationServiceMap.put(Operation.RETURN, new ReturnOperationService(fruitDao));
        operationServiceMap.put(Operation.SUPPLY, new SupplyOperationService(fruitDao));
        operationServiceMap.put(Operation.PURCHASE, new PurchaseOperationService(fruitDao));
        userService.formReport(operationServiceMap, fromFile, toFile);

    }
}
