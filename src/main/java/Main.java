import java.util.List;
import java.util.stream.Collectors;
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

    public static void main(String[] args) {
        ReadService readService = new ReadService();
        Validate validator = new ValidateImpl();
        OperationStrategy strategy = new OperationStrategyImpl();
        List<String> listOfProducts = readService.readFile(PATH_FROM);
        validator.validate(listOfProducts);
        strategy.addOperation("b", new BalanceOperationHandlerImpl());
        strategy.addOperation("s", new SupplyOperationHandlerImpl());
        strategy.addOperation("p", new PurchaseOperationHandlerImpl());
        strategy.addOperation("r", new ReturnOperationHandlerImpl());
        List<String[]> splitedListOfProducts = listOfProducts.stream()
                .map(s -> s.split(","))
                .collect(Collectors.toList());
        for (int i = 1; i < listOfProducts.size(); i++) {
            String s = splitedListOfProducts.get(i)[0];
            strategy.operationCheck(s, splitedListOfProducts.get(i)[1],
                    splitedListOfProducts.get(i)[2]);
        }
        WriteService writeService = new WriteService();
        writeService.writeInFile(PATH_WHERE);
    }
}
