import dto.Transaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.FileReaderImpl;
import service.FileWriter;
import service.FileWriterImpl;
import service.FruitParser;
import service.FruitReportService;
import service.FruitValidator;
import service.Parser;
import service.ReportService;
import service.Validator;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import strategy.SupplyOperationHandler;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put("b", new BalanceOperationHandler());
        handlerMap.put("s", new SupplyOperationHandler());
        handlerMap.put("p", new PurchaseOperationHandler());
        handlerMap.put("r", new SupplyOperationHandler());
        List<String> parsedLines = new FileReaderImpl()
                .readFromFile("src/main/resources/shop_operations.csv");
        parsedLines.remove(0);
        Validator fruitValidator = new FruitValidator();
        Parser fruitParser = new FruitParser(fruitValidator);
        for (String line : parsedLines) {
            Transaction transaction = fruitParser.parse(line);
            OperationHandler handler =
                    handlerMap.get(transaction.getOperation());
            handler.perform(transaction);
        }
        ReportService reportService = new FruitReportService();
        String report = reportService.getReport();
        FileWriter writeFile = new FileWriterImpl();
        writeFile.writeToFile("src/main/resources/report.csv", report);
    }
}
