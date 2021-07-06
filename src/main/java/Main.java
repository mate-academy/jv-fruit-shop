import dto.Transaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.TheFileReader;
import service.TheFileReaderImpl;
import service.TheFileWriter;
import service.TheFileWriterImpl;
import service.TheFruitReport;
import service.TheFruitReportImpl;
import service.TheParser;
import service.TheParserImpl;
import strategy.AppendOperations;
import strategy.BalanceOperations;
import strategy.OperationVariables;
import strategy.PurchaseOperations;

public class Main {
    public static void main(String[] args) {

        Map<String, OperationVariables> operationsMap = new HashMap<>();
        operationsMap.put("r", new AppendOperations());
        operationsMap.put("s", new AppendOperations());
        operationsMap.put("b", new BalanceOperations());
        operationsMap.put("p", new PurchaseOperations());

        TheFileReader reader = new TheFileReaderImpl();
        List<String> linesFromReader = reader.readFromFile("Data.csv");
        TheParser parser = new TheParserImpl();
        for (int i = 1; i < linesFromReader.size(); i++) {
            Transaction transaction = parser.parseLine(linesFromReader.get(i));
            OperationVariables handler = operationsMap.get(transaction.getOperation());
            handler.apply(transaction);
        }
        TheFruitReport reportService = new TheFruitReportImpl();
        String report = reportService.returnReport();

        TheFileWriter writer = new TheFileWriterImpl();
        writer.writeToFile(report, "ResultData.csv");
    }
}
