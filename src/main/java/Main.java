import dao.FruitDao;
import dao.impl.FruitDaoImpl;
import java.util.HashMap;
import java.util.Map;
import model.Transaction;
import service.ParserService;
import service.ReaderService;
import service.WriterService;
import service.impl.ParserServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriteServiceImpl;
import service.strategy.TransactionHandler;
import service.strategy.impl.BalanceHandler;
import service.strategy.impl.PurchaseHandler;
import service.strategy.impl.ReturnHandler;
import service.strategy.impl.SupplyHandler;

public class Main {
    private static final String INPUT_CSV_PATH = "src/main/resources/input.csv";
    private static final String REPORT_CSV_PATH = "src/main/resources/report.csv";
    private static final FruitDao FRUIT_DAO = new FruitDaoImpl();
    private static final ReaderService READER = new ReaderServiceImpl();
    private static final ParserService PARSER = new ParserServiceImpl();
    private static final WriterService WRITER = new WriteServiceImpl();

    public static void main(String[] args) {
        Map<Transaction.Operation, TransactionHandler> transactionMap = new HashMap<>();
        transactionMap.put(Transaction.Operation.BALANCE, new BalanceHandler(FRUIT_DAO));
        transactionMap.put(Transaction.Operation.PURCHASE, new PurchaseHandler(FRUIT_DAO));
        transactionMap.put(Transaction.Operation.RETURN, new ReturnHandler(FRUIT_DAO));
        transactionMap.put(Transaction.Operation.SUPPLY, new SupplyHandler(FRUIT_DAO));
        PARSER.parse(READER.readFrom(INPUT_CSV_PATH)).forEach(transaction ->
                transactionMap.get(transaction.getOperation()).apply(transaction));
        WRITER.writeTo(REPORT_CSV_PATH, new ReportServiceImpl(FRUIT_DAO).createReport());
    }
}
