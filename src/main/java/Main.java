import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Operation;
import model.Transaction;
import service.FileService;
import service.FileServiceImpl;
import service.Parser;
import service.ParserCsvLineService;
import service.ReportService;
import service.ReportToCsvService;
import service.strategy.AddOperationHandler;
import service.strategy.BalanceOperationHandler;
import service.strategy.OperationHandler;
import service.strategy.SubtractOperationHandler;
import service.strategy.TransactionStrategy;
import service.strategy.TransactionStrategyImpl;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> handlersMap = new HashMap<>();
        handlersMap.put(Operation.BALANCE, new BalanceOperationHandler());
        handlersMap.put(Operation.SUPPLY, new AddOperationHandler());
        handlersMap.put(Operation.RETURN, new AddOperationHandler());
        handlersMap.put(Operation.PURCHASE, new SubtractOperationHandler());

        FileService reader = new FileServiceImpl();
        List<String> recordsFromFile = reader.read(INPUT_FILE_NAME);

        List<Transaction> transactions = new ArrayList<>();
        Parser parser = new ParserCsvLineService();

        for (int i = 1; i < recordsFromFile.size(); i++) {
            transactions.add(parser.parseLine(recordsFromFile.get(i)));
        }
        TransactionStrategy strategy = new TransactionStrategyImpl(handlersMap);
        strategy.execute(transactions);
        ReportService reportToCsv = new ReportToCsvService();
        reportToCsv.generateReport();
    }
}
