import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitShopService;
import service.FruitTransactionParser;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import service.impl.FruitShopServiceImpl;
import service.impl.FruitTransactionParserImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategyImpl;
import strategy.handler.BalanceOperationHandler;
import strategy.handler.PurchaseOperationHandler;
import strategy.handler.ReturnOperationHandler;
import strategy.handler.SupplyOperationHandler;

public class Main {
    private static final String INPUT_REPORT_CSV = "src/main/resources/input_report.csv";
    private static final String BALANCE_REPORT_CSV = "src/main/resources/Balance_Report.csv";
    private static ReaderService readerService = new ReaderServiceImpl();
    private static WriterService writerService = new WriterServiceImpl();
    private static FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
    private static Map<FruitTransaction.Operation, OperationHandler> operationHalndlerMap =
            new HashMap<>();
    private static FruitShopService fruitShopService =
            new FruitShopServiceImpl(new OperationStrategyImpl(operationHalndlerMap));
    private static ReportService reportService = new ReportServiceImpl();

    public static void main(String[] args) {
        operationHalndlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHalndlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHalndlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHalndlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        List<String> storeActivitiesFromFile = readerService.readFromFile(INPUT_REPORT_CSV);
        List<FruitTransaction> fruitTransactions = fruitTransactionParser
                .parseFruitTransaction(storeActivitiesFromFile);
        fruitShopService.processOfOperations(fruitTransactions);
        String reportStringForWriting = reportService.getReport();
        writerService.writeToFile(reportStringForWriting, BALANCE_REPORT_CSV);
    }
}
