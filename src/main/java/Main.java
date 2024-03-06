import strategy.FruitStrategy;
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
    private static Map<Operation, OperationService> operationServiceMap = new HashMap<>();
    private static FruitDao fruitDao = new FruitDaoImpl();
    private static FruitStrategy fruitStrategy = new FruitStrategy(operationServiceMap);

    public static void main(String[] args) {
        operationServiceMap.put(Operation.RETURN, new ReturnOperationService(fruitDao));
        operationServiceMap.put(Operation.SUPPLY, new SupplyOperationService(fruitDao));
        operationServiceMap.put(Operation.PURCHASE, new PurchaseOperationService(fruitDao));
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl(fruitDao);
        List<String> data = readerService.readFromFile("src/main/resources/fruits.csv");
        System.out.println(data);
        List<FruitTransaction> list = parserService.parse(data);
        for (FruitTransaction fruitTransaction : list) {
            fruitStrategy.executeOperationServiceByOperation(fruitTransaction.getOperation(),
                    fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
        }
        System.out.println(fruitDao.get("apple"));
        System.out.println(fruitDao.get("banana"));

    }
}
