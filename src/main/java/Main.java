import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.HashMap;
import java.util.Map;
import model.Operation;
import service.ParserService;
import service.ReaderService;
import service.UserService;
import service.WriterService;
import service.impl.ParserServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.UserServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.OperationService;
import strategy.impl.BalanceOperationService;
import strategy.impl.PurchaseOperationService;
import strategy.impl.ReturnOperationService;
import strategy.impl.SupplyOperationService;

public class Main {
    private static final String fromFile = "src/main/resources/fruits.csv";
    private static final String toFile = "src/main/resources/report.csv";
    private static final Map<Operation, OperationService> operationMap = new HashMap<>();

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        operationMap.put(Operation.BALANCE, new BalanceOperationService(fruitDao));
        operationMap.put(Operation.PURCHASE, new PurchaseOperationService(fruitDao));
        operationMap.put(Operation.SUPPLY, new SupplyOperationService(fruitDao));
        operationMap.put(Operation.RETURN, new ReturnOperationService(fruitDao));
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        UserService userService = new UserServiceImpl(fruitDao,
                readerService,
                parserService,
                writerService);
        userService.formReport(operationMap, fromFile, toFile);
    }
}
