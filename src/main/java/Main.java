import dao.FruitDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Transaction;
import service.Parser;
import service.ReaderService;
import service.ReportService;
import service.impl.ParserImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.ValidatorImpl;
import service.impl.WriterServiceImpl;
import service.strategy.AddHandler;
import service.strategy.OptionHandler;
import service.strategy.PurchaseHandler;

public class Main {
    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceImpl();
        List<String> lines = reader.readFromFile("src/main/resources/input.csv");
        Parser parser = new ParserImpl(new ValidatorImpl());

        Map<String, OptionHandler> options = new HashMap<>();
        options.put("b", new AddHandler(new FruitDaoImpl()));
        options.put("s", new AddHandler(new FruitDaoImpl()));
        options.put("p", new PurchaseHandler(new FruitDaoImpl()));
        options.put("r", new AddHandler(new FruitDaoImpl()));

        List<Transaction> transactions = parser.parse(lines);
        for (Transaction transaction : transactions) {
            String operation = transaction.getOperation();
            OptionHandler handler = options.get(operation);
            handler.apply(transaction);
        }

        ReportService reportService = new ReportServiceImpl(new FruitDaoImpl());
        new WriterServiceImpl().writeToFile(reportService.createReport(),
                "src/main/resources/output.csv");
    }
}
