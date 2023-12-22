package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataCollector;
import service.impl.ParserImpl;
import service.impl.ReaderImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.WriterImpl;
import strategy.TransactionService;
import strategy.TransactionStrategy;
import strategy.impl.TransactionServiceBalance;
import strategy.impl.TransactionServicePurchase;
import strategy.impl.TransactionServiceReturn;
import strategy.impl.TransactionServiceSupply;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, TransactionService> operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE, new TransactionServiceBalance());
        operationMap.put(FruitTransaction.Operation.RETURN, new TransactionServiceReturn());
        operationMap.put(FruitTransaction.Operation.SUPPLY, new TransactionServiceSupply());
        operationMap.put(FruitTransaction.Operation.PURCHASE, new TransactionServicePurchase());

        String fileWithTransactions = "src/main/resources/testTransactions.csv";
        String fileWithReport = "src/main/resources/testReport.csv";

        String transactionsData = new ReaderImpl().read(fileWithTransactions);
        List<FruitTransaction> transactions = new ParserImpl().getTransactions(transactionsData);
        TransactionStrategy strategy = new TransactionStrategy(operationMap);
        DataCollector dataCollector = new DataCollector(strategy);
        dataCollector.applyTransactionsToDatabase(transactions);
        String report = new ReportGeneratorImpl().getReportFromDB();
        new WriterImpl().write(report, fileWithReport);

        // check final file content:
        System.out.println(new ReaderImpl().read(fileWithReport));
    }
}

