import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Transaction;
import service.Handler;
import service.ReaderService;
import service.ReportCreator;
import service.TransactionMapper;
import service.TransactionProcessor;
import service.WriterService;
import service.impl.ReaderServiceImpl;
import service.impl.ReportCreatorImpl;
import service.impl.TransactionMapperImpl;
import service.impl.TransactionProcessorImpl;
import service.impl.WriterServiceImpl;
import strategy.handler.BalanceHandler;
import strategy.handler.PurchaseHandler;
import strategy.handler.ReturnHandler;
import strategy.handler.SupplyHandler;

public class Main {
    public static void main(String[] args) {
        Map<Transaction.Operation, Handler> operationStrategies = new HashMap<>();
        operationStrategies.put(Transaction.Operation.BALANCE, new BalanceHandler());
        operationStrategies.put(Transaction.Operation.PURCHASE, new PurchaseHandler());
        operationStrategies.put(Transaction.Operation.SUPPLY, new SupplyHandler());
        operationStrategies.put(Transaction.Operation.RETURN, new ReturnHandler());
        ReaderService reader = new ReaderServiceImpl();
        List<String> records = reader.read("src/main/resources/test1");
        TransactionMapper mapper = new TransactionMapperImpl();
        List<Transaction> transactions = mapper.map(records);
        TransactionProcessor processor = new TransactionProcessorImpl(operationStrategies);
        processor.process(transactions);
        ReportCreator creator = new ReportCreatorImpl();
        String report = creator.create();
        WriterService writer = new WriterServiceImpl();
        writer.write(report, "src/main/resources/test1_report");
    }
}
