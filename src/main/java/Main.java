import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.HashMap;
import java.util.Map;
import model.Operation;
import service.UserService;
import service.impl.UserServiceImpl;
import strategy.OperationService;
import strategy.impl.BalanceOperationService;
import strategy.impl.PurchaseOperationService;
import strategy.impl.ReturnOperationService;
import strategy.impl.SupplyOperationService;

public class Main {
    private static final String fromFile = "src/main/resources/fruits.csv";
    private static final String toFile = "src/main/resources/report.csv";
    private static final Map<Operation, OperationService> operationServiceMap = new HashMap<>();
    private static final FruitDao fruitDao = new FruitDaoImpl();
    private static final UserService userService = new UserServiceImpl(fruitDao);

    public static void main(String[] args) {
        operationServiceMap.put(Operation.BALANCE, new BalanceOperationService(fruitDao));
        operationServiceMap.put(Operation.PURCHASE, new PurchaseOperationService(fruitDao));
        operationServiceMap.put(Operation.SUPPLY, new SupplyOperationService(fruitDao));
        operationServiceMap.put(Operation.RETURN, new ReturnOperationService(fruitDao));
        userService.formReport(operationServiceMap, fromFile, toFile);
    }
}
