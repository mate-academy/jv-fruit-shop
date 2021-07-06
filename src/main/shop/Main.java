import dto.Transaction;
import service.FruitService;
import service.FileWriter;
import service.FileReader;
import service.Parser;
import service.FruitServiceImpl;
import service.FileWriterImpl;
import service.FileReaderImpl;
import service.ParserImpl;
import strategy.AddOperationHandler;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_START_FILE = "src/main/resources/test.csv";
    private static final String PATH_TO_RESULT_FILE = "src/main/resources/result.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put("b", new BalanceOperationHandler());
        handlers.put("s", new AddOperationHandler());
        handlers.put("p", new PurchaseOperationHandler());
        handlers.put("r", new AddOperationHandler());

        FileReader reader = new FileReaderImpl();
        List<String> readLines = reader.readFromFile(PATH_TO_START_FILE);
        Parser parser = new ParserImpl();
        for (int i = 1; i < readLines.size(); i++) {
            Transaction transactionHandler = parser.parseLine(readLines.get(i));
            OperationHandler handler = handlers.get(transactionHandler.getOperation());
            handler.apply(transactionHandler);
        }

        FruitService reportService = new FruitServiceImpl();
        String report = reportService.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(report, PATH_TO_RESULT_FILE);
    }
}
