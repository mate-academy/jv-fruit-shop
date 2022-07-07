import dao.FruitDao;
import dao.FruitDaoImpl;
import service.ProcessorService;
import service.ProcessorServiceImpl;
import service.ReaderService;
import service.ReaderServiceImpl;
import service.ReportService;
import service.ReportServiceImpl;
import service.WriterService;
import service.WriterServiceImpl;
import strategy.TransactionStrategy;
import strategy.TransactionStrategyImpl;
import transaction.BalanceTransactionHandler;
import transaction.PurchaseTransactionHandler;
import transaction.ReturnTransactionHandler;
import transaction.SupplyTransactionHandler;
import transaction.TransactionHandler;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, TransactionHandler> transactionHandlersMap = new HashMap<>();
        transactionHandlersMap.put("b", new BalanceTransactionHandler());
        transactionHandlersMap.put("s", new SupplyTransactionHandler());
        transactionHandlersMap.put("p", new PurchaseTransactionHandler());
        transactionHandlersMap.put("r", new ReturnTransactionHandler());

        FruitDao dao = new FruitDaoImpl();
        TransactionStrategy strategy = new TransactionStrategyImpl(transactionHandlersMap);

        ReaderService readerService = new ReaderServiceImpl();
        ProcessorService processorService = new ProcessorServiceImpl(dao, strategy);
        ReportService reportService = new ReportServiceImpl(dao);
        WriterService writerService = new WriterServiceImpl();


        processorService.processData(readerService.readFile("src/main/java/resources/file.csv"));
        writerService.writeFile(reportService.makeReport(), "/resources/report.csv");
    }
}
