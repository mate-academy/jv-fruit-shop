import dto.Transaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.FileReader;
import service.FileReaderImpl;
import service.FileWriter;
import service.FileWriterImpl;
import service.FruitReportService;
import service.FruitReportServiceImpl;
import service.Parser;
import service.ParserImpl;
import strategy.AppendOperationHandler;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> operationsMap = new HashMap<>();
        operationsMap.put("r", new AppendOperationHandler());
        operationsMap.put("s", new AppendOperationHandler());
        operationsMap.put("b", new BalanceOperationHandler());
        operationsMap.put("p", new PurchaseOperationHandler());

        FileReader reader = new FileReaderImpl();
        List<String> linesFromReader = reader.readFromFile("src/main/resources/Data.csv");
        Parser parser = new ParserImpl();
        for (int i = 1; i < linesFromReader.size(); i++) {
            Transaction transaction = parser.parseLine(linesFromReader.get(i));
            OperationHandler handler = operationsMap.get(transaction.getOperation());
            handler.apply(transaction);
        }
        FruitReportService reportService = new FruitReportServiceImpl();
        String report = reportService.returnReport();

        FileWriter writer = new FileWriterImpl();
        writer.writeToFile(report, "src/main/resources/ResultData.csv");
    }
}
