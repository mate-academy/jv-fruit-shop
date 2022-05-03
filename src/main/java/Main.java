import dao.FruitsDao;
import dao.FruitsDaoImpl;
import java.util.List;
import java.util.stream.Collectors;
import model.Fruit;
import service.BalanceOperationHandlerImpl;
import service.PurchaseOperationHandlerImpl;
import service.ReadService;
import service.ReturnOperationHandlerImpl;
import service.SupplyOperationHandlerImpl;
import service.Validate;
import service.ValidateImpl;
import service.WriteService;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    public static final String PATH_FROM = "src/main/java/FileFrom.csv";
    public static final String PATH_WHERE = "src/main/java/FileWhere.csv";
    public static final int INDEX_AFTER_FIRST_ROW = 1;

    public static void main(String[] args) {
        ReadService readService = new ReadService();
        Validate validator = new ValidateImpl();
        OperationStrategy strategy = new OperationStrategyImpl();
        List<String> listOfProducts = readService.readFile(PATH_FROM);
        validator.validate(listOfProducts);
        FruitsDao fruitsDao = new FruitsDaoImpl();
        strategy.addOperation("b", new BalanceOperationHandlerImpl(fruitsDao));
        strategy.addOperation("s", new SupplyOperationHandlerImpl(fruitsDao));
        strategy.addOperation("p", new PurchaseOperationHandlerImpl(fruitsDao));
        strategy.addOperation("r", new ReturnOperationHandlerImpl(fruitsDao));
        List<String[]> splitedListOfProducts = listOfProducts.stream()
                .map(s -> s.split(","))
                .collect(Collectors.toList());
        for (int i = INDEX_AFTER_FIRST_ROW; i < listOfProducts.size(); i++) {
            String s = splitedListOfProducts.get(i)[0];
            strategy.operationCheck(s, new Fruit(splitedListOfProducts.get(i)[1]),
                    splitedListOfProducts.get(i)[2]);
        }
        WriteService writeService = new WriteService();
        writeService.writeInFile(PATH_WHERE);
    }
}
