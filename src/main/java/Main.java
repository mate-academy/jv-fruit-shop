import model.FruitTransaction;
import service.FileWriterService;
import service.ShopService;
import service.impl.*;
import service.operation.OperationTransaction;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String fileRead = "src/main/resources/data.csv";
        String fileWrite = "src/main/resources/report.csv";
        List<String> dataContent = new FileReaderServiceImpl().readFromFile(fileRead);
        List<FruitTransaction> transactionList = new TransactionParseImpl().transactionParse(dataContent);
        Map<FruitTransaction.Operation, OperationTransaction> operationOperationTransactionMap
                = new HashMap<>();
        operationOperationTransactionMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationTransactionImpl());
        operationOperationTransactionMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationTransactionImpl());
        operationOperationTransactionMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationTransactionImpl());
        operationOperationTransactionMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationTransactionImpl());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationOperationTransactionMap);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.shopTransactions(transactionList);
        String report = new ReportServiceImpl().createReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.fileWriter(report, fileWrite);
    }
}
