import model.FruitTransaction;
import service.FileWriterService;
import service.ShopService;
import service.impl.FileReaderServiceImpl;
import service.impl.BalanceOperationTransactionImpl;
import service.impl.PurchaseOperationTransactionImpl;
import service.impl.ReportServiceImpl;
import service.impl.ReturnOperationTransactionImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.ShopServiceImpl;
import service.impl.SupplyOperationTransactionImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.impl.TransactionParseImpl;
import service.operation.OperationTransaction;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    public static void main(String[] args) {
        String fileRead = "src/main/resources/data.csv";
        List<String> dataContent = new FileReaderServiceImpl().readFromFile(fileRead);
        Map<FruitTransaction.Operation, OperationTransaction> operationOperationTransactionMap
                = new HashMap<>();
        operationOperationTransactionMap
                .put(FruitTransaction.Operation.BALANCE, new BalanceOperationTransactionImpl());
        operationOperationTransactionMap
                .put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationTransactionImpl());
        operationOperationTransactionMap
                .put(FruitTransaction.Operation.SUPPLY, new SupplyOperationTransactionImpl());
        operationOperationTransactionMap
                .put(FruitTransaction.Operation.RETURN, new ReturnOperationTransactionImpl());
        OperationStrategy operationStrategy
                = new OperationStrategyImpl(operationOperationTransactionMap);
        List<FruitTransaction> transactionList
                = new TransactionParseImpl().transactionParse(dataContent);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.shopTransactions(transactionList);
        String report = new ReportServiceImpl().createReport();
        String fileWrite = "src/main/resources/report.csv";
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.fileWriter(report, fileWrite);
    }
}
