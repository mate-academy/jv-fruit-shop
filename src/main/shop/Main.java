import service.*;
import strategy.AddOperationHandler;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String pathToStartFile = "src/main/shop/resources/test.csv";
    private static final String pathToResultFile = "src/main/shop/resources/result.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put("b", new BalanceOperationHandler());
        handlers.put("s", new AddOperationHandler());
        handlers.put("p", new PurchaseOperationHandler());
        handlers.put("r", new AddOperationHandler());

        ShopFileReader shopFileReader = new ShopFileReaderImpl();
        List<String> fileReader = shopFileReader.readFromFile(pathToStartFile);
        Parser parser = new ParserImpl();
        for (String line : fileReader) {
            OperationHandler handler = handlers.get(parser.parseLine(line).getOperation());
            handler.apply(parser.parseLine(line));
        }

        FruitService reportService = new FruitServiceImpl();
        String report = reportService.getReport();

        ShopFileWriter shopFileWriter = new ShopFileWriterImpl();
        shopFileWriter.writeToFile(report, pathToResultFile);
    }
}
