import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Transaction;
import service.ReaderService;
import service.ReportCreator;
import service.Strategy;
import service.TransactionMapper;
import service.TransactionProcessor;
import service.WriterService;
import service.impl.ReaderServiceImpl;
import service.impl.ReportCreatorImpl;
import service.impl.TransactionMapperImpl;
import service.impl.TransactionProcessorImpl;
import service.impl.WriterServiceImpl;
import strategy.BalanceStrategy;
import strategy.PurchaseStrategy;
import strategy.ReturnStrategy;
import strategy.SupplyStrategy;

public class Main {
    public static void main(String[] args) {
        Map<Transaction.Operation, Strategy> operationStrategies = new HashMap<>();
        operationStrategies.put(Transaction.Operation.BALANCE, new BalanceStrategy());
        operationStrategies.put(Transaction.Operation.PURCHASE, new PurchaseStrategy());
        operationStrategies.put(Transaction.Operation.SUPPLY, new SupplyStrategy());
        operationStrategies.put(Transaction.Operation.RETURN, new ReturnStrategy());
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
