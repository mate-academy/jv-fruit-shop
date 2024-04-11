package fruit.shop;

import fruit.shop.model.FruitTransaction;
import fruit.shop.model.TransactionType;
import fruit.shop.service.ReaderService;
import fruit.shop.service.ReaderServiceImpl;
import fruit.shop.service.ReportService;
import fruit.shop.service.ReportServiceImpl;
import fruit.shop.service.TransactionParserService;
import fruit.shop.service.TransactionParserServiceImpl;
import fruit.shop.service.TransactionStrategy;
import fruit.shop.service.TransactionStrategyImpl;
import fruit.shop.service.WriterService;
import fruit.shop.service.WriterServiceImpl;
import fruit.shop.service.transaction.BalanceTransactionHandler;
import fruit.shop.service.transaction.PurchaseTransactionHandler;
import fruit.shop.service.transaction.ReturnTransactionHandler;
import fruit.shop.service.transaction.SupplyTransactionHandler;
import fruit.shop.service.transaction.TransactionHandler;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<TransactionType, TransactionHandler> transactionHandlerMap = Map.ofEntries(
                Map.entry(TransactionType.BALANCE, new BalanceTransactionHandler()),
                Map.entry(TransactionType.SUPPLY, new SupplyTransactionHandler()),
                Map.entry(TransactionType.PURCHASE, new PurchaseTransactionHandler()),
                Map.entry(TransactionType.RETURN, new ReturnTransactionHandler())
        );
        String csvFolderPath = "src/main/resources/";

        ReaderService readerService = new ReaderServiceImpl();
        TransactionParserService transactionParser = new TransactionParserServiceImpl();
        TransactionStrategy transactionStrategy =
                new TransactionStrategyImpl(transactionHandlerMap);
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> readFile = readerService.readFromFile(csvFolderPath + "Balance.csv");
        List<FruitTransaction> parsedTransactions = transactionParser.parse(readFile);
        for (FruitTransaction ft : parsedTransactions) {
            transactionStrategy.executeTransaction(ft);
        }
        String report = reportService.generateReport();
        writerService.saveReport(report, csvFolderPath);
    }
}
