import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.HashMap;
import java.util.Map;
import service.ProcessorServiceImpl;
import service.FileReaderService;
import service.ReaderServiceImpl;
import service.ReportService;
import service.ReportServiceImpl;
import service.FileWriterService;
import service.TransactionProcessorService;
import service.WriterServiceImpl;
import strategy.TransactionStrategy;
import strategy.TransactionStrategyImpl;
import transaction.BalanceTransactionHandler;
import transaction.PurchaseTransactionHandler;
import transaction.ReturnTransactionHandler;
import transaction.SupplyTransactionHandler;
import transaction.TransactionHandler;

public class Main {

    public static void main(String[] args) {
        Map<String, TransactionHandler> transactionHandlersMap = new HashMap<>();
        transactionHandlersMap.put("b", new BalanceTransactionHandler());
        transactionHandlersMap.put("s", new SupplyTransactionHandler());
        transactionHandlersMap.put("p", new PurchaseTransactionHandler());
        transactionHandlersMap.put("r", new ReturnTransactionHandler());

        FruitDao dao = new FruitDaoImpl();
        TransactionStrategy strategy = new TransactionStrategyImpl(transactionHandlersMap);

        FileReaderService readerService = new ReaderServiceImpl();
        TransactionProcessorService processorService = new ProcessorServiceImpl(dao, strategy);
        ReportService reportService = new ReportServiceImpl(dao);
        FileWriterService writerService = new WriterServiceImpl();

        processorService.process(readerService.readFile("src/main/java/resources /file.csv"));
        writerService.writeFile(reportService.makeReport(), "src/main/java/resources /file.csv");
    }
}
