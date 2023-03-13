import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitShopService;
import service.ReaderService;
import service.ReportMakerService;
import service.TransactionParserService;
import service.WriterService;
import service.impl.FruitShopServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportMakerServiceImpl;
import service.impl.TransactionParserServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.OperationHandler;
import strategy.impl.BalanceOperationImpl;
import strategy.impl.OperationStrategyServiceImpl;
import strategy.impl.PurchaseOperationImpl;
import strategy.impl.ReturnOperationImpl;
import strategy.impl.SupplyOperationImpl;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/fromfile.csv";
    private static final String OUTPUT_FILE = "src/main/resources/tofile.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationImpl());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationImpl());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationImpl());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationImpl());

        ReaderService readerService = new ReaderServiceImpl();
        TransactionParserService transactionParserService = new TransactionParserServiceImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl(
                new OperationStrategyServiceImpl(operationHandlerMap));
        ReportMakerService reportMakerService = new ReportMakerServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        List<FruitTransaction> parsed = transactionParserService.parse(
                readerService.readFromFile(INPUT_FILE));
        Map<String, Integer> preparedMapForWrite = fruitShopService.report(parsed);
        String reportToFile = reportMakerService.makeReport(preparedMapForWrite);
        writerService.writeToFile(reportToFile, OUTPUT_FILE);
    }
}
