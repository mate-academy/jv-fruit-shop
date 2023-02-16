import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitShopService;
import service.ReaderService;
import service.ReportService;
import service.ReportWriterService;
import service.TransactionParser;
import serviceimpl.FruitShopServiceImpl;
import serviceimpl.ReaderServiceImpl;
import serviceimpl.ReportServiceImpl;
import serviceimpl.ReportWriterServiceImpl;
import serviceimpl.TransactionParserImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.impl.BalanceOperationHandler;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseOperationHandler;
import strategy.impl.ReturnOperationHandler;
import strategy.impl.SupplyOperationHandler;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        ReaderService readerService = new ReaderServiceImpl();
        List<String> processedData = readerService.read("src/main/java/resources/transactions.csv");

        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactionList =
                transactionParser.parseTransactions(processedData);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        fruitShopService.processTransaction(fruitTransactionList);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.report();

        ReportWriterService reportWriterService = new ReportWriterServiceImpl();
        reportWriterService.write(report);

    }
}
